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
	public String home(Model model, Principal user) {
		model.addAttribute("mnName", user.getName());;
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

		return "statistics";
	}

	@GetMapping("/statistics/year")
	public String statisticsYear(Model model, Principal user) {
		model.addAttribute("mnName", user.getName());
		List<List<String>> sqlResult = payRepository.findByGroupYear();
		System.out.println(sqlResult.toString());
		String[] pday = new String[sqlResult.size()];
		String[] totalPayment = new String[sqlResult.size()];
		for (int i = 0; i < sqlResult.size(); i++) {
			for (int j = 0; j < sqlResult.get(0).size(); j++) {
				String a = sqlResult.get(i).get(j).toString();
				if (j == 0) {
					totalPayment[i] = a;
				} else {
					pday[i] = a;
				}
			}
		}
		model.addAttribute("YearArr", pday);
		model.addAttribute("TotalPriceArr", totalPayment);
		return "statisticsYear";
	}

	@GetMapping("/statistics/month")
	public String statisticsMonth(Model model, Principal user) {
		model.addAttribute("mnName", user.getName());
		List<List<String>> sqlResult = payRepository.findByGroupMonth();
		System.out.println(sqlResult.toString());
		String[] pday = new String[sqlResult.size()];
		String[] totalPayment = new String[sqlResult.size()];
		for (int i = 0; i < sqlResult.size(); i++) {
			for (int j = 0; j < sqlResult.get(0).size(); j++) {
				String a = sqlResult.get(i).get(j).toString();
				if (j == 0) {
					totalPayment[i] = a;
				} else {
					pday[i] = a;
				}
			}
		}
		model.addAttribute("MonthArr", pday);
		model.addAttribute("TotalPriceArr", totalPayment);

		return "statisticsMonth";
	}

	@GetMapping("/statistics/day")
	public String statisticsDay(Model model, Principal user) {
		model.addAttribute("mnName", user.getName());
		List<List<String>> sqlResult = payRepository.findByGroupDay();
		System.out.println(sqlResult.toString());
		String[] pday = new String[sqlResult.size()];
		String[] totalPayment = new String[sqlResult.size()];
		for (int i = 0; i < sqlResult.size(); i++) {
			for (int j = 0; j < sqlResult.get(0).size(); j++) {
				String a = sqlResult.get(i).get(j).toString();
				if (j == 0) {
					totalPayment[i] = a;
				} else {
					pday[i] = a;
				}
			}
		}
		model.addAttribute("DayArr", pday);
		model.addAttribute("TotalPriceArr", totalPayment);

		return "statisticsDay";
	}

	@GetMapping("/statistics/today")
	public String statisticsToday(Model model, Principal user) {
		model.addAttribute("mnName", user.getName());
		List<List<String>> sqlResult = payRepository.findByGroupToday();
		System.out.println(sqlResult.toString());
		String[] pday = new String[sqlResult.size()];
		String[] totalPayment = new String[sqlResult.size()];
		for (int i = 0; i < sqlResult.size(); i++) {
			for (int j = 0; j < sqlResult.get(0).size(); j++) {
				String a = sqlResult.get(i).get(j).toString();
				if (j == 0) {
					totalPayment[i] = a;
				} else {
					pday[i] = a;
				}
			}
		}
		model.addAttribute("TodayArr", pday);
		model.addAttribute("TotalPriceArr", totalPayment);

		return "statisticsToday";
	}
	
	@GetMapping("/statistics/menu")
	public String statisticsMenu(Model model, Principal user) {
		model.addAttribute("mnName", user.getName());
		model.addAttribute("Day", payRepository.findByGroupMenuDay());
		model.addAttribute("Month", payRepository.findByGroupMenuMonth());
		model.addAttribute("Year", payRepository.findByGroupMenuYear());
		return "statisticsMenu";
	}
}