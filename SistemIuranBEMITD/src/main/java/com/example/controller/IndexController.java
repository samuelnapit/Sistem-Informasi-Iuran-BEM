package com.example.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public  String indexList() {
        return "index/bendaharakelas";
    }
}
