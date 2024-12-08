package com.example.demo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.Account;

@Aspect
@Component
@Order(3)
//by order lower number has higher priority
public class MyDemoLoggingAspect {

	@Around("execution(* com.example.demo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\\n======>>>Executing @Around  on method" + method);

		// get begin timestamp
		long begin = System.currentTimeMillis();

		// now lets execute the methods
		Object result = null;
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result = "Major accident";
			
		}

		// get end timestamp
		long end = System.currentTimeMillis();
		long duration = end - begin;
		System.out.println("Duration taken" + duration);

		return result;
	}

	@After("execution(* com.example.demo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyAccountAdvice(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\\n======>>>Executing @After (finally) on method" + method);
	}

	@AfterThrowing(pointcut = "execution(* com.example.demo.dao.AccountDAO.findAccounts(..))", throwing = "Exc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable Exc) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\\n======>>>Executing @AfterThrowing on method" + method);

		System.out.println("\\n======>>> Evxception" + Exc);

	}

	// add new advice @AfterReturning on findAccount

	@AfterReturning(pointcut = "execution(* com.example.demo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJointPoint, List<Account> result) {
		// print out which method we are advising on
		String method = theJointPoint.getSignature().toShortString();
		System.out.println("\\n======>>>Executing @AfterReturning on method" + method);
		//
		System.out.println("\\n======>>> result" + result);

		// lets post-process the data.. let's modify it

		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);

		System.out.println("\\n======>>> result" + result);

	}

	private void convertAccountNamesToUpperCase(List<Account> result) {

		// loop through accounts
		for (Account tempAccount : result) {
			// get upercase version of names
			String theUpperName = tempAccount.getName().toUpperCase();
			// update the name on acount
			tempAccount.setName(theUpperName);
		}
	}

	// apply pointcut declaration in your advice
	@Before("com.example.demo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n======>>>Logging advice on method");

		// display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

		// display method argument
		System.out.println("Method" + methodSignature);

		// get args
		Object[] args = theJoinPoint.getArgs();

		// loop thru args
		for (Object tempA : args) {
			System.out.println(tempA);

			if (tempA instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempA;
				System.out.println("account name" + theAccount.getName());
				System.out.println("account level" + theAccount.getLevel());

			}
		}
	}
}
