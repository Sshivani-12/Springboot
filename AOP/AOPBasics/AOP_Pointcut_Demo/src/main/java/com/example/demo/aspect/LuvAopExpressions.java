package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
//pointcut MEANS  when and where to execute aspect
//@aspect is not needed for @before @after
@Aspect
public class LuvAopExpressions {

	@Pointcut("execution(* com.example.demo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	// Create the pointcut getter method
	@Pointcut("execution(* com.example.demo.dao.*.get*(..))")
	public void getter() {
	};

	// Create pointcut for setter method
	@Pointcut("execution(* com.example.demo.dao.*.set*(..))")
	public void setter() {
	};

	// create pointcut : include package
	@Pointcut("forDaoPackage() && !(getter()||setter())")
	public void forDaoPackageNoGetterSetter() {
	}

}
