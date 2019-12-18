package com.yidiandian.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/18 9:56
 * @Email: 15290810931@163.com
 */
@Aspect
@Component
public class DataSourceAop {

    //默认情况下，所有的查询都走从库，插入/修改/删除走主库。我们通过方法名来区分操作类型（CRUD）

    @Pointcut("!@annotation(com.yidiandian.config.Master) " +
            "&& (execution(* com.yidiandian.service..*.select*(..)) " +
            "|| execution(* com.yidiandian.service..*.get*(..)))" +
            "|| execution(* com.yidiandian.service..*.find*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.yidiandian.config.Master) " +
            "|| execution(* com.yidiandian.service..*.insert*(..)) " +
            "|| execution(* com.yidiandian.service..*.add*(..)) " +
            "|| execution(* com.yidiandian.service..*.update*(..)) " +
            "|| execution(* com.yidiandian.service..*.edit*(..)) " +
            "|| execution(* com.yidiandian.service..*.delete*(..)) " +
            "|| execution(* com.yidiandian.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }
}
