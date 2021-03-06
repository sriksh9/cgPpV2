package com.cg.service;

import java.sql.ResultSet;

import com.cg.bean.Account;

public interface IWalletService {
	public void connect() throws Exception;
	public Account getAccount(long accNo) throws Exception;
	public long addAccount(String name, double amt) throws Exception;
	public ResultSet getTransactions(long accNo) throws Exception;
	public Double deposit(long accountNumber, double amount) throws Exception;
	public Double withdraw(long accountNumber, double amount) throws Exception;
	public Double transfer(long accountNumber1, long accountNumber2, double amount) throws Exception;
}
