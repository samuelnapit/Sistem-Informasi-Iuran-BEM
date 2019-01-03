package com.example.controller;

import com.example.service.PengumumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final PengumumanService pengumumanService;

    @Autowired
    public IndexController(PengumumanService pengumumanService) {
        this.pengumumanService = pengumumanService;
    }

    @RequestMapping("/bendaharakelas/index")
    public String indexKelas(Model model)
    {
        model.addAttribute("pengumuman", pengumumanService.listPengumuman());
        return "index/bendaharakelas";
    }

    @RequestMapping("bendaharabem/index")
    public String indexBem(Model model)
    {
        model.addAttribute("pengumuman", pengumumanService.listPengumuman());
        return "index/bendaharabem";
    }
}
