package com.example.danocoffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/management")
    public String management() {
        return "management";
    }



}
