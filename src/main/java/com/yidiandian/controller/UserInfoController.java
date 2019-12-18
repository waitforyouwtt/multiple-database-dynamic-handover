package com.yidiandian.controller;

import com.yidiandian.entity.UserInfo;
import com.yidiandian.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/18 10:26
 * @Email: 15290810931@163.com
 */
@RestController
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/insert")
    public Integer insert(@RequestBody UserInfo userInfo){
        return userInfoService.insert(userInfo);
    }

    @PostMapping("/save")
    public Integer save(@RequestBody UserInfo userInfo){
        return userInfoService.save(userInfo);
    }

    @PostMapping("/findAll")
    public List<UserInfo> selectAll(){
        return userInfoService.selectAll();
    }

    @GetMapping("/getToken")
    public String getToken(@RequestParam("userId") String userId){
        return userInfoService.getToken(userId);
    }

}
