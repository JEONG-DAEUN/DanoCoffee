package com.example.danocoffee.controller;

import com.example.danocoffee.data.Manager;
import com.example.danocoffee.data.Menu;
import com.example.danocoffee.data.Result;
import com.example.danocoffee.repository.ManagerRepository;
import com.example.danocoffee.repository.MenuRepository;
import com.example.danocoffee.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private AdminService adminService;

    @GetMapping("/manager")
    public List<Manager> Management() {
        return managerRepository.findAll();
    }

    @PostMapping("/addMenu")
    public Result addMenu(@RequestBody Menu menu) {
        Menu findMenu = adminService.findMenuName(menu.getmName());
        if(findMenu==null) {
            adminService.addMenu(menu); //없는 경우 추가 있는 경우 변경 -> save함수
            return new Result("ok");
        }else {
            return new Result("no");
        }

    }



    @DeleteMapping("/deleteMenu")
    public Result deleteMenu(@RequestBody Menu menu) {
        System.out.println("asdf");
        Menu deleteMenu = adminService.findMenuId(menu.getmId());
        if(deleteMenu==null) {
            return new Result("no"); //삭제 실패
        }else {
            adminService.deleteMenu(menu.getmId()); //없는 경우 추가 있는 경우 변경 -> save함수
            return new Result("ok");
        }
    }

    @PostMapping("/addCrew")
    public Result addCrew(@RequestBody Manager manager) {
        Optional<Manager> findCrew = managerRepository.findById(manager.getMnId());
        if(findCrew.isPresent()) {
            managerRepository.save(manager); //없는 경우 추가 있는 경우 변경 -> save함수
        }else {
            managerRepository.save(manager);
        }
        return new Result("ok");
    }

    @PutMapping("/updatePrice")
    public Result updateMenu(@RequestBody Menu menu) {
        Menu updatePrice = adminService.findMenuName(menu.getmName());
        if(updatePrice==null) {
            return new Result("no"); // 가격 수정 실패
        }else {
            adminService.deleteMenu(menu.getmId()); //없는 경우 추가 있는 경우 변경 -> save함수
            return new Result("ok"); // 가격 수정 성공
        }
    }
}
