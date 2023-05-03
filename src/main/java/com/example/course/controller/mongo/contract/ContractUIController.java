package com.example.course.controller.mongo.contract;
/*
 * author Fushtei Maksym
 * project course
 * classname ContractUIController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/19/2022
 * Copyright notice
 */

import com.example.course.form.ContractForm;
import com.example.course.form.NewStudentContract;
import com.example.course.form.PaymentForm;
import com.example.course.model.mongo.*;
import com.example.course.model.mysql.MySQLContract;
import com.example.course.model.mysql.MySQLGroup;
import com.example.course.model.mysql.MySQLPayment;
import com.example.course.model.mysql.MySQLStudent;
import com.example.course.service.mongo.contract.impls.ContractMongoServiceImpls;
import com.example.course.service.mongo.group.impls.GroupMongoServiceImpl;
import com.example.course.service.mongo.payment.impls.PaymentMongoServiceImpls;
import com.example.course.service.mongo.student.impls.StudentMongoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ui/v1/mongo/contracts")
public class ContractUIController {

    @Autowired
    ContractMongoServiceImpls contractService;

    @Autowired
    StudentMongoServiceImpl studentService;

    @Autowired
    GroupMongoServiceImpl groupService;

    @Autowired
    PaymentMongoServiceImpls paymentService;

