package com.montran.pojo;

public class Current extends Account {
	private double overDraftBalance;
	private double tempOverDraftBalance;

	public Current() {
		// TODO Auto-generated constructor stub
	}

	public Current(int accountNumber, String name, double balance, double overDraftBalance) {
		super(accountNumber, name, balance);
		this.overDraftBalance = overDraftBalance;
		tempOverDraftBalance = overDraftBalance;
	}

	public double getOverDraftBalance() {
		return overDraftBalance;
	}

	public void setOverDraftBalance(double overDraftBalance) {
		this.overDraftBalance = overDraftBalance;
	}

	@Override
	public String toString() {
		return "Current [overDraftBalance=" + overDraftBalance + ", AccountNumber=" + getAccountNumber()
				+ ", Name=" + getName() + ", Balance=" + getBalance() + "]";
	}

	@Override
	public boolean withdraw(double amount) {
		if (amount > 0) {
			if (amount <= getBalance()) {
				setBalance(getBalance() - amount);
				return true;
			} else if (amount <= (getBalance() + overDraftBalance)) {
				amount = amount - getBalance();
				setBalance(0);
				setOverDraftBalance(overDraftBalance - amount);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deposit(double amount) {
		if (amount > 0) {
			overDraftBalance = overDraftBalance + amount;
			if (overDraftBalance > tempOverDraftBalance) {

				setBalance(getBalance() + (overDraftBalance - tempOverDraftBalance));
				setOverDraftBalance(tempOverDraftBalance);
			} else {
				setOverDraftBalance(overDraftBalance);
			}
			return true;
		}
		return false;
	}
}
