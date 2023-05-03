package com.example.course.controller.mysql.payment;
/*
 * author Fushtei Maksym
 * project course
 * classname MySQLPaymentController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/21/2022
 * Copyright notice
 */

import com.example.course.form.PaymentForm;
import com.example.course.model.mongo.PaymentStatus;
import com.example.course.model.mysql.MySQLPayment;
import com.example.course.service.mysql.contract.impls.ContractMySQLServiceImpls;
import com.example.course.service.mysql.payment.impls.PaymentMySQLServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ui/v1/mysql/payments")
public class MySQLPaymentController {

    @Autowired
    PaymentMySQLServiceImpl paymentService;


    @Autowired
    ContractMySQLServiceImpls contractService;

    @GetMapping("/")
    public String showAll(Model model){
        List<MySQLPayment> list = paymentService.getAll();
        model.addAttribute("payments", list);
        model.addAttribute("dbname", "mysql");

        return "payments-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        paymentService.delete(id);
        return "redirect:/ui/v1/mysql/payments/";
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String addPayment(Model model){
        PaymentForm paymentForm = new PaymentForm();

        List<String> contractList = contractService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getName())
                .collect(Collectors.toList());


        model.addAttribute("payment-form", paymentForm);
        model.addAttribute("contracts", contractList);
        return "myadd-payment";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addPayment(@ModelAttribute("payment-form") PaymentForm paymentForm,
                             @RequestParam(value = "postponeCheck", defaultValue = "false") boolean postponeCheck,
                             @RequestParam(value = "privilegeCheck", defaultValue = "false") boolean privilegeCheck
                             ){
        MySQLPayment payment = new MySQLPayment();
        payment.setDescription(paymentForm.getDescription());
        payment.setContract(contractService.get(Long.valueOf(paymentForm.getContract().split(": ")[0])));
        payment.setPaidAmount(paymentForm.getPaidAmount());
        payment.setPaidAt(LocalDate.now());
        payment.setPostponePayment(postponeCheck);
        payment.setPayTo(payment.isPostponePayment() ? payment.getContract().getGroup().getStartDate().plusMonths(1)
                : payment.getContract().getGroup().getStartDate());
        payment.setPrivilege(privilegeCheck);
        payment.setTotalAmount(payment.getContract().getGroup().getTotalPrice());
        payment.setPaymentStatus(payment.getTotalAmount() <= payment.getPaidAmount() ? PaymentStatus.ОПЛАЧЕНО :
                payment.getTotalAmount() > payment.getPaidAmount() && payment.getPaidAmount() != 0 ? PaymentStatus.ЧАСТКОВО :
                        PaymentStatus.ОЧІКУВАННЯ);
        LocalDateTime timeNow = LocalDateTime.now();
        payment.setUpdatedAt(timeNow);
        payment.setCreatedAt(timeNow);
        paymentService.create(payment);
        return "redirect:/ui/v1/mysql/payments/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPayment(Model model, @PathVariable("id") Long id){
        MySQLPayment payment = paymentService.get(id);
        PaymentForm paymentForm = new PaymentForm();
        paymentForm.setId(String.valueOf(payment.getId()));
        paymentForm.setDescription(payment.getDescription());
        paymentForm.setContract(payment.getContract().getId() + ": " + payment.getContract().getName());
        List<String> contractList = contractService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getName())
                .collect(Collectors.toList());
        paymentForm.setPaidAmount(payment.getPaidAmount());

        model.addAttribute("payment-form", paymentForm);
        model.addAttribute("contracts", contractList);

        return "edit-payment";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editSubject(@PathVariable("id") Long id,
                              @ModelAttribute("payment-form") PaymentForm paymentForm,
                              @RequestParam(value = "postponeCheck", defaultValue = "false") boolean postponeCheck,
                              @RequestParam(value = "privilegeCheck", defaultValue = "false") boolean privilegeCheck
    ){
        MySQLPayment payment = paymentService.get(id);
        payment.setDescription(paymentForm.getDescription());
        payment.setContract(contractService.get(Long.valueOf(paymentForm.getContract().split(": ")[0])));
        payment.setPaidAmount(paymentForm.getPaidAmount());
        payment.setPaidAt(LocalDate.now());
        payment.setPostponePayment(postponeCheck);
        payment.setPayTo(payment.isPostponePayment() ? payment.getContract().getGroup().getStartDate().plusMonths(1)
                : payment.getContract().getGroup().getStartDate());
        payment.setPrivilege(privilegeCheck);
        payment.setTotalAmount(payment.getContract().getGroup().getTotalPrice());
        payment.setPaymentStatus(payment.getTotalAmount() <= payment.getPaidAmount() ? PaymentStatus.ОПЛАЧЕНО :
                payment.getTotalAmount() > payment.getPaidAmount() && payment.getPaidAmount() != 0 ? PaymentStatus.ЧАСТКОВО :
                        PaymentStatus.ОЧІКУВАННЯ);
        paymentService.update(payment);
        return "redirect:/ui/v1/mysql/payments/";
    }

    @RequestMapping(value = "/pay/{id}", method = RequestMethod.GET)
    public String fullPay(Model model, @PathVariable("id") Long id){
        MySQLPayment payment = paymentService.get(id);
        PaymentForm paymentForm = new PaymentForm();
        paymentForm.setId(payment.getId().toString());
        String contract = payment.getContract().getName();
        int remaining = payment.getTotalAmount() - payment.getPaidAmount();
        paymentForm.setPaidAmount(remaining);
        model.addAttribute("fullPayment-form", paymentForm);
        model.addAttribute("contract", contract);
        model.addAttribute("remaining", remaining);
        return "mypay-payment";
    }

    @RequestMapping(value = "/pay/{id}", method = RequestMethod.POST)
    public String fullPay(@PathVariable("id") Long id,
                          @ModelAttribute("fullPayment-form") PaymentForm paymentForm){
        MySQLPayment payment = paymentService.get(id);
        payment.setPaidAmount(paymentForm.getPaidAmount() + payment.getPaidAmount());
        payment.setPaidAt(LocalDate.now());
        payment.setPaymentStatus(payment.getTotalAmount() <= payment.getPaidAmount() ? PaymentStatus.ОПЛАЧЕНО :
                payment.getTotalAmount() > payment.getPaidAmount() && payment.getPaidAmount() != 0 ? PaymentStatus.ЧАСТКОВО :
                        PaymentStatus.ОЧІКУВАННЯ);
        paymentService.update(payment);
        return "redirect:/ui/v1/mysql/payments/";
    }


}
