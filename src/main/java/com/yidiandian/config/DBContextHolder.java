package com.yidiandian.config;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/18 9:53
 * @Email: 15290810931@163.com
 */
@Slf4j
public class DBContextHolder {

    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();

    private static final AtomicInteger counter = new AtomicInteger(-1);

    public static void set(DBTypeEnum dbType) {
        contextHolder.set(dbType);
    }

    public static DBTypeEnum get() {
        return contextHolder.get();
    }

    public static void master() {
        set(DBTypeEnum.MASTER);
       log.info("☆☆☆☆.....切换到master.....☆☆☆☆☆");
    }

    public static void slave() {
        // 轮询
        int index = counter.getAndIncrement() % 2;
        if (counter.get() > 9999) {
            counter.set(-1);
        }
        if (index == 0) {
            set(DBTypeEnum.SLAVE1);
            System.out.println("◇◇◇◇◇----->切换到slave1<-----◇◇◇◇◇");
        }else {
            set(DBTypeEnum.SLAVE2);
            System.out.println("○○○○○-----切换到slave2 <-----○○○○○");
        }
    }
}
