package com.spring.transaction.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author venkataudaykiranp
 * @version 1.0 02-Apr-2019
 *
 */
@Aspect
@Configuration
@Slf4j
public class ControllerCRUDAspect {
	
	@Around(value = "@annotation(com.spring.transaction.aspect.TrackTime)")
	public void logTotalResponseTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		proceedingJoinPoint.proceed();
		log.info("{} - Total Response Time: {} ms", proceedingJoinPoint.getSignature(), System.currentTimeMillis() - start);
	}
	
	@Around(value = "execution(* com.spring.transaction.controller.*.find.*(..))")
	public void logFindResponseTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		proceedingJoinPoint.proceed();
		log.info("{} - Total Response Time: {} ms", proceedingJoinPoint.getSignature(), System.currentTimeMillis() - start);
	}
	
	@Around(value = "com.spring.transaction.aspect.CommonCRUDJoinPointConfig.allGetLayerExecution()")
	public void allGetLayerExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		proceedingJoinPoint.proceed();
		log.info("{} - Total Response Time: {} ms", proceedingJoinPoint.getSignature(), System.currentTimeMillis() - start);
	}
	
	@Around(value = "com.spring.transaction.aspect.CommonCRUDJoinPointConfig.saveLayerExecution()")
	public void saveLayerExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		proceedingJoinPoint.proceed();
		log.info("{} - Total Response Time: {} ms", proceedingJoinPoint.getSignature(), System.currentTimeMillis() - start);
	}
}
