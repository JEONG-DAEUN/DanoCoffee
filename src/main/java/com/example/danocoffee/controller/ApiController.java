package com.example.danocoffee.controller;

import com.example.danocoffee.data.Category;
import com.example.danocoffee.data.Manager;
import com.example.danocoffee.data.Menu;
import com.example.danocoffee.data.Result;
import com.example.danocoffee.repository.ManagerRepository;
import com.example.danocoffee.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @PostMapping(value="/addMenu", consumes = MediaType.MULTIPART_FORM_DATA_VALUE) //멀티파트 폼데이터 쓰겠다고 빈에 알려줌.
    public String addMenu(
                          @RequestParam("mName") String mName,
                          @RequestParam("mPrice") int mPrice,
                          @RequestParam("mInven") boolean mInven,
                          @RequestParam("mImg") MultipartFile mImg,
                          @RequestParam("cId") int cId,
                          HttpServletRequest request
    ) throws IOException {
        System.out.println("image" + mImg);
        String path = request.getSession().getServletContext().getRealPath("\\"); //파일 저장할 경로 가져옴.
        // 파일 업로드 하는 부분
        String fileName = UUID.randomUUID() +  mImg.getOriginalFilename();
        String pathName = path + "\\static\\images\\" +fileName;  // 저장된 파일 이름과 경로 합친것
        //UUID : 랜덤값으로 이름 같은 파일 구분해줌.
        File file = new File(pathName);
        mImg.transferTo(file); //저장

//String mName, int mPrice, boolean mInven, String mImg, Category cId
        //DB 저장
        Category newcId = adminService.findCategoryId(cId);
        System.out.println("image" + mImg);
        Menu inputMenu = new Menu(mName, mPrice, mInven, pathName, fileName, newcId);

        Menu findMenu = adminService.findMenuName(mName);
        if (findMenu == null) {
            adminService.addMenu(inputMenu); //없는 경우 추가 있는 경우 변경 -> save함수
            return  "<h2>상품 등록이 완료되었습니다. </h2>"
                    + "<meta http-equiv=\"refresh\" content=\"2;url=/addmenu\" />";
        } else {
            return  "<h2>상품 등록 실패. </h2>"
                    + "<meta http-equiv=\"refresh\" content=\"2;url=/addmenu\" />";
        }
    }


    @DeleteMapping("/deleteMenu")
    public Result deleteMenu(@RequestBody Menu menu) {
        System.out.println("asdf");
        Menu deleteMenu = adminService.findMenuId(menu.getmId());
        if (deleteMenu == null) {
            return new Result("no"); //삭제 실패
        } else {
            adminService.deleteMenu(menu.getmId()); //없는 경우 추가 있는 경우 변경 -> save함수
            return new Result("ok");
        }
    }

//    @DeleteMapping("/deleteManager")
//    public Result deleteMenu(@RequestBody Manager manager) {
//        System.out.println("asdf");
//        Menu deleteMenu = adminService.findMenuId(menu.getmId());
//        if (deleteMenu == null) {
//            return new Result("no"); //삭제 실패
//        } else {
//            adminService.deleteMenu(menu.getmId()); //없는 경우 추가 있는 경우 변경 -> save함수
//            return new Result("ok");
//        }
//    }

    @PostMapping("/addCrew")
    public Result addCrew(@RequestBody Manager manager) {
        Optional<Manager> findCrew = managerRepository.findById(manager.getMnId());
        if (findCrew.isPresent()) {
            managerRepository.save(manager); //없는 경우 추가 있는 경우 변경 -> save함수
        } else {
            managerRepository.save(manager);
        }
        return new Result("ok");
    }

    @PutMapping("/updatePrice")
    public Result updateMenu(@RequestBody Menu menu) {
        Menu updatePrice = adminService.findMenuName(menu.getmName());
        if (updatePrice == null) {
            return new Result("no"); // 가격 수정 실패
        } else {
            adminService.deleteMenu(menu.getmId()); //없는 경우 추가 있는 경우 변경 -> save함수
            return new Result("ok"); // 가격 수정 성공
        }
    }
}
