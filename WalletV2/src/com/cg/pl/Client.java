
package com.cg.pl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.cg.bean.Account;
import com.cg.bean.Transaction;
import com.cg.dao.WalletDAO;
import com.cg.service.IWalletService;
import com.cg.service.WalletService;

public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		IWalletService ser = new WalletService();
		ser.connect();
		int op = 0;
		do {
			System.out.println("1->Register new account\n2->Account Details\n3->Deposit\n4->Withdraw\n5->Transfer\n6->MiniStatement");
			System.out.println("Enter your choice :");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the name : ");
				String name = sc.next();
				System.out.println("Enter the opening balance : ");
				double balance = sc.nextDouble();
				System.out.println("Your Account Number is :"+ser.addAccount(name, balance));
				break;
			}
			case 2: {
				System.out.println("Enter the account number :");
				long accountNumber = sc.nextLong();
				System.out.println(ser.getAccount(accountNumber));
				break;
			}
			case 3: {
				System.out.println("Enter Ac Number : ");
				long accountNumber = sc.nextLong();
				System.out.println("Amount");
				double amount = sc.nextDouble();
				ser.deposit(accountNumber, amount);
				break;
			}
			case 4: {
				System.out.println("Enter Ac Number : ");
				long accountNumber = sc.nextLong();
				System.out.println("Amount");
				double amount = sc.nextDouble();
				ser.withdraw(accountNumber, amount);
				break;

			}
			case 5: {
				System.out.println("Enter your A/c Number :");
				long accountNumber1 = sc.nextLong();
				System.out.println("Enter the A/c to be credited : ");
				long accountNumber2 = sc.nextLong();
				System.out.println("Amount : ");
				double amount = sc.nextDouble();
				ser.transfer(accountNumber1, accountNumber2, amount);
				break;
			}
			case 6: {
				Transaction tc=new Transaction();
				System.out.println("Enter the account no. :");
				long accountNumber = sc.nextLong();
				ResultSet rs = ser.getTransactions(accountNumber);
				while(rs.next()) {
					tc.setTransactionID(rs.getLong(1));
					tc.setAccountNo(rs.getLong(2));
					tc.setTransactionType(rs.getString(3));
					tc.setAmount(rs.getDouble(4));
					tc.setBalance(rs.getDouble(5));
					tc.setDateTime(rs.getString(6));
					System.out.println(tc);
				}
				break;
			}

			}
			System.out.println("Do you wish to continue? 0->No, 1->yes");
			op = sc.nextInt();

		} while (op != 0);

	}

}

