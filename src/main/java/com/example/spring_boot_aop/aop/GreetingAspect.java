package com.example.spring_boot_aop.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class GreetingAspect {
    private Logger logger = LoggerFactory.getLogger(GreetingAspect.class);

    @Before("execution(String com.example.spring_boot_aop.services.GreetingService.sayHello(..))")
    public void loggerbefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: "+methodName + " con los argumentos: " + args);
    }
}
