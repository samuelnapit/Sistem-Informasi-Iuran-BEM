package com.example.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @RequestMapping("/bendaharakelas/index")
    public  String indexKelas() {
        return "index/bendaharakelas";
    }

    @RequestMapping("bendaharabem/index")
    public String indexBem()
    {
        return "index/bendaharabem";
    }
}
