package com.example.danocoffee.controller;

import com.example.danocoffee.data.Manager;
import com.example.danocoffee.data.Menu;
import com.example.danocoffee.data.Result;
import com.example.danocoffee.repository.ManagerRepository;
import com.example.danocoffee.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    ManagerRepository managerRepository;

    @PostMapping("/signup")
    public Result postSignup(@RequestBody Manager manager) {
        // 이미 존재하는 아이디면 가입 실패
        if(managerRepository.existsById(manager.getMnId())) {
            return new Result("ng");
        }
        managerRepository.save(manager);
        return new Result("ok");
    }

    @PostMapping("/addmenu")
    public Result postAddmenu(@RequestBody Menu menu) {
        menuRepository.save(menu);
        return new Result("ok");
    }

}
