package com.codingdojo.bankaccount;
import java.util.Random;
import java.text.*;
import java.util.Locale;

public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int accountsCreated;
	private static int totalAmountStored;
	
	public BankAccount(){
		accountsCreated++;
		this.accountNumber = generateAccountNumber();
	}
	
	
	private String generateAccountNumber() {
		String acctNum = "";
		Random rand = new Random();
		for(int i = 0; i < 10; i++) {
			acctNum += rand.nextInt(10);
		}
		return acctNum;
	}
	
	
//	Getters and Setters
	
	public void getAccountNumber() {
		System.out.println("Account number: " + this.accountNumber);
	}
	
	public void getCheckingBalance() {
		double currentBalance = this.checkingBalance;
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("Checking Account Balance: " + currencyFormat.format(currentBalance) + ".");
	}
	
	public void getSavingsBalance() {
		double currentBalance = this.savingsBalance;
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("Savings Account Balance: " + currencyFormat.format(currentBalance) + ".");
	}
	
	public static void getTotalAmount() {
		Double currentBalance = (double) totalAmountStored;
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("Total amount in all accounts: " + currencyFormat.format(currentBalance) + ".");
	}
	
	public static void getTotalAccounts() {
		System.out.println("There are a total of " + accountsCreated + " account(s).");
	}
	
	public void depositChecking(int amount) {
		this.checkingBalance += amount;
		totalAmountStored += amount;
	}
	
	public void depositSavings(int amount) {
		this.savingsBalance += amount;
		totalAmountStored += amount;
	}
	
	public void withdraw(String type, double amount) {
		if(type.toLowerCase() == "checking") {
			if(this.checkingBalance == 0) {
				System.out.println("You have insufficent funds in your checkings account!");
				return;
			} else {
				totalAmountStored -= amount;
				this.checkingBalance -= amount;
				System.out.println("Withdrew " + amount + " dollars from your checkings account.");
			}
		} else if (type.toLowerCase() == "savings") {
			if(this.savingsBalance == 0) {
				System.out.println("You have insufficent funds in your savings account!");
				return;
			} else {
				totalAmountStored -= amount;
				this.savingsBalance -= amount;
				System.out.println("Withdrew " + amount + " dollars from your savings account.");
			}
		}
	}
	
	public void checkTotalFunds() {
		double total = this.checkingBalance + this.savingsBalance;
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("Total amount in all your accounts: " + currencyFormat.format(total) + ".");
	}
	
}
