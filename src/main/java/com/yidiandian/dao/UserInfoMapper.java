package com.yidiandian.dao;

import com.yidiandian.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/18 10:05
 * @Email: 15290810931@163.com
 */
@Mapper
public interface UserInfoMapper {

    int insert(UserInfo userInfo);

    int save(UserInfo userInfo);

    List<UserInfo> selectAll();

    String getToken(@Param("userId") String userId);
}
