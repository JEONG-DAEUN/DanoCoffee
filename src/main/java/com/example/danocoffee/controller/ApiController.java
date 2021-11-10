package com.example.danocoffee.controller;

import com.example.danocoffee.data.Menu;
import com.example.danocoffee.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    MenuRepository menuRepository;

    @PostMapping("/addmenu")
    public Menu postAddMenu(@RequestBody Menu menu) {
        menuRepository.save(menu);
        return menu;
    }
}
