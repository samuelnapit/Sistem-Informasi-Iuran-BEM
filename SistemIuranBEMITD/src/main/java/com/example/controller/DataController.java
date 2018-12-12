package com.example.controller;

import com.example.model.*;
import com.example.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class DataController {

    private MahasiswaService mahasiswaService;

    @Autowired
    public void setMahasiswaService(MahasiswaService mahasiswaService) {
        this.mahasiswaService = mahasiswaService;
    }

    @RequestMapping("/data")
    public String MahasiswaList(Model model)
    {
        model.addAttribute("mahasiswa", mahasiswaService.listMahasiswa());
        return "data/bendaharakelas";
    }

    @RequestMapping(value = "/data/create", method = RequestMethod.GET)
    public  String create(Model model) {
        model.addAttribute("mahasiswa", new Mahasiswa());
        return "formCreate";
    }

    @RequestMapping(value = "/data/viewdetail/{nim}", method = RequestMethod.GET)
    public String viewDetail(@PathVariable String nim, Model model) {
        model.addAttribute("mahasiswa", mahasiswaService.getNim(nim));
        return "viewdetail";
    }
}
