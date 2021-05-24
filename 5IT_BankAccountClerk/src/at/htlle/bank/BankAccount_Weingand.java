package at.htlle.bank;

/**
 * Represents one bank account with a balance and methods to change that
 * balance.
 * 
 * @author Lukas
 *
 */
public class BankAccount_Weingand {

	private float balance;

	/**
	 * Update the current balance with the new one.
	 * 
	 * @param balance The new balance of the account.
	 */
	public void setBalance(float balance) {
		this.balance = balance;
	}

	/**
	 * Get the current accounts balance.
	 * 
	 * @return balance Returns the current account's balance.
	 */
	public float getBalance() {
		return balance;
	}

	/**
	 * @return The bank account's current balance.
	 */
	@Override
	public String toString() {
		return "BankAccount_Weingand [balance=" + balance + "]";
	}
}
