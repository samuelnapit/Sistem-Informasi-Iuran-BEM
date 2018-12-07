package com.example.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaymentController {

    @RequestMapping("/payment")
    public String payment() {
        return "payment/bendaharakelas";
    }
}
