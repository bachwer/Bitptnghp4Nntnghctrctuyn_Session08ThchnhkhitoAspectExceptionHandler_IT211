package org.example.ex4.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityExceptionLoggingAspect {

    @AfterThrowing(
            pointcut =
                    "execution(* org.example.ex4.service..*(..))",
            throwing = "ex"
    )
    public void logSecurityException(
            JoinPoint joinPoint,
            Exception ex
    ) {

        String className =
                joinPoint.getTarget()
                        .getClass()
                        .getSimpleName();

        String methodName =
                joinPoint.getSignature()
                        .getName();

        System.out.println(
                "========== SECURITY ERROR LOG =========="
        );

        System.out.println(
                "Class  : " + className
        );

        System.out.println(
                "Method : " + methodName
        );

        System.out.println(
                "Message: " + ex.getMessage()
        );

        System.out.println(
                "========================================"
        );
    }
}