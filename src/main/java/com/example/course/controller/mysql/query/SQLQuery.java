package com.example.course.controller.mysql.query;
/*
 * author Fushtei Maksym
 * project course
 * classname SQLQuery
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/28/2022
 * Copyright notice
 */

import com.example.course.form.ContractLanguageForm;
import com.example.course.form.GroupForm;
import com.example.course.form.QueryForm;
import com.example.course.model.mongo.Level;
import com.example.course.model.mysql.*;
import com.example.course.service.mysql.contract.impls.ContractMySQLServiceImpls;
import com.example.course.service.mysql.exam.impls.ExamMySQLServiceImpl;
import com.example.course.service.mysql.group.impls.GroupMySQLServiceImpl;
import com.example.course.service.mysql.language.impls.LanguageMySQLServiceImpl;
import com.example.course.service.mysql.payment.impls.PaymentMySQLServiceImpl;
import com.example.course.service.mysql.schedule.impls.ScheduleMySQLServiceImpl;
import com.example.course.service.mysql.student.impls.StudentMySQLServiceImpl;
import com.example.course.service.mysql.studentExam.impls.StudentExamMySQLServiceImpls;
import com.example.course.service.mysql.teacher.impls.TeacherMySQLServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ui/v1/mysql/query")
public class SQLQuery {

    @Autowired
    LanguageMySQLServiceImpl languageMySQLService;

    @Autowired
    StudentExamMySQLServiceImpls studentExamMySQLService;

    @Autowired
    ExamMySQLServiceImpl examMySQLService;

    @Autowired
    GroupMySQLServiceImpl groupMySQLService;

    @Autowired
    TeacherMySQLServiceImpl teacherMySQLService;

    @Autowired
    PaymentMySQLServiceImpl paymentMySQLService;

    @Autowired
    ContractMySQLServiceImpls contractMySQLServiceImpls;

    @Autowired
    StudentMySQLServiceImpl studentMySQLService;

    @Autowired
    ScheduleMySQLServiceImpl scheduleMySQLService;

    @GetMapping("/")
    public String showAll(Model model){
        model.addAttribute("dbname","mysql");
        return "query-all";
    }


