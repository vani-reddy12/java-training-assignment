package com.zensar.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.zensar.exceptions.CouponAlreadyExistsException;
import com.zensar.exceptions.NoSuchCouponExistsException;

@Aspect
@Configuration
public class AspectConfig {

	/* LOGGING */
	private Logger log = LoggerFactory.getLogger(AspectConfig.class);

	@Before(value = "execution(* com.zensar.ide.controller.*.*(..))")
	public void logStatementBefore(JoinPoint joinPoint) {
		log.info("Executing {}", joinPoint);
	}

	@After(value = "execution(* com.zensar.ide.controller.*.*(..))")
	public void logStatementAfter(JoinPoint joinPoint) {
		log.info("Completed execution of {}", joinPoint);
	}

	@Around(value = "execution(* com.zensar.ide.service.*.*(..))")
	public Object exceptionHandler(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			Object obj = joinPoint.proceed();
			return obj;
		} catch (NoSuchCouponExistsException e) {
			log.info("Message {}", e.getMessage());
		} catch (CouponAlreadyExistsException e) {
			log.info("Message {}", e.getMessage());
		}
		return null;

	}

	@Around(value = "execution(* com.zensar.ide.controller.*.*(..))")
	public Object timeTracker(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		try {
			Object obj = joinPoint.proceed();
			long timeTaken = System.currentTimeMillis() - startTime;
			log.info("Time taken by {} is {} ", joinPoint, timeTaken);
			return obj;
		} catch (NoSuchCouponExistsException e) {
			log.info("Message {}", e.getMessage());
		} catch (CouponAlreadyExistsException e) {
			log.info("Message {}", e.getMessage());
		}
		return null;

	}
}
