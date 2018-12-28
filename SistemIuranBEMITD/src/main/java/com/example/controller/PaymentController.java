package com.example.controller;

import com.example.model.*;
import com.example.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping("/bendaharabem/payment")
    public String PaymentList(Model model)
    {
        model.addAttribute("payment", paymentService.listPayment());
        return "payment/bendaharabem";
    }

    @RequestMapping(value = "/bendaharabem/payment/create", method = RequestMethod.GET)
    public  String createPay(Model model) {
        model.addAttribute("payment", new Payment());
        return "formCreateTagihan";
    }

    @RequestMapping(value = "/bendaharabem/payment/create", method = RequestMethod.POST)
    public String savePay (Model model, Payment payment) {
        model.addAttribute("payment", paymentService.saveOrUpdatePay(payment));
        return "redirect:/bendaharabem/payment";
    }
}
