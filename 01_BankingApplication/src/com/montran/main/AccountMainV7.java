package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.Current;
import com.montran.pojo.Savings;

public class AccountMainV7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Savings savings = null;
		Current current = null;
		boolean isSalary = false;
		boolean isSaving = false;
		double overDraftBalance = 0;
		boolean result = false;
		double amount = 0;
		System.out.println("Welcome to Montran Bank");
		System.out.println("Account choice Menu");
		System.out.println("Please select account type");
		System.out.println("1.. Savings");
		System.out.println("2.. Current");
		System.out.println("Enter your account choice");
		int accountChoice = sc.nextInt();
		switch (accountChoice) {
		case 1:
			isSaving = true;
			System.out.println("Do you want to open salary account (true-false) ?");
			isSalary = sc.nextBoolean();
			break;
		case 2:
			isSaving = false;
			System.out.println("Enter overdraftBalance");
			overDraftBalance = sc.nextDouble();
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}

		System.out.println("Enter Account Number");
		int accountNumber = sc.nextInt();
		System.out.println("Enter Full Name");
		String name = sc.next();
		System.out.println("Enter Balance");
		double balance = sc.nextDouble();
		System.out.println("Your account is opened Successfully");
		if (isSaving) {
			savings = new Savings(accountNumber, name, balance, isSalary);
			System.out.println(savings);
		} else {
			current = new Current(accountNumber, name, balance, overDraftBalance);
			System.out.println(current);
		}
		String continueChoice;
		do {
			System.out.println("Transaction Choice Menu");
			System.out.println("1. Withdraw");
			System.out.println("2. Deposit");
			System.out.println("3. Print Balance");
			System.out.println("Enter your transaction choice");
			int transactionChoice = sc.nextInt();
			switch (transactionChoice) {
			case 1:
				System.out.println("Enter amount for withdraw");
				amount = sc.nextDouble();
				if (isSaving) {
					result = savings.withdraw(amount);
				} else {
					result = current.withdraw(amount);
				}
				if (result) {
					System.out.println("Transaction Success");
				} else {
					System.out.println("Transaction Failed");
				}
				break;
			case 2:
				System.out.println("Enter amount for deposit");
				amount = sc.nextDouble();
				if (isSaving) {
					result = savings.deposit(amount);
				} else {
					result = current.deposit(amount);
				}
				if (result) {
					System.out.println("Transaction Success");
				} else {
					System.out.println("Transaction Failed");
				}
				break;
			case 3:
				System.out.print("Account Balance::");
				if (isSaving) {
					System.out.println(savings.getBalance());
				} else {
					System.out.println(current.getBalance());
					System.out.println("OverdraftBalance::" + current.getOverDraftBalance());
				}
				break;

			default:
				System.out.println("Invalid choice");
				break;
			}
			System.out.println("Do you want to continue (yes-no)?");
			continueChoice = sc.next();
		} while (continueChoice.toUpperCase().equals("YES"));
		System.out.println("Thank You For Banking With Us !!");
		sc.close();

	}

}
