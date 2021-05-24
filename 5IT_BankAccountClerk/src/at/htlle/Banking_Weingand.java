package at.htlle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

import at.htlle.bank.Bank_Weingand;

/**
 * Main class, which creates two clerks, which are both filling their bank
 * accounts with random numbers.
 * 
 * @author Lukas
 *
 */
public class Banking_Weingand {

	/**
	 * Creates the two clerks and starts them. Every ten seconds it shows the
	 * spendings of the clerk and the total amount of money the bank of this clerk
	 * currently holds. Then it listens for keys in the console. When pressing X,
	 * the program will stop. When pressing P, it shows all account balances grouped
	 * by the bank. When pressing S, it shows the current spendings of the clerk as
	 * well as the sum of all balances of the clerk's bank.
	 * 
	 * @param args Arguments, that can be passed to the program on startup. Mostly
	 *             environment variables.
	 */
	public static void main(String[] args) {
		Bank_Weingand bank = new Bank_Weingand();
		Clerk_Weingand clerk1 = new Clerk_Weingand(bank);
		Clerk_Weingand clerk2 = new Clerk_Weingand(bank);
		
		clerk1.start();
		clerk2.start();

		Timer timer = new Timer();
		/**
		 * Schedules a timer, that kicks every ten seconds.
		 */
		timer.schedule(new TimerTask() {
			/**
			 * This method will be entered every ten seconds.
			 */
			@Override
			public void run() {
				System.out.println("clerk1: " + clerk1.getSpendingsAndTotalBalance());
				System.out.println("clerk2: " + clerk2.getSpendingsAndTotalBalance());
			}
		}, 0, 10000);

		boolean xPressed = false;
		while (!xPressed) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String input = "";
			try {
				input = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			switch (input) {
			case "X":
				xPressed = true;
				break;
			case "P":
				clerk1.showAllBalances();
				clerk2.showAllBalances();
				break;
			case "S":
				System.out.println("clerk1: " + clerk1.getSpendingsAndTotalBalance());
				System.out.println("clerk2: " + clerk2.getSpendingsAndTotalBalance());
				break;
			}
		}
		timer.cancel();
	}

}
