package br.com.projetospringboot3.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

	@Override
	public boolean addSomeOtherMethodName() {
		System.out.println("--- " + getClass() + " ---");
		System.out.println("--- Simulating DB process of adding an account ---");
		return true;
	}

	@Override
	public void validateMembership() {
		System.out.println("--- " + getClass() + " ---");
		System.out.println("--- Simulating validateMembership() method ---");
	}
}
