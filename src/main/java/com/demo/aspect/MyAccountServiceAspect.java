package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class MyAccountServiceAspect {
    @Pointcut("target(com.demo.service.MyAccountService)")
    public void thisMyAccountServicePointcut(){}

    @Before("thisMyAccountServicePointcut()")
    public void beforeMyAccountAdvice(JoinPoint jointPoint){
       String className=jointPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s is invoked with before " + "advice in [%s]."
                        ,className,
                        Arrays.toString(jointPoint.getArgs()),
                        LocalDateTime.now())
        );
    }
}
