package com.example.danocoffee.controller;

import com.example.danocoffee.data.Menu;
import com.example.danocoffee.repository.ManagerRepository;
import com.example.danocoffee.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class WebController {
    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    MenuRepository menuRepository;


    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/addmenu") // 상품등록
    private String management(Model model, Principal user) {
        model.addAttribute("mnName", user.getName());
        model.addAttribute("Menu", menuRepository.findAll());
        System.out.println(menuRepository.findAll());
        return "addmenu";
    }

    @GetMapping("/addmanager") //관리자등록
    private String addManager(Model model, Principal user) {
        model.addAttribute("mnName", user.getName());
        model.addAttribute("Crew", managerRepository.findAll());
        System.out.println(managerRepository.findAll());
        return "addmanager";
    }

    @GetMapping("/login")
    private String login() {
        return "login";
    }

    @GetMapping("/order") // 장바구니
    private String Cart(Model model, Menu menu) {
        model.addAttribute("Menu",  menuRepository.findAll());
        return "order";
    }

}