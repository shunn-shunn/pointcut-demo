package com.demo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class CurrencyServiceAspect {

    @Pointcut("within(com.demo.service.*)")
    public void withinCurrencyServicePointCut(){

    }

    @Pointcut("@within(com.demo.annotation.Secured)")
    public void withinAnnotationCurrencyServicePointCut(){}

    @Pointcut("@target(com.demo.annotation.Secured)")
    public void targetAnnotationCurrencyServicePointCut(){}

    @Pointcut("@annotation(com.demo.annotation.InTransaction)")
    public void annotationCurrencyServicePointCut(){}

    @Pointcut("bean(currency)")
    public void beanCurrencyServicePointcut(){}

    @Pointcut("args(int,int)")
    public void argsCurrencyServicePointcut(){}

    @Pointcut("@args(com.demo.annotation.Validated)")
    public void argsAnnotationCurrencyServicePointcut(){}

  //  @Before("withinCurrencyServicePointCut()")
    public void beforeCurrencyAdvice(JoinPoint joinPoint){
        String className=joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s'%s method is invoked with before " + "advice in [%s]."
                        ,className,
                        Arrays.toString(joinPoint.getArgs()),
                        LocalDateTime.now())
        );
    }

  // @Before("withinAnnotationCurrencyServicePointCut()")
    public void beforeWithinAnnotationCurrencyAdvice(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s'%s method is invoked with before " + "advice in [%s]."
                        , className,
                        Arrays.toString(joinPoint.getArgs()),
                        LocalDateTime.now())
        );
    }

    //    @Before("annotationCurrencyServicePointCut()")
        public void beforeAnnotationCurrencyAdvice (JoinPoint joinPoint){
            String className = joinPoint.getTarget().getClass().getSimpleName();
            System.out.println(
                    String.format("%s'%s method is invoked with before " + "advice in [%s]."
                            , className,
                            Arrays.toString(joinPoint.getArgs()),
                            LocalDateTime.now())
            );
        }

       // @Before("beanCurrencyServicePointcut()")
    public void beforeBeanCurrencyAdvice (JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s'%s method is invoked with before " + "advice in [%s]."
                        , className,
                        Arrays.toString(joinPoint.getArgs()),
                        LocalDateTime.now())
        );
    }

   // @Before("withinCurrencyServicePointCut() && argsCurrencyServicePointcut()")
    public void argsBeanCurrencyAdvice (JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s'%s method is invoked with before " + "advice in [%s]."
                        , className,
                        Arrays.toString(joinPoint.getArgs()),
                        LocalDateTime.now())
        );
    }
@After("targetAnnotationCurrencyServicePointCut()")
    public void argsAnnotationCurrencyAdvice (JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s'%s method is invoked with after " + "advice in [%s]."
                        , className,
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),

                        LocalDateTime.now())
        );
    }

    @Around("targetAnnotationCurrencyServicePointCut()")
    public Object argsAnnotationCurrencyAroundAdvice (ProceedingJoinPoint joinPoint)throws Throwable{
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s'%s method is invoked with after " + "advice in [%s]."
                        , className,
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),

                        LocalDateTime.now())
        );
        try {
            return joinPoint.proceed();
        }catch (Throwable e){
            System.out.println("Exception has been caught");
        }
        finally {
            System.out.println("After invoking method ....");
        }
        return null;
    }



    //   @AfterReturning(value = "argsAnnotationCurrencyServicePointcut()",returning = "country")
    public void agsAnnotationAfterReturningCurrencyAdvice (JoinPoint joinPoint,String country){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s'%s method is invoked with after " + "advice in [%s]."
                        , className,
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),
                        country,
                        LocalDateTime.now())
        );
    }

  //  @AfterThrowing(value = "argsAnnotationCurrencyServicePointcut()",throwing = "e")
    public void agsAnnotationAfterReturningCurrencyAdvice (JoinPoint joinPoint,Throwable e){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s'%s method is invoked with after throwing" + "advice exception class is:: [%s] in [%s]."
                        , className,
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),
                        e.getClass().getName(),
                        LocalDateTime.now())
        );
    }
    }

