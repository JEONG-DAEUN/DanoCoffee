package com.example.danocoffee.service;

import com.example.danocoffee.data.Category;
import com.example.danocoffee.data.Menu;
import com.example.danocoffee.repository.CategoryRepository;
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

    public AdminService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void deleteMenu(int mId) {
        menuRepository.deleteById(mId);
    }

    public void deleteManager(int mnNumber) {
        managerRepository.deleteById(mnNumber);
    }


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

    public void deleteMenu(Menu menu) {
        menuRepository.deleteById(menu.getmId());
    }
}
