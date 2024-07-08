package br.com.projetospringboot3.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

	@Override
	public void addAccount() {
		System.out.println("--- " + getClass() + " ---");
		System.out.println("--- Simulating DB process of adding an account ---");
	}
}
