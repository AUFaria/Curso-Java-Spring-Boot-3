package br.com.projetospringboot3.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampleLoggingAspect {

	@Before("execution(public void addAccount())")
	public void addAccountBeforeAdvice() {

		System.out.println("\n");
		System.out.println("* Executing @Before advice on addAccount() from AccountDAO *");
		System.out.println("\n");
	}
}
