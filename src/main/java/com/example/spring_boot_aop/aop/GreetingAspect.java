package com.example.spring_boot_aop.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class GreetingAspect {
    private Logger logger = LoggerFactory.getLogger(GreetingAspect.class);

    @Before("execution(* com.example.spring_boot_aop.services.GreetingService.*(..))")
    public void loggerBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + methodName + " con los argumentos: " + args);
    }

    @After("execution(* com.example.spring_boot_aop.services.GreetingService.*(..))")
    public void loggerAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después: " + methodName + " con los argumentos: " + args);
    }

    @AfterReturning("execution(* com.example.spring_boot_aop.services.GreetingService.*(..))")
    public void loggerAfterReturning(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después de retornar: " + methodName + " con los argumentos: " + args);
    }
    @AfterThrowing("execution(* com.example.spring_boot_aop.services.GreetingService.*(..))")
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después de lanzar la excepción: " + methodName + " con los argumentos: " + args);
    }
}
