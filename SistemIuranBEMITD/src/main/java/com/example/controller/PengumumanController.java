package com.example.controller;

import com.example.model.Pengumuman;
import com.example.service.PengumumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PengumumanController {

    private PengumumanService pengumumanService;

    @Autowired
    public void setPengumumanService(PengumumanService pengumumanService) {
        this.pengumumanService = pengumumanService;
    }

    @RequestMapping(value = "/bendaharabem/pengumuman/create", method = RequestMethod.GET)
    public  String createPengumuman(Model model) {
        model.addAttribute("pengumuman", new Pengumuman());
        return "form/formcreatepengumuman";
    }

    @RequestMapping(value = "/bendaharabem/pengumuman/create", method = RequestMethod.POST)
    public String savePengumuman (Model model, Pengumuman pengumuman) {
        model.addAttribute("pengumuman", pengumumanService.saveOrUpdatePengumuman(pengumuman));
        return "redirect:/bendaharabem/index";
    }

    @RequestMapping(value = "/bendaharabem/pengumuman/detail/{id}", method = RequestMethod.GET)
    public String viewDetailPengumuman(@PathVariable Integer id, Model model) {
        model.addAttribute("pengumuman", pengumumanService.getId(id));
        return "pengumuman/bendaharabem";
    }

    @RequestMapping(value = "/bendaharakelas/pengumuman/detail/{id}", method = RequestMethod.GET)
    public String detailPengumuman(@PathVariable Integer id, Model model) {
        model.addAttribute("pengumuman", pengumumanService.getId(id));
        return "pengumuman/bendaharakelas";
    }

    @RequestMapping(value = "/bendaharabem/pengumuman/edit/{id}", method = RequestMethod.GET)
    public String editPengumuman(@PathVariable Integer id, Model model) {
        model.addAttribute("pengumuman", pengumumanService.getId(id));
        return "formEditKelas";
    }

    @RequestMapping(value = "/bendaharakelas/pengumuman/delete/{id}", method = RequestMethod.GET)
    public String deletePengumuman(@PathVariable Integer id) {
        pengumumanService.deletePengumuman(id);
        return "redirect:/data";
    }
}
