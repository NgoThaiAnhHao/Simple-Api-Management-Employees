package com.springlove.simple_management_employee.aop;

import com.springlove.simple_management_employee.color.ColorFormat;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // AOP for service methods
    @Around("execution(* com.springlove.simple_management_employee.service.*.*(..))")
    public Object aroundServiceMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Get begin timestamp
        long begin = System.currentTimeMillis();

        // Executing the method
        Object result = proceedingJoinPoint.proceed();

        // Get end timestamp
        long end = System.currentTimeMillis();

        // Computing duration and display it
        long duration = end - begin;

        System.out.printf("%s%n=====> %s: %dms.%n%s",
                ColorFormat.ANSI_GREEN,
                proceedingJoinPoint.getSignature().toShortString(),
                duration,
                ColorFormat.ANSI_RESET);
        return result;
    }

    // AOP for exception handling
    @AfterThrowing(pointcut = "execution(* com.springlove.simple_management_employee.service.*.*(..))",
            throwing = "exception")
    public void afterThrowingExceptionInServiceMethods(JoinPoint joinPoint, Throwable exception) {
        System.out.printf("%s%n=====> %s: %s.%n%s",
                ColorFormat.ANSI_RED,
                joinPoint.getSignature().toShortString(),
                exception,
                ColorFormat.ANSI_RESET);
    }
}
