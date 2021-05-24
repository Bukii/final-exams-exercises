package at.htlle.bank;

import java.util.Arrays;

/**
 * Holds several bank accounts. Has a method to transfer money to account and
 * will hold a total of 100 accounts on start.
 * 
 * @author Lukas
 *
 */
public class Bank_Weingand {

	private BankAccount_Weingand[] account;

	/**
	 * Calls the second constructor with the parameter 100.
	 */
	public Bank_Weingand() {
		this(100);
	}

	/**
	 * Creates a numberOfAccounts amount of new bank accounts.
	 * 
	 * @param numberOfAccounts The number of accounts the bank has to create.
	 */
	public Bank_Weingand(int numberOfAccounts) {
		account = new BankAccount_Weingand[numberOfAccounts];
		for (int i = 0; i < account.length; i++) {
			account[i] = new BankAccount_Weingand();
		}
	}

	/**
	 * Sums up all balances of the bank's accounts.
	 * 
	 * @return The total amount of money the bank is holding.
	 */
	public float getTotalBalance() {
		float total = 0;
		for (BankAccount_Weingand ba : account) {
			total += ba.getBalance();
		}
		return total;
	}

	/**
	 * @return A String of all bank accounts in this bank as well as their balances.
	 */
	@Override
	public String toString() {
		return "Bank_Weingand [accounts=" + Arrays.toString(account) + "]";
	}

	/**
	 * Takes a random accountNumber and a random amount of money and adds or
	 * subtracts it from the accounts current balance.
	 * 
	 * @param accountNumber The actual account the money should go to.
	 * @param amount        The amount of money the account will get added or
	 *                      removed.
	 */
	public synchronized void transferMoney(int accountNumber, float amount) {
		float oldBalance = account[accountNumber].getBalance();
		float newBalance = oldBalance + amount;
		account[accountNumber].setBalance(newBalance);
	}
}
