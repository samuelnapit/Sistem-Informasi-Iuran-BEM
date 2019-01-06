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

    @RequestMapping("/bendaharakelas/payment")
    public String PaymentListKelas(Model model)
    {
        model.addAttribute("payment", paymentService.listPayment());
        return "payment/bendaharakelas";
    }

    @RequestMapping(value = "/bendaharabem/payment/create", method = RequestMethod.GET)
    public  String createPay(Model model) {
        model.addAttribute("payment", new Payment());
        return "form/formCreateTagihan";
    }

    @RequestMapping(value = "/bendaharabem/payment/create", method = RequestMethod.POST)
    public String savePay (Model model, Payment payment) {
        model.addAttribute("payment", paymentService.saveOrUpdatePay(payment));
        return "redirect:/bendaharabem/payment";
    }

    @RequestMapping(value = "/bendaharabem/payment/viewdetail/{id}", method = RequestMethod.GET)
    public String viewDetailPay(@PathVariable Integer id, Model model) {
        model.addAttribute("payment", paymentService.getId(id));
        return "detailTagihan";
    }
}
