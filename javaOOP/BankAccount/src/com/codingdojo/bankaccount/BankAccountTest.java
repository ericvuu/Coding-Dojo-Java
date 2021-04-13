package com.codingdojo.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		
		BankAccount bankAccount1 = new BankAccount();
		BankAccount bankAccount2 = new BankAccount();
		

		bankAccount1.depositChecking(1000);
		bankAccount1.depositSavings(1000);
		bankAccount1.getCheckingBalance();
		bankAccount2.getSavingsBalance();
		
		BankAccount.getTotalAmount();
		
		bankAccount1.withdraw("checking", 100);
		bankAccount1.withdraw("checking", 100);
		
		BankAccount.getTotalAmount();
		
	}

}
