package br.com.projetospringboot3.aopdemo.dao;

import br.com.projetospringboot3.aopdemo.Account;

public interface AccountDAO {

	void addAccount(Account account, boolean vipFlag);

	boolean doWork();
}
