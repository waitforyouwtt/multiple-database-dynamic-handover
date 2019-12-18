package com.yidiandian.service.impl;

import com.yidiandian.config.Master;
import com.yidiandian.dao.UserInfoMapper;
import com.yidiandian.entity.UserInfo;
import com.yidiandian.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/18 10:03
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;
    /**
     * 新增
     *
     * @param userInfo
     * @return
     */
    @Transactional
    @Override
    public int insert(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }

    /**
     * 保存
     *
     * @param userInfo
     */
    @Master
    @Override
    public int save(UserInfo userInfo) {
        return userInfoMapper.save(userInfo);
    }

    /**
     * 查询
     */
    @Override
    public List<UserInfo> selectAll() {
        return userInfoMapper.selectAll();
    }

    /**
     * 根据用户id 查询一个用户token
     *有些读操作必须读主数据库 比如，获取微信access_token，因为高峰时期主从同步可能延迟 这种情况下就必须强制从主数据读
     * @param userId
     * @return
     */
    @Master
    @Override
    public String getToken(String userId) {
        return userInfoMapper.getToken(userId);
    }
}
