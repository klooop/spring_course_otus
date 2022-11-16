package ru.otus.spring.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {
//    @Before("execution(* ru.otus.spring.dao.PersonDaoSimple.*(..))")
//    public void logBefore(JoinPoint joinPoint) {
//        System.out.println("Прокси : " + joinPoint.getThis().getClass().getName());
//        System.out.println("Класс : " + joinPoint.getTarget().getClass().getName());
//
//        System.out.println("Вызов метода : " + joinPoint.getSignature().getName());
//    }
    @Around("execution(* ru.otus.spring.dao.PersonDaoSimple.*(..))")
    public Object logBefore(ProceedingJoinPoint joinPoint)
            throws Throwable {

        System.out.println("Прокси:"+joinPoint.getThis());
        System.out.println("Класс:"+joinPoint.getClass());
        System.out.println("Логирование перед вызовом метода:"+joinPoint.getSignature().getName());
        System.out.println("Аргументы метода:"+Arrays.toString(joinPoint.getArgs()));
        System.out.println("------------------------------------");
        var res = joinPoint.proceed();// точка вызова метода
        System.out.println("Логирование после вызова метода");
        System.out.println("Результат"+res);
        return res;
    }
}
