package br.com.projetospringboot3.aopdemo.dao;

import br.com.projetospringboot3.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

	@Override
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println("--- " + getClass() + " ---");
		System.out.println("--- Simulating DB process of adding an account ---");
	}

	@Override
	public boolean doWork() {

		System.out.println("--- " + getClass() + " ---");
		System.out.println("--- Simulating doWork() method ---");
		return false;
	}
}
