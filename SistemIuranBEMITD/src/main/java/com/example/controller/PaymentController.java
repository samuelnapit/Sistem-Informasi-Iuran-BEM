package com.example.controller;

import com.example.com.example.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaymentController {

    private MahasiswaService mahasiswaService;

    @Autowired
    public void setMahasiswaService(MahasiswaService mahasiswaService) {
        this.mahasiswaService = mahasiswaService;
    }

    @RequestMapping("/payment")
    public String MahasiswaList(Model model)
    {
        model.addAttribute("mahasiswa", mahasiswaService.listMahasiswa());
        return "payment/bendaharakelas";
    }
}
