package at.htlle;

import java.util.ArrayList;
import java.util.List;

/**
 * Simulates a shopping cart. In it's main method, it creates a list of articles
 * (DVD and books) and then shows the full bill.
 * 
 * @author Lukas
 *
 */
public class ShoppingCart {

	public static Integer bookCount = 10;
	public static Integer dvdCount = 12;
	public static List<Article> articleList = new ArrayList<>();

	/**
	 * Creates a given amount of articles and calls the showBill method.
	 * 
	 * @param args Optional arguments that can be passed to the program on start up.
	 */
	public static void main(String[] args) {
		ProductGenerator generator = new ProductGenerator();

		articleList.addAll(generator.bookGenerator(bookCount));
		articleList.addAll(generator.dvdGenerator(dvdCount));

		showBill();
	}

	/**
	 * Generate books and dvds. Only for test purposes.
	 */
	public static void generateArticles() {
		ProductGenerator generator = new ProductGenerator();

		articleList.addAll(generator.bookGenerator(bookCount));
		articleList.addAll(generator.dvdGenerator(dvdCount));
	}

	/**
	 * For every article, it will print the calculated price. And at the end, it
	 * writes the sum of all those prices.
	 */
	private static void showBill() {
		Float total = 0.0f;
		for (Article art : articleList) {
			Float price = 0.0f;
			if (art instanceof Book) {
				price = ((Book) art).getPrice();
			} else if (art instanceof DVD) {
				price = ((DVD) art).getPrice();
			}
			System.out.printf("%-50s %10s Euro %n", art, price);
			total += price;
		}
		System.out.println("-----------------------------");
		System.out.println("Gesamtpreis: " + Math.round(total * 100.0f) / 100.0f + " Euro");
	}

}
