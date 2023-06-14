package com.cglia.student.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class StudentLoggerAdvice {

	private Logger log = LoggerFactory.getLogger(StudentLoggerAdvice.class);

	@Pointcut(value = "execution(* com.cglia.*.*(..))")
	public void myPointcut() {

	}

	@Around("myPointcut()")
	public Object studentLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().getSimpleName();
		Object[] array = pjp.getArgs();

		// Log method invocation
		log.info("Method invoked: {}.{}()", className, methodName);

		Object object;
		try {
			// Proceed with the original method execution
			object = pjp.proceed();

			// Log method response (success)
			log.info("Method execution successful: {}.{}()", className, methodName);
		} catch (Throwable throwable) {
			// Log method response (failure)
			log.error("Method execution failed: {}.{}()", className, methodName);
			throw throwable;
		}

		return object;
	}
}
