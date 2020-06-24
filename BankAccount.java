package bankaccount;

import java.util.Scanner;

public class BankAccount {
	
	private double balancechecking;
	private double balancesaving;
	private double intrests;
	
	public BankAccount() {
		intrests = 5;
		
		
	}
	public void Withdraw(double amount) {
		System.out.println("would you like to withdraw from your savings or checkings account? Press 1 for savings 2 for checking");
		Scanner scan = new Scanner(System.in);
		int answer = scan.nextInt();
		if(answer == 1 ) {
			if (balancesaving >= amount) {
				balancesaving -= amount;
				System.out.println("You have withdrawn $"+ amount+" out of your savings account");
		
		}
			else {
				System.out.println("You do not have sufficient funds");
			}
		}
		if(answer == 2) {
			if (balancechecking >= amount) {
				balancechecking -= amount;
				System.out.println("You have withdrawn $"+ amount+" out of your checkings account");
		
		}
			else {
				System.out.println("You do not have sufficient funds");
			}
			
		}
		else {
			System.out.println("Pick 1 or 2");
			Withdraw(amount);

		}
		
		 
	}
	public void deposit(double amount) {
		System.out.println("would you like to depsoit to your savings or checkings account? Press 1 for savings 2 for checking");
		Scanner scan = new Scanner(System.in);
		int answer = scan.nextInt();
		if(answer == 1 ) {
			if (balancesaving >= amount) {
				balancesaving -= amount;
				System.out.println("You have deposited $"+ amount+" into your savings account");
		
		}
			
			
		}
		if(answer == 2) {
			if (balancechecking >= amount) {
				balancechecking -= amount;
				System.out.println("You have deposited $"+ amount+" into your checkings account");
		
		}
		
			
		}
		else {
			System.out.println("Pick 1 or 2");
			deposit(amount);

		}
		
		 
	}
	public double getbalance() {
		System.out.println("Would you like to check the balance in your savings account or checking account? 1 for savings 2 for checking" );
		Scanner scan = new Scanner(System.in);
		int answer = scan.nextInt();
		if(answer == 1 ) {
			return balancesaving;
		}
			
			
		
		if(answer == 2) {
			return balancechecking;

		
		}
		return 0;
			
		}
	public double futureintrests() {
		System.out.println("How many years would you like to simulate? the intrest rate is 5%" );
		Scanner scan = new Scanner(System.in);
		int answer = scan.nextInt();
		return balancesaving* answer *(intrests/100);
	}
	public void transfer() {
		System.out.println("Would you like money to your savings from your chekcing or from your checking to your savings? 1 for transfer to your savings 2  for transfer to your checking" );
		Scanner scan = new Scanner(System.in);
		int answer = scan.nextInt();
		if(answer == 1 ) {
			System.out.println("How much would you like to transfer?" );
			double transfer = scan.nextDouble();
			if(transfer > balancechecking) {
				System.out.println("You do not have enough money in your checking");
			}
			else {
				balancechecking -= transfer;
				balancesaving += transfer;
				System.out.println("You sent"+ transfer+ "to your savings");

			}
		}
			
			
		
		if(answer == 2) {
			System.out.println("How much would you like to transfer?" );
			double transfers = scan.nextDouble();
			if(transfers > balancesaving) {
				System.out.println("You do not have enough money in your savings");
			}
			else {
				balancechecking += transfers;
				balancesaving -= transfers;
				System.out.println("You sent"+ transfers+ "to your savings");

			}
		}

		
		}
	
}
	


