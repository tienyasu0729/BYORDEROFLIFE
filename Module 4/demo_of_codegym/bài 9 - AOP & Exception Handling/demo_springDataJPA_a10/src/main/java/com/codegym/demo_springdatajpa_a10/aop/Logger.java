package com.codegym.demo_springdatajpa_a10.aop;

import com.codegym.demo_springdatajpa_a10.dto.StudentDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int count = 0;

    // đếm số lần truy cập vào trang web
//    @After("execution(* com.codegym.demo_springdatajpa_a10.controller.StudentController.*(..))")
//    public void count(JoinPoint joinPoint){
//        count++;
//        System.out.println("method thực hiện " + joinPoint.getSignature().getName());
//        System.out.println("số lần truy cập"+ count);
//    }
//    @After("execution(* com.codegym.demo_springdatajpa_a10.controller.StudentController.save(..))")
//    public void loggingCreate(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        System.out.println("Tên thêm mới: " + ((StudentDto) args[0]).getName());
//    }
    @Around("execution(* com.codegym.demo_springdatajpa_a10.controller.StudentController.save(..))")
    public Object loggingAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("---------before");
        // công việc cân thực hiện trước khi thêm mới
       Object object = proceedingJoinPoint.proceed();
       // công việc thực hiện sau khi thêm mới
        System.out.println("---------after");
        return object;
    }
}
