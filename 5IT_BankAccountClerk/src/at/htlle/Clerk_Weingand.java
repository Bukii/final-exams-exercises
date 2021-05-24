package at.htlle;

import java.util.Random;

import at.htlle.bank.Bank_Weingand;

/**
 * Holds an amount of transactions it has to do and a bank. When calling
 * start(), it will do random transactions.
 * 
 * @author Lukas
 *
 */
public class Clerk_Weingand extends Thread {

	private Integer transferNum;
	private Bank_Weingand bank;
	private float spendings;

	/**
	 * Defines the number of transactions it has to do and creates a new bank.
	 */
	public Clerk_Weingand(Bank_Weingand bank) {
		this.transferNum = 15;
		this.bank = bank;
		this.spendings = 0;
	}

	/**
	 * Displays the bank and the current balance of each account in this bank.
	 */
	public void showAllBalances() {
		System.out.println(this.bank.toString());
	}

	/**
	 * The main method of a Thread. Does random transactions on random accounts as
	 * well as a random amount of money.
	 */
	public void run() {
		Random rand = new Random();
		for (int i = 0; i < this.transferNum; i++) {
			int randomAcc = rand.nextInt(100);
			float randomAmount = (float) (Math.round((rand.nextInt(10) + rand.nextDouble()) * 100.0) / 100.0);
			this.spendings += randomAmount;

			this.bank.transferMoney(randomAcc, randomAmount);
		}
	}

	/**
	 * Shows the spendings of this clerk as well as the total amount of money the
	 * bank is holding.
	 * 
	 * @return A String with the current spendings as well as the total amount of
	 *         money the bank is holding.
	 */
	public String getSpendingsAndTotalBalance() {
		return "[Spendings: " + this.spendings + "; Summe aller Konten: " + this.bank.getTotalBalance() + "]";
	}

}
