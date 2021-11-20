package com.example.danocoffee.service;

import com.example.danocoffee.data.Category;
import com.example.danocoffee.data.Manager;
import com.example.danocoffee.data.Menu;
import com.example.danocoffee.repository.CategoryRepository;
import com.example.danocoffee.repository.ManagerRepository;
import com.example.danocoffee.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ManagerRepository managerRepository;

    public void save(Menu menu) {
        menuRepository.save(menu);
    }

    public void save(Manager manager) {
        managerRepository.save(manager);
    }

    public void deleteMenu(int mId) {
        menuRepository.deleteById(mId);
    }
    public void deleteManager(int mnNumber) { managerRepository.deleteById(mnNumber); }


//    public void deleteManager(int mId) {
//        managerRepository.deleteById(mId);
//    }

//    public void updateMenu(int mId) {
//        menuRepository.(mId);
//    }


    public Menu findMenuName(String mName) {
        Menu searchMenu = menuRepository.findBymName(mName);
        return searchMenu;
    }

    public Manager findByMnId(String mnId) {
        Manager findManagerId = managerRepository.findByMnId(mnId);
        return findManagerId;
    }



    public Menu findMenuId(int mId) throws Exception{
        Optional<Menu> findMenu = menuRepository.findById(mId);
        if(findMenu.isPresent()) {
        return findMenu.get(); //mId 없으면 whitelabel뜸.
        }else throw new Exception ("메뉴 아이디 없음. 수정 불가");

    }

    public Manager findManagerId(int mnNumber) throws Exception{
        Optional<Manager> findManager = managerRepository.findById(mnNumber);
        if(findManager.isPresent()) {
            return findManager.get();
        }else throw new Exception("관리자 아이디 없음. 수정 불가");

    }

    public Category findCategoryId(int cId) {
        Optional<Category> findCategoryId = categoryRepository.findById(cId);
        return findCategoryId.get();
    }

    public void addMenu(Menu menu) {
        menuRepository.save(menu);
    }


    public Manager findById(int mnNumber) {
        Optional<Manager> findById = managerRepository.findById(mnNumber);
        return findById.get();
    }
}
