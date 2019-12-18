package com.yidiandian.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/18 9:54
 * @Email: 15290810931@163.com
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {

    //获取路由key
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }
}
