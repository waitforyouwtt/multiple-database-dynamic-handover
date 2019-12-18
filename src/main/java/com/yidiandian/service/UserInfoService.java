package com.yidiandian.service;

import com.yidiandian.entity.UserInfo;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/18 10:00
 * @Email: 15290810931@163.com
 */
public interface UserInfoService {

    /**
     * 新增
     * @param userInfo
     * @return
     */
    int insert(UserInfo userInfo);
    /**
     * 保存
     */
    int save(UserInfo userInfo);
    /**
     * 查询
     */
    List<UserInfo> selectAll();
    /**
     * 根据用户id 查询一个用户token
     * @param userId
     * @return
     */
    String getToken(String userId);
}
