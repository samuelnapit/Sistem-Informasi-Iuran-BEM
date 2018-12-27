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

    @RequestMapping("/bendaharakelas/data")
    public String MahasiswaList(Model model)
    {
        model.addAttribute("mahasiswa", mahasiswaService.listMahasiswa());
        return "data/bendaharakelas";
    }

    @RequestMapping(value = "/bendaharakelas/data/create", method = RequestMethod.GET)
    public  String create(Model model) {
        model.addAttribute("mahasiswa", new Mahasiswa());
        return "formCreate";
    }

    @RequestMapping(value = "/bendaharakelas/data/create", method = RequestMethod.POST)
    public String save (Model model, Mahasiswa mahasiswa) {
        model.addAttribute("mahasiswa", mahasiswaService.saveOrUpdate(mahasiswa));
        return "redirect:/data";
    }

    @RequestMapping(value = "/bendaharakelas/data/viewdetail/{nim}", method = RequestMethod.GET)
    public String viewDetail(@PathVariable String nim, Model model) {
        model.addAttribute("mahasiswa", mahasiswaService.getNim(nim));
        return "viewdetail";
    }

    @RequestMapping(value = "/bendaharakelas/data/edit/{nim}", method = RequestMethod.GET)
    public String editMahasiswa(@PathVariable String nim, Model model) {
        model.addAttribute("mahasiswa", mahasiswaService.getNim(nim));
        return "formEdit";
    }

    @RequestMapping(value = "/bendaharakelas/data/delete/{nim}", method = RequestMethod.GET)
    public String deleteMahasiswa(@PathVariable String nim) {
        mahasiswaService.deleteMahasiswa(nim);
        return "redirect:/data";
    }

    private KelasService kelasService;

    @Autowired
    public void setKelasService(KelasService kelasService) {
        this.kelasService = kelasService;
    }

    @RequestMapping("/bendaharabem/data")
    public String KelasList(Model model)
    {
        model.addAttribute("kelas", kelasService.listKelas());
        return "data/bendaharabem";
    }

    @RequestMapping(value = "/bendaharabem/data/create", method = RequestMethod.GET)
    public  String createKel(Model model) {
        model.addAttribute("kelas", new Kelas());
        return "formCreateKelas";
    }

    @RequestMapping(value = "/bendaharabem/data/create", method = RequestMethod.POST)
    public String saveKelas (Model model, Kelas kelas) {
        model.addAttribute("kelas", kelasService.saveOrUpdateKel(kelas));
        return "redirect:/bendaharabem/data";
    }

    @RequestMapping(value = "/bendaharabem/data/viewdetail/{kode}", method = RequestMethod.GET)
    public String viewDetailKel(@PathVariable String kode, Model model) {
        model.addAttribute("mahasiswa", kelasService.getKode(kode));
        return "viewdetailKel";
    }

    @RequestMapping(value = "/bendaharabem/data/edit/{kode}", method = RequestMethod.GET)
    public String editKel(@PathVariable String kode, Model model) {
        model.addAttribute("kelas", kelasService.getKode(kode));
        return "formEditKel";
    }

    @RequestMapping(value = "/bendaharabem/data/delete/{kode}", method = RequestMethod.GET)
    public String deleteKelas(@PathVariable String kode) {
        kelasService.deteleKelas(kode);
        return "redirect:/bendaharabem/data";
    }
}
