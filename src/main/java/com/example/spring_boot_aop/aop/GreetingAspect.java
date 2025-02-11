package com.example.spring_boot_aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(2)
@Aspect
@Component
public class GreetingAspect {
    private Logger logger = LoggerFactory.getLogger(GreetingAspect.class);

    @Before("GreetingServicePointCuts.greetingPointcut()")
    public void loggerBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + methodName + " con los argumentos: " + args);
    }

    @After("GreetingServicePointCuts.greetingPointcut()")
    public void loggerAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después: " + methodName + " con los argumentos: " + args);
    }

    @AfterReturning("GreetingServicePointCuts.greetingPointcut()")
    public void loggerAfterReturning(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después de retornar: " + methodName + " con los argumentos: " + args);
    }

    @AfterThrowing("GreetingServicePointCuts.greetingPointcut()")
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después de lanzar la excepción: " + methodName + " con los argumentos: " + args);
    }

    @Around("GreetingServicePointCuts.greetingPointcut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            logger.info("Around El método: " + methodName + "() con los argumentos: " + args);
            result = joinPoint.proceed();
            logger.info("Around El método: " + methodName + " retorna el resultado " + result);
            return result;
        } catch (Throwable throwable) {
            logger.error("Error en la llamada al método " + methodName + "()");
            throw throwable;
        }
    }
}
