package com.example.danocoffee.controller;

import com.example.danocoffee.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @Autowired
    MenuRepository menuRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("signup")
    public String postSignup() {
        return "signup";
    }

    @GetMapping("addManager")
    public String addManager(){
        return "addManager";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/denied")
    public String denied() {
        return "denied";
    }



    @GetMapping("/management")
    public String management(Model model) {
        model.addAttribute("menus", menuRepository.findAll(Sort.by(Sort.Direction.DESC, "mId")));
        return "management";
    }

}
