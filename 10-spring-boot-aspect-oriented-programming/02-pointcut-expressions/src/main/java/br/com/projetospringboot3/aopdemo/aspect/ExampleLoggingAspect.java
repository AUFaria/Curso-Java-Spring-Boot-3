package br.com.projetospringboot3.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampleLoggingAspect {

//	@Before("execution(public void addAccount())")
//	public void addAccountBeforeAdvice() {
//
//		System.out.println("\n");
//		System.out.println("# Executing @Before advice #");
//		System.out.println("# Pointcut: public void addAccount() #");
//		System.out.println("\n");
//	}

//	@Before("execution(public void br.com.projetospringboot3.aopdemo.dao.AccountDAO.addAccount())")
//	public void addAccountBeforeAdvice() {
//
//		System.out.println("\n");
//		System.out.println("# Executing @Before advice #");
//		System.out.println("# Pointcut: public void br.com.projetospringboot3.aopdemo.dao.AccountDAO.addAccount() #");
//		System.out.println("\n");
//	}

//	@Before("execution(public void add*())")
//	public void addAccountBeforeAdvice() {
//
//		System.out.println("\n");
//		System.out.println("# Executing @Before advice #");
//		System.out.println("# Pointcut: public void add*() #");
//		System.out.println("\n");
//	}

//	@Before("execution(* add*())")
//	public void addAccountBeforeAdvice() {
//
//		System.out.println("\n");
//		System.out.println("# Executing @Before advice #");
//		System.out.println("# Pointcut: * add*() #");
//		System.out.println("\n");
//	}

//	@Before("execution(* add*(br.com.projetospringboot3.aopdemo.Account))")
//	public void addAccountBeforeAdvice() {
//
//		System.out.println("\n");
//		System.out.println("# Executing @Before advice #");
//		System.out.println("# Pointcut: * add*(br.com.projetospringboot3.aopdemo.Account) #");
//		System.out.println("\n");
//	}

//	@Before("execution(* add*(br.com.projetospringboot3.aopdemo.Account, ..))")
//	public void addAccountBeforeAdvice() {
//
//		System.out.println("\n");
//		System.out.println("# Executing @Before advice #");
//		System.out.println("# Pointcut: * add*(br.com.projetospringboot3.aopdemo.Account, ..) #");
//		System.out.println("\n");
//	}

	/*
		! WARNING !
		IntelliJ IDEA Ultimate throws 'org/springframework/boot/autoconfigure/jmx/JmxAutoConfiguration.class' BeanCreationException

		Problem: pointcut expression too broad
		Solution: Narrow it down / Only match within package
	*/

//	@Before("execution(* add*(..))") -> Problematic pointcut expression
//	@Before("execution(* br.com.projetospringboot3..add*(..))")
//	public void addAccountBeforeAdvice() {
//
//		System.out.println("\n");
//		System.out.println("# Executing @Before advice #");
//		System.out.println("# Pointcut: * add*(..) #");
//		System.out.println("\n");
//	}

	@Before("execution(* br.com.projetospringboot3.aopdemo.dao.*.*(..))")
	public void addAccountBeforeAdvice() {

		System.out.println("\n");
		System.out.println("# Executing @Before advice #");
		System.out.println("# Pointcut: * br.com.projetospringboot3.aopdemo.dao.*.*(..) #");
		System.out.println("\n");
	}
}
