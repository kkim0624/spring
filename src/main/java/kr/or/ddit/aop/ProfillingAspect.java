package kr.or.ddit.aop;

import java.sql.Connection;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Aspect
public class ProfillingAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(ProfillingAspect.class);
	
	@Pointcut("execution(* kr.or.ddit..service.*.*(..))")
	public void dummy() {}
	
	@Around("dummy()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long startTime = System.currentTimeMillis();
		logger.debug("Profilling Aspect around method before");

		Object[] methodArgs = joinPoint.getArgs();
		Object returnObj = joinPoint.proceed(methodArgs);
		
		long endTime = System.currentTimeMillis();
		logger.debug("duration : " + (endTime-startTime));
		logger.debug("Profilling Aspect around method after");
		
		return returnObj;
		
	}
	
	
}
