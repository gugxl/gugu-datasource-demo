package com.gugu.example.gugudatasourcedemo.aop;

import com.gugu.example.gugudatasourcedemo.holder.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author gugu
 * @Classname DataSourceAop
 * @Description TODO
 * @Date 2022/7/16 20:23
 */
@Aspect
@Component
public class DataSourceAop {
    @Pointcut("execution(* com.gugu.example.gugudatasourcedemo.service..*.select*(..)) || execution(* com.gugu.example.gugudatasourcedemo.service..*.get*(..))")
    public void readPointcut() {
    }

    @Pointcut("@annotation(com.gugu.example.gugudatasourcedemo.annotation.Master) " +
            "|| execution(* com.gugu.example.gugudatasourcedemo..*.insert*(..)) " +
            "|| execution(* com.gugu.example.gugudatasourcedemo..*.add*(..)) " +
            "|| execution(* com.gugu.example.gugudatasourcedemo..*.update*(..)) " +
            "|| execution(* com.gugu.example.gugudatasourcedemo..*.edit*(..)) " +
            "|| execution(* com.gugu.example.gugudatasourcedemo..*.delete*(..)) " +
            "|| execution(* com.gugu.example.gugudatasourcedemo..*.remove*(..))")
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
