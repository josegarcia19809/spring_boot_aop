package com.example.spring_boot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointCuts {
    @Pointcut("execution(* com.example.spring_boot_aop.services.GreetingService.*(..))")
    public void greetingPointcut() {
    }

    @Pointcut("execution(* com.example.spring_boot_aop.services.GreetingService.*(..))")
    public void greetingFooPointcut() {
    }
}
