package com.example.danocoffee.controller;

import com.example.danocoffee.data.Menu;
import com.example.danocoffee.data.Pay;
import com.example.danocoffee.repository.ManagerRepository;
import com.example.danocoffee.repository.MenuRepository;
import com.example.danocoffee.repository.OrderListRepository;
import com.example.danocoffee.repository.PayRepository;
import com.example.danocoffee.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
	@Autowired
	ManagerRepository managerRepository;
	@Autowired
	MenuRepository menuRepository;
	@Autowired
	OrderListRepository orderListRepository;
	@Autowired
	PayRepository payRepository;
	@Autowired
	AdminService adminService;

	@GetMapping(value = { "/home" })
	public String home(Model model) {
		model.addAttribute("title", "메인입니다.");
		return "home";
	}

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

	@GetMapping("/addmanager") // 관리자등록
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
		model.addAttribute("Menu", menuRepository.findAll());
		return "order";
	}

	@GetMapping("/denied")
	public String denied() {
		return "denied";
	}

	@GetMapping("/statistics")
	public String statistics(Model model, Principal user) {
		model.addAttribute("mnName", user.getName());
		List<List<String>> sqlResult = payRepository.findByGroupYear();
		System.out.println(sqlResult.toString());
		String[] pday = new String[sqlResult.size()];
		String[] totalPayment = new String[sqlResult.size()];
		int cnt =0;
		for (int i = 0; i < sqlResult.size(); i++) {
			for (int j = 0; j < sqlResult.get(0).size(); j++) {
				String a = sqlResult.get(i).get(j).toString();
				if (j == 0) {
					pday[cnt]=a;
				} else {
					totalPayment[cnt]=a;
				}
			}
			cnt++;
		}
		System.out.println(pday[0]);
		System.out.println(totalPayment[0]);
		model.addAttribute("pday",pday);
		model.addAttribute("totalPayment",totalPayment);
		return "statistics";
	}
}