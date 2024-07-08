package br.com.projetospringboot3.aopdemo;

import br.com.projetospringboot3.aopdemo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO) {
		return runner -> {
			demoBeforeAdvice(accountDAO);
		};
	}

	private void demoBeforeAdvice(AccountDAO accountDAO) {

		System.out.println("Adding an account: ");
		accountDAO.addAccount();

		System.out.println("Adding another account: ");
		accountDAO.addAccount();
	}

}
