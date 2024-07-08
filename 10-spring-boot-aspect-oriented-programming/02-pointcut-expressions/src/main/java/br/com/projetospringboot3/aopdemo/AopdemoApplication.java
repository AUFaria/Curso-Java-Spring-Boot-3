package br.com.projetospringboot3.aopdemo;

import br.com.projetospringboot3.aopdemo.dao.AccountDAO;
import br.com.projetospringboot3.aopdemo.dao.MembershipDAO;
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
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			exampleBeforeAdvice(accountDAO, membershipDAO);
		};
	}

	private void exampleBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		Account account = new Account();
		accountDAO.addAccount(account, false);
		accountDAO.doWork();

		membershipDAO.addSomeOtherMethodName();
		membershipDAO.validateMembership();
	}

}
