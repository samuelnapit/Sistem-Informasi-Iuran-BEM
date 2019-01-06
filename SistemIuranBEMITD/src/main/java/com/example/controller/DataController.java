package com.example.controller;

import com.example.model.*;
import com.example.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class DataController {

    private final MahasiswaService mahasiswaService;

    private final UserService userService;

    @Autowired
    public DataController(MahasiswaService mahasiswaService, UserService userService) {
        this.mahasiswaService = mahasiswaService;
        this.userService = userService;
    }

    @RequestMapping("/bendaharakelas/data")
    public String MahasiswaList(Model model){
        model.addAttribute("mahasiswa", mahasiswaService.listMahasiswa());
        return "data/bendaharakelas";
    }

    @RequestMapping(value = "/bendaharakelas/data/create", method = RequestMethod.GET)
    public  String create(Model model) {
        model.addAttribute("mahasiswa", new Mahasiswa());
        return "form/formcreate";
    }

    @RequestMapping(value = "/bendaharakelas/data/create", method = RequestMethod.POST)
    public String save (Model model, Mahasiswa mahasiswa) {
        model.addAttribute("mahasiswa", mahasiswaService.saveOrUpdate(mahasiswa));
        return "redirect:/data";
    }

    @RequestMapping(value = "/bendaharakelas/data/viewdetail/{nim}", method = RequestMethod.GET)
    public String viewDetail(@PathVariable String nim, Model model) {
        model.addAttribute("mahasiswa", mahasiswaService.getNim(nim));
        return "detailMahasiswa";
    }

    @RequestMapping(value = "/bendaharakelas/data/edit/{nim}", method = RequestMethod.GET)
    public String editMahasiswa(@PathVariable String nim, Model model) {
        model.addAttribute("mahasiswa", mahasiswaService.getNim(nim));
        return "formEditKelas";
    }

    @RequestMapping(value = "/bendaharakelas/data/delete/{nim}", method = RequestMethod.GET)
    public String deleteMahasiswa(@PathVariable String nim) {
        mahasiswaService.deleteMahasiswa(nim);
        return "redirect:/data";
    }

//===============================================================================================

    @RequestMapping("/bendaharabem/data")
    public String UserList(Model model)
    {
        model.addAttribute("user", userService.listUser());
        return "data/bendaharabem";
    }

    @RequestMapping(value = {"/bendaharabem/data/create"}, method = RequestMethod.GET)
    public ModelAndView signUp() {
        ModelAndView model = new ModelAndView();
        User user = new User();
        model.addObject("user", user);
        model.setViewName("/form/formcreateuser");

        return model;
    }

    @RequestMapping(value = "/bendaharabem/data/create", method = RequestMethod.POST)
    public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        User userExist = userService.findByUsername(user.getUsername());

        if (userExist != null) {
            bindingResult.rejectValue("username", "error.user", "This username already exist!");
        }

        if (bindingResult.hasErrors()) {
            model.setViewName("/form/formcreateuser");
        } else {
            userService.save(user);
            model.addObject("msg", "User has been registered successfully!");
            model.addObject("user", new User());
            model.setViewName("/form/formcreateuser");
        }

        return model;
    }

    @RequestMapping(value = "/bendaharabem/data/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/bendaharabem/data";
    }
}