    @GetMapping("/1")
    public String showGroupByLanguage(Model model){
        QueryForm queryForm = new QueryForm();
        List<String> languages = languageMySQLService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getName())
                .collect(Collectors.toList());
        model.addAttribute("languages", languages);
        model.addAttribute("query-form", queryForm);
        return "first-query-select";

    }
    @PostMapping("/1")
    public String showGroupByLanguage(@ModelAttribute("query-form") QueryForm queryForm, Model model){
        List<MySQLGroup> list = groupMySQLService.getByLanguage(Long.valueOf(queryForm.getLanguage().split(": ")[0]));
        model.addAttribute("groups", list);
        model.addAttribute("dbname", "mysql");
        return "first-query-all";    }

    @GetMapping("/2")
    public String showGroupByTeacher(Model model){
        QueryForm queryForm = new QueryForm();
        List<String> teachers = teacherMySQLService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getLastName() + " " + name.getFirstName() + " " + name.getPatronymic()
                )
                .collect(Collectors.toList());
        model.addAttribute("teachers", teachers);
        model.addAttribute("query-form", queryForm);
        return "second-query-select";
    }

    @PostMapping("/2")
    public String showGroupByTeacher(@ModelAttribute("query-form") QueryForm queryForm, Model model){
        List<MySQLGroup> list = groupMySQLService.getByTeacher(Long.valueOf(queryForm.getTeacher().split(": ")[0]));
        model.addAttribute("groups", list);
        model.addAttribute("dbname", "mysql");
        return "first-query-all";
    }

    public String calculateTotal(int startPrice, List<Level> levels){

        double total = startPrice;
        double totalPrice = 0;
        for (Level lev: levels) {
            total *= 1.25;
            totalPrice += total;
        }
        return String.valueOf(Math.round(totalPrice));
    }


    @RequestMapping(value = "/3", method = RequestMethod.GET)
    public String showLanguage(Model model){
        List<MySQLLanguage> languageList = languageMySQLService.getAll();
        List<String> pricePerLanguage = new ArrayList<>();
        for (MySQLLanguage language: languageList) {
          pricePerLanguage.add(language.getName() + ": " + calculateTotal(language.getStartPricePerLevel(), language.getLevelList()));
        }

        List<String> languages = languageMySQLService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getName())
                .collect(Collectors.toList());
        GroupForm groupForm = new GroupForm();
        model.addAttribute("pricelist", pricePerLanguage);
        model.addAttribute("languages", languages);
        model.addAttribute("form", groupForm);
        model.addAttribute("dbname", "mysql");
        return "second-query-show";
    }

    private List<String> getListOfPrice(int startPrice, List<Level> levels){
        double total = startPrice;
        List<String> priceLevel = new ArrayList<>();
        for (Level lev: levels) {
            priceLevel.add(lev + ": " + Math.round(total));
            total *= 1.25;
        }
        return priceLevel;
    }

    @RequestMapping(value = "/3", method = RequestMethod.POST)
    public String showLanguage(@ModelAttribute("form") GroupForm groupForm, Model model){
        MySQLLanguage language = languageMySQLService.get(Long.valueOf(groupForm.getLanguage().split(": ")[0]));
        String total = calculateTotal(language.getStartPricePerLevel(), language.getLevelList());
        List<String> prices = getListOfPrice(language.getStartPricePerLevel(), language.getLevelList());
        List<String> pricePerMonth = new ArrayList<>();
        for (String price:prices) {
           int onePrice = Integer.parseInt(price.split(": ")[1]) / 3;
           pricePerMonth.add(price.split(": ")[0] + ": " + onePrice);
        }
        model.addAttribute("language", language.getName());
        model.addAttribute("totalPrice", total);
        model.addAttribute("prices", prices);
        model.addAttribute("priceMonth", pricePerMonth);
        model.addAttribute("dbname", "mysql");

        return "second-query-extend-show";
    }

    @GetMapping("/5")
    public String show(Model model){
        List<MySQLStudentExam> list = studentExamMySQLService.getStudentByCertificate();
        List<Long> listExamsId = studentExamMySQLService.getExamsId();
        List<Level> levels = new ArrayList<>();
        for (Long examId : listExamsId){
            levels.add(examMySQLService.get(examId).getGroup().getLevel());
        }
        int amount = studentExamMySQLService.getAmountOfStudent();
        model.addAttribute("levels", levels);
        model.addAttribute("studentexams", list);
        model.addAttribute("amount", amount);
        model.addAttribute("dbname", "mysql");
        return "third-query-all";
    }


    @GetMapping("/6")
    public String showTeacherAndLanguage(Model model){
        List<String> listTeachers = groupMySQLService.getTeacherAndLanguage();
        List<MySQLTeacher> list1 = new ArrayList<>();
        List<MySQLTeacher> list2 = new ArrayList<>();
        List<MySQLTeacher> list3 = new ArrayList<>();
        for(String teacher:  listTeachers){
            if(teacher.split(",")[1].equals("1"))
                list1.add(teacherMySQLService.get(Long.valueOf(teacher.split(",")[0])));
            if(teacher.split(",")[1].equals("2"))
                list2.add(teacherMySQLService.get(Long.valueOf(teacher.split(",")[0])));
            if(teacher.split(",")[1].equals("3"))
                list3.add(teacherMySQLService.get(Long.valueOf(teacher.split(",")[0])));
        }
        model.addAttribute("list1", list1);
        model.addAttribute("list2", list2);
        model.addAttribute("list3", list3);
        model.addAttribute("dbname", "mysql");
        return "fourth-query-all";
    }

    @GetMapping("/7")
    public String showPaymentStudents(Model model){
        List<MySQLPayment> fullPaymentList = paymentMySQLService.getFullPayment();
        List<MySQLPayment> emptyPaymentList = paymentMySQLService.getEmpty();
        List<MySQLPayment> partPaymentList = paymentMySQLService.getPartPayment();
        List<MySQLPayment> postponePaymentList = paymentMySQLService.getPostponePayment();
        List<MySQLPayment> privilegePaymentList = paymentMySQLService.getPrivilegePayment();
        model.addAttribute("payments1", fullPaymentList);
        model.addAttribute("payments2", emptyPaymentList);
        model.addAttribute("payments3", partPaymentList);
        model.addAttribute("payments4", postponePaymentList);
        model.addAttribute("payments5", privilegePaymentList);
        model.addAttribute("dbname","mysql");
        return "fifth-query-all";
    }

    @GetMapping("/8")
    public String showStudents(Model model){
        List<MySQLStudent> students = new ArrayList<>();
        for(MySQLContract contract :contractMySQLServiceImpls.getContractsByStudent()){
            students.add(contract.getStudent());
            List<MySQLContract> contractList = contractMySQLServiceImpls.getByStudentId(contract.getStudent().getId());
            for (MySQLContract studentContract : contractList){
                MySQLPayment payment = paymentMySQLService.getPaymentsByContractId(studentContract.getId());
                payment.setTotalAmount((int) (payment.getTotalAmount() * 0.9));
                paymentMySQLService.update(payment);
            }

        }
        model.addAttribute("students",students);
        model.addAttribute("dbname","mysql");
        return "sixth-query-all";
    }

    @GetMapping("/9")
    public String showGermanyStudent(Model model){
        List<Long> list = groupMySQLService.getByGermany();
        List<MySQLContract> contractList = contractMySQLServiceImpls.getByGroupId(list);
        List<MySQLContract> contractList1 = contractMySQLServiceImpls.getContractsByStudentMoreOneLanguage();
        List<ContractLanguageForm> contractLanguageFormList = new ArrayList<>();
        for (MySQLContract contract: contractList1){
            List<MySQLLanguage> languages = new ArrayList<>();
            for (MySQLContract contract1 : contractMySQLServiceImpls.getByStudentId(contract.getStudent().getId())){
                languages.add(contract1.getGroup().getLanguage());
            }
            ContractLanguageForm contractLanguageForm = new ContractLanguageForm();
            contractLanguageForm.setId(contract.getStudent().getId());
            contractLanguageForm.setStudent(contract.getStudent().getFullName());
            contractLanguageForm.setLanguages(languages);
            contractLanguageForm.setCreatedAt(contract.getCreatedAt());
            contractLanguageForm.setUpdatedAt(contract.getUpdatedAt());
            contractLanguageFormList.add(contractLanguageForm);
        }

        model.addAttribute("germanyList", contractList);
        model.addAttribute("moreList", contractLanguageFormList);
        model.addAttribute("dbname", "mysql");

        return "seventh-query-all";
    }

    @GetMapping("/10")
    public String showGroups(Model model){
        List<MySQLGroup> groups = groupMySQLService.getByAmountOfStudentsLessThanFive();
        for (MySQLGroup group : groups){
            group.setTotalPrice((int) (group.getTotalPrice() * 1.2));
            groupMySQLService.update(group);
        }
        List<MySQLGroup> groups1 = groupMySQLService.getByAmountOfStudentsEqualsTwenty();
        for (MySQLGroup group : groups1){
            group.setTotalPrice((int) (group.getTotalPrice() * 0.95));
            groupMySQLService.update(group);
        }
        model.addAttribute("groups", groups);
        model.addAttribute("groups1", groups1);
        model.addAttribute("dbname", "mysql");
        return "eighth-query-all";
    }

    @GetMapping("/11")
    public String showScheduleByGroup(Model model){
        QueryForm queryForm = new QueryForm();
        List<String> groupList = groupMySQLService.getAll().stream()
                .map(name -> name.getId() + ": " +  name.getName() + ", " + name.getLanguage().getName() + ", "
                        + name.getLevel())
                .collect(Collectors.toList());
        List<String> teachers = teacherMySQLService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getLastName() + " " + name.getFirstName() + " " + name.getPatronymic()
                )
                .collect(Collectors.toList());
        model.addAttribute("teachers", teachers);
        model.addAttribute("groups", groupList);
        model.addAttribute("query-form", queryForm);
        return "last-query-select";
    }

    @PostMapping("/11")
    public String showScheduleByGroup(@ModelAttribute("query-form") QueryForm queryForm, Model model){
        List<MySQLSchedule> schedules = scheduleMySQLService.getByGroup(Long.valueOf(queryForm.getGroup().split(": ")[0]));
        List<MySQLSchedule> schedules2 = scheduleMySQLService.getByTeacher(Long.valueOf(queryForm.getTeacher().split(": ")[0]));
        model.addAttribute("schedules", schedules);
        model.addAttribute("schedules2", schedules2);
        model.addAttribute("dbname", "mysql");
        return "ninth-query-all";
    }
}
