package org.reveng.practiseproj.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(* org.reveng.practiseproj.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
		logger.info("Entering method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* org.reveng.practiseproj.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Exiting method: " + joinPoint.getSignature().getName() + " with result: " + result);
    }
    
    @AfterThrowing(pointcut = "execution(* org.reveng.practiseproj.service.*.*(..))", throwing = "exception")
    public void logAfterthrowing(JoinPoint joinPoint, Throwable exception) {
        logger.error("Exiting method: " + joinPoint.getSignature().getName() + " with exception class : " + exception.getClass().getName() + " with exception message : " + exception.getMessage());
    }

    @Around("execution(* org.reveng.practiseproj.service.*.*(..))")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        logger.debug("Around advice: Before method execution for " + proceedingJoinPoint.getSignature().getName());
        Object result = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.debug("Around advice: After method execution for " + proceedingJoinPoint.getSignature().getName() + ". Execution time: " + (endTime - startTime) + "ms");
        return result;
    }
    
}