    @GetMapping("/")
    public String showAll(Model model){
        List<MongoContract> list = contractService.getAll();
        model.addAttribute("contracts", list);
        model.addAttribute("dbname", "mongo");
        return "contracts-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        MongoGroup group = groupService.getByName(contractService.get(id).getGroup().getName());
        group.setAmountOfStudents(group.getAmountOfStudents() - 1);
        group.setGroupCapacity(group.getAmountOfStudents() >= 5 ? GroupCapacity.ЗАПОВНЕНА : GroupCapacity.НЕЗАПОВНЕНА);
        group.setEducationStatus(group.getAmountOfStudents() >= 5 && group.getStartDate().compareTo(LocalDate.now()) <= 0 ?  EducationStatus.ТРИВАЄ :
                group.getEndDate().compareTo(LocalDate.now()) < 0 ? EducationStatus.ЗАВЕРШЕНО : EducationStatus.ОЧІКУЄТЬСЯ);
        groupService.update(group);
        contractService.delete(id);
        return "redirect:/ui/v1/mongo/contracts/";
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String addContract(Model model){
        ContractForm contractForm = new ContractForm();
        List<MongoStudent> students = studentService.getAll();
        List<MongoGroup> groups = groupService.getAll();
        groups.removeIf(mongoGroup -> mongoGroup.getAmountOfStudents() >= 20 || mongoGroup.getEducationStatus() != EducationStatus.ОЧІКУЄТЬСЯ);


        for (MongoStudent student: studentService.getAll()) {
            for (MongoContract contract: contractService.getAll()) {
                if(contract.getStudent().getId().equals(student.getId())){
                    students.remove(student);
                }
            }
        }

        List<String> studentList = students.stream()
                .map(name -> name.getId() + ": " + name.getFullName())
                .collect(Collectors.toList());
        List<String> groupList = groups.stream()
                .map(name -> name.getName() + ", " + name.getLanguage().getName() + ", "
                        + name.getLevel())
                .collect(Collectors.toList());

        model.addAttribute("contract-form", contractForm);
        model.addAttribute("students", studentList);
        model.addAttribute("groups", groupList);
        model.addAttribute("dbname", "mongo");
        return "add-contract";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addContract(@ModelAttribute("contract-form") ContractForm contractForm,
                              @RequestParam(value = "postponeCheck", defaultValue = "false") boolean postponeCheck,
                              @RequestParam(value = "privilegeCheck", defaultValue = "false") boolean privilegeCheck){
        MongoContract contract = new MongoContract();
        contract.setName(contractForm.getName());
        contract.setDescription(contractForm.getDescription());
        contract.setStudent(studentService.get(contractForm.getStudent().split(": ")[0]));

        MongoGroup group = groupService.getByName(contractForm.getGroup().split(", ")[0]);
        contract.setGroup(group);
        group.setAmountOfStudents(group.getAmountOfStudents() + 1);
        group.setGroupCapacity(group.getAmountOfStudents() >= 5 ? GroupCapacity.ЗАПОВНЕНА : GroupCapacity.НЕЗАПОВНЕНА);
        group.setEducationStatus(group.getAmountOfStudents() >= 5 && group.getStartDate().compareTo(LocalDate.now()) <= 0 ?  EducationStatus.ТРИВАЄ :
                group.getEndDate().compareTo(LocalDate.now()) < 0 ? EducationStatus.ЗАВЕРШЕНО : EducationStatus.ОЧІКУЄТЬСЯ);
        if(group.getAmountOfStudents() >= 5 && group.getStartDate().compareTo(LocalDate.now()) <= 0){
            group.setStartDate(LocalDate.now().plusDays(1));
            group.setEndDate(group.getStartDate().plusMonths(3));
        }
        groupService.update(group);
        contract.setUpdatedAt(LocalDateTime.now());
        contractService.create(contract);

        MongoPayment payment = new MongoPayment();
        payment.setContract(contract);
        payment.setDescription(contractForm.getDescription());
        payment.setPaidAmount(0);
        payment.setPaidAt(LocalDate.now());

        payment.setPostponePayment(postponeCheck);
        payment.setPayTo(payment.isPostponePayment() ? contract.getGroup().getStartDate().plusMonths(1)
                : contract.getGroup().getStartDate());
        payment.setPrivilege(privilegeCheck);
        payment.setTotalAmount(payment.getContract().getGroup().getTotalPrice());
        payment.setPaymentStatus(payment.getTotalAmount() <= payment.getPaidAmount() ? PaymentStatus.ОПЛАЧЕНО :
                payment.getTotalAmount() > payment.getPaidAmount() && payment.getPaidAmount() != 0 ? PaymentStatus.ЧАСТКОВО :
                        PaymentStatus.ОЧІКУВАННЯ);
        LocalDateTime timeNow = LocalDateTime.now();
        payment.setUpdatedAt(timeNow);
        payment.setCreatedAt(timeNow);
        paymentService.create(payment);

        return "redirect:/ui/v1/mongo/contracts/confirm/"+contract.getId();
    }
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addNewStudent(Model model){
        NewStudentContract studentForm = new NewStudentContract();
        List<MongoGroup> groups = groupService.getAll();
        groups.removeIf(mongoGroup -> mongoGroup.getAmountOfStudents() >= 20 || mongoGroup.getEducationStatus() != EducationStatus.ОЧІКУЄТЬСЯ);


        List<String> groupList = groups.stream()
                .map(name -> name.getName() + ", " + name.getLanguage().getName() + ", "
                        + name.getLevel())
                .collect(Collectors.toList());

        model.addAttribute("groups", groupList);
        model.addAttribute("student-form", studentForm);
        model.addAttribute("dbname", "mongo");
        return "add-new-student-contract";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addNewStudent(@ModelAttribute("student-form") NewStudentContract studentContract,
                                @RequestParam(value = "postponeCheck", defaultValue = "false") boolean postponeCheck,
                                @RequestParam(value = "privilegeCheck", defaultValue = "false") boolean privilegeCheck){
        MongoStudent student = new MongoStudent();
        student.setFirstName(studentContract.getFirstName());
        student.setLastName(studentContract.getLastName());
        student.setPatronymic(studentContract.getPatronymic());
        student.setAge(studentContract.getAge());
        student.setPhone(studentContract.getPhone());
        student.setEmail(studentContract.getEmail());
        student.setDescription(studentContract.getDescription());
        LocalDateTime timeNow = LocalDateTime.now();
        student.setCreatedAt(timeNow);
        student.setUpdatedAt(timeNow);
        studentService.create(student);

        MongoContract contract = new MongoContract();
        contract.setName("Новий студент");
        contract.setDescription("Контракт для нового студента");
        contract.setStudent(student);


        MongoGroup group = groupService.getByName(studentContract.getGroup().split(", ")[0]);
        contract.setGroup(group);

        group.setAmountOfStudents(group.getAmountOfStudents() + 1);
        group.setGroupCapacity(group.getAmountOfStudents() >= 5 ? GroupCapacity.ЗАПОВНЕНА : GroupCapacity.НЕЗАПОВНЕНА);
        group.setEducationStatus(group.getAmountOfStudents() >= 5 && group.getStartDate().compareTo(LocalDate.now()) <= 0 ?  EducationStatus.ТРИВАЄ :
                group.getEndDate().compareTo(LocalDate.now()) < 0 ? EducationStatus.ЗАВЕРШЕНО : EducationStatus.ОЧІКУЄТЬСЯ);
        if(group.getAmountOfStudents() >= 5 && group.getStartDate().compareTo(LocalDate.now()) <= 0){
            group.setStartDate(LocalDate.now().plusDays(1));
            group.setEndDate(group.getStartDate().plusMonths(3));
        }
        groupService.update(group);
        contract.setUpdatedAt(LocalDateTime.now());
        contractService.create(contract);

        MongoPayment payment = new MongoPayment();
        payment.setContract(contract);
        payment.setDescription("Оплата для нового студента");
        payment.setPaidAmount(0);
        payment.setPaidAt(LocalDate.now());

        payment.setPostponePayment(postponeCheck);
        payment.setPayTo(payment.isPostponePayment() ? contract.getGroup().getStartDate().plusMonths(1)
                : contract.getGroup().getStartDate());
        payment.setPrivilege(privilegeCheck);
        payment.setTotalAmount(payment.getContract().getGroup().getTotalPrice());
        payment.setPaymentStatus(payment.getTotalAmount() <= payment.getPaidAmount() ? PaymentStatus.ОПЛАЧЕНО :
                payment.getTotalAmount() > payment.getPaidAmount() && payment.getPaidAmount() != 0 ? PaymentStatus.ЧАСТКОВО :
                        PaymentStatus.ОЧІКУВАННЯ);

        payment.setUpdatedAt(timeNow);
        payment.setCreatedAt(timeNow);
        paymentService.create(payment);
        return "redirect:/ui/v1/mongo/contracts/confirm/" + contract.getId();
    }


    @RequestMapping(value = "/confirm/{id}", method = RequestMethod.GET)
    public String confirmContract(Model model, @PathVariable String id){
        MongoContract contract = contractService.get(id);
        String contractName = contract.getName();
        String studentName = contract.getStudent().getFullName();
        String groupName = contract.getGroup().getName();
        int price = contract.getGroup().getTotalPrice();
        String startDate = contract.getGroup().getStartDate().toString();

        model.addAttribute("contractName", contractName);
        model.addAttribute("student", studentName);
        model.addAttribute("group", groupName);
        model.addAttribute("price", price);
        model.addAttribute("startDate", startDate);
        model.addAttribute("dbname", "mongo");
        return "myconfirm-contract";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editContract(Model model, @PathVariable("id") String id){
        MongoContract contract = contractService.get(id);
        ContractForm contractForm = new ContractForm();
        contractForm.setId(contract.getId());
        contractForm.setName(contract.getName());
        contractForm.setDescription(contract.getDescription());
        contractForm.setGroup(contract.getGroup().getName() + ", " + contract.getGroup().getLanguage().getName() +
                ", " + contract.getGroup().getLevel());
        contractForm.setStudent(contract.getStudent().getId() +": "+ contract.getStudent().getFullName());
        List<MongoGroup> groups = groupService.getAll();
        groups.removeIf(mongoGroup -> mongoGroup.getAmountOfStudents() >= 20 || mongoGroup.getEducationStatus() != EducationStatus.ОЧІКУЄТЬСЯ);

        List<String> studentList = studentService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getFullName())
                .collect(Collectors.toList());
        List<String> groupList = groups.stream()
                .map(name -> name.getName() + ", " + name.getLanguage().getName() + ", "
                        + name.getLevel())
                .collect(Collectors.toList());

        model.addAttribute("contract-form", contractForm);
        model.addAttribute("students", studentList);
        model.addAttribute("groups", groupList);
        return "edit-contract";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editContract(@PathVariable("id") String id,
                              @ModelAttribute("contract-form") ContractForm contractForm){
        MongoContract contract = contractService.get(id);
        contract.setName(contractForm.getName());
        contract.setDescription(contractForm.getDescription());
        contract.setStudent(studentService.get(contractForm.getStudent().split(": ")[0]));
        MongoGroup group = groupService.getByName(contractForm.getGroup().split(", ")[0]);
        if(!contract.getGroup().getName().equals(group.getName())) {
            contract.getGroup().setAmountOfStudents(contract.getGroup().getAmountOfStudents() - 1);
            groupService.update(contract.getGroup());
            group.setAmountOfStudents(group.getAmountOfStudents() + 1);
            group.setGroupCapacity(group.getAmountOfStudents() >= 5 ? GroupCapacity.ЗАПОВНЕНА : GroupCapacity.НЕЗАПОВНЕНА);
            group.setEducationStatus(group.getAmountOfStudents() >= 5 && group.getStartDate().compareTo(LocalDate.now()) <= 0 ?  EducationStatus.ТРИВАЄ :
                    group.getEndDate().compareTo(LocalDate.now()) < 0 ? EducationStatus.ЗАВЕРШЕНО : EducationStatus.ОЧІКУЄТЬСЯ);
            if(group.getAmountOfStudents() >= 5 && group.getStartDate().compareTo(LocalDate.now()) <= 0){
                group.setStartDate(LocalDate.now().plusDays(1));
                group.setEndDate(group.getStartDate().plusMonths(3));
            }
        }
        contract.setGroup(group);
        groupService.update(group);

        contract.setUpdatedAt(LocalDateTime.now());
        contractService.update(contract);
        return "redirect:/ui/v1/mongo/contracts/confirm/"+contract.getId();
    }

    @RequestMapping(value = "/new/{id}", method = RequestMethod.GET)
    public String addNewLanguage(Model model, @PathVariable String id){
        ContractForm contractForm = new ContractForm();
        List<MongoGroup> groups = groupService.getAll();
        MongoStudent student = studentService.get(id);


        for(MongoContract contract: contractService.getAll()){
            if(contract.getStudent().getId().equals(student.getId())){
                groups.removeIf(mongoGroup -> mongoGroup.getLanguage().getName().equals(contract.getGroup().getLanguage().getName()));
            }

        }

        groups.removeIf(mongoGroup -> mongoGroup.getAmountOfStudents() >= 20 || mongoGroup.getEducationStatus() != EducationStatus.ОЧІКУЄТЬСЯ);

        List<String> groupList = groups.stream()
                .map(name -> name.getName() + ", " + name.getLanguage().getName() + ", "
                        + name.getLevel())
                .collect(Collectors.toList());

        model.addAttribute("contract-form", contractForm);
        model.addAttribute("student", student.getFullName());
        model.addAttribute("groups1", groupList);
        return "new-contract";
    }

    @RequestMapping(value = "/new/{id}", method = RequestMethod.POST)
    public String addNewLanguage(@ModelAttribute("contract-form") ContractForm contractForm, @PathVariable String id){
        MongoContract contract = new MongoContract();
        contract.setName(contractForm.getName());
        contract.setDescription(contractForm.getDescription());
        contract.setStudent(studentService.get(id));
        MongoGroup group = groupService.getByName(contractForm.getGroup().split(", ")[0]);
        contract.setGroup(group);
        group.setAmountOfStudents(group.getAmountOfStudents() + 1);
        group.setGroupCapacity(group.getAmountOfStudents() >= 5 ? GroupCapacity.ЗАПОВНЕНА : GroupCapacity.НЕЗАПОВНЕНА);
        group.setEducationStatus(group.getAmountOfStudents() >= 5 && group.getStartDate().compareTo(LocalDate.now()) <= 0 ?  EducationStatus.ТРИВАЄ :
                group.getEndDate().compareTo(LocalDate.now()) < 0 ? EducationStatus.ЗАВЕРШЕНО : EducationStatus.ОЧІКУЄТЬСЯ);
        if(group.getAmountOfStudents() >= 5 && group.getStartDate().compareTo(LocalDate.now()) <= 0){
            group.setStartDate(LocalDate.now().plusDays(1));
            group.setEndDate(group.getStartDate().plusMonths(3));
        }
        groupService.update(group);
        contract.setUpdatedAt(LocalDateTime.now());
        contractService.create(contract);
        return "redirect:/ui/v1/mongo/contracts/confirm/"+contract.getId();
    }



}
