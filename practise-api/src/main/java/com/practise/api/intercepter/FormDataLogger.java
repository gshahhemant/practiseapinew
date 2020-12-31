/*package com.practise.api.intercepter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;


@Aspect
@Configuration
public class FormDataLogger {


	ObjectMapper mapper = new ObjectMapper();

	@Before("execution(* com.practise.api.controller..*.*(..))")

	public void printBeforeJoinPointFormDataContextInformation(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();

		applicationLogger.info(joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName() + "::" + getInputParametersString(args));

	}

	@Before("execution(* com.practise.api.service..*.*(..)) ||" + " execution(* com.practise.api.impl..*.*(..)) "
			+ "|| execution(* gov.tx.hhs.api.userprov.repositories..*.*(..))")
	public void before(JoinPoint joinPoint) {

		LogWrapper.info(joinPoint.getTarget().getClass().getCanonicalName(),
				"Start: " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.practise.api.service..*.*(..)) ||" + " execution(* com.practise.api.impl..*.*(..)) "
			+ "|| execution(* com.practise.api.repositories..*.*(..))")
	public void after(JoinPoint joinPoint) {

		LogWrapper.info(joinPoint.getTarget().getClass().getCanonicalName(),
				"End: " + joinPoint.getSignature().getName());
	}

	private String getInputParametersString(Object[] joinPointArgs) {
		String input;
		try {
			input = mapper.writeValueAsString(joinPointArgs);
		} catch (Exception e) {
			input = "Unable to create input parameters string. Error:" + e.getMessage();
		}
		return input;
	}

}
*/