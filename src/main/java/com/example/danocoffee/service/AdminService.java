package com.example.danocoffee.service;

import com.example.danocoffee.data.*;
import com.example.danocoffee.repository.CategoryRepository;
import com.example.danocoffee.repository.ManagerRepository;
import com.example.danocoffee.repository.MenuRepository;
import com.example.danocoffee.repository.OrderListRepository;
import com.example.danocoffee.repository.PayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    ManagerRepository managerRepository;
    
    @Autowired
    MenuRepository menuRepository;

    @Autowired
    CategoryRepository categoryRepository;
    
    @Autowired
    PayRepository payRepository;

    @Autowired
    OrderListRepository orderListRepository;
    
    // 관리자 추가
    public void save(Manager manager) {
        managerRepository.save(manager);
    }
    
    
    public void deleteManager(String mnId) { managerRepository.deleteById(mnId); }


	public Manager findManagerMnName(String newMnName) { 
		Manager findManagerMnName = managerRepository.findByMnName(newMnName);
		return findManagerMnName;
	}
	
	public Manager findManagerMnId(String mnId) throws Exception {
		Optional<Manager> findManager = managerRepository.findById(mnId);
		if(findManager.isPresent()) {
			return findManager.get();
		}else throw new Exception("관리자 아이디 없음. 수정 불가");
	}
	
	public Manager findManagerId(String mnId) {
		Optional<Manager> findManagerId = managerRepository.findByMnId(mnId);
		return findManagerId.get();
	}
    
    public AdminService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void deleteMenu(int mId) {
        menuRepository.deleteById(mId);
    }

    public Menu findMenuName(String mName) {
        Menu searchMenu = menuRepository.findBymName(mName);
        return searchMenu;
    }

    public Menu findMenuId(int mId) {
        Optional<Menu> findMenu = menuRepository.findById(mId);
        return findMenu.get();
    }

    public Category findCategoryId(int cId) {
        Optional<Category> findCategoryId = categoryRepository.findById(cId);
        return findCategoryId.get();
    }

    public void addMenu(Menu menu) {
        menuRepository.save(menu);
    }
    
    public void save(Menu menu) {
        menuRepository.save(menu);
    }

    public void deleteMenu(Menu menu) {
        menuRepository.deleteById(menu.getmId());
    }

    public Menu findBymId(int mId) {
        Optional<Menu> findById = menuRepository.findById(mId);
        return findById.get();
    }
    
    public void addOrderList(OrderList orderList) { orderListRepository.save(orderList);}

    public void addPay(Pay pay) { payRepository.save(pay); }
    
    
   
}