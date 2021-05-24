package at.htlle;

/**
 * A child of Article. It's a book object. It has several variables and their
 * getters as well as a constructor, which is used to assign its variables and a
 * getPrice method, which calculates its price by taking the article's price and
 * multiplying that by the VAT.
 * 
 * @author Lukas
 *
 */
public class Book extends Article {

	private String title;
	private String author;
	private Integer year;
	public static final Float VAT = 0.07f;

	/**
	 * Constructor for the book object. Calls the super method (constructor of the
	 * parent class) to initialise its variables.
	 * 
	 * @param articleNumber The number of this article.
	 * @param price         The price of this article (without VAT).
	 * @param title         The title of the book.
	 * @param author        The author of this book.
	 * @param year          The year, the book has been published.
	 */
	public Book(Integer articleNumber, Float price, String title, String author, Integer year) {
		super(articleNumber, price);
		this.title = title;
		this.author = author;
		this.year = year;
	}

	/**
	 * Get the title of this book.
	 * 
	 * @return The title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Get the author of this book.
	 * 
	 * @return The author of this book.
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Get the year of publish of this book.
	 * 
	 * @return This object's year variable.
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * Get the VAT of this object.
	 * 
	 * @return The VAT variable.
	 */
	public Float getVat() {
		return VAT;
	}

	/**
	 * Overrides the getPrice method given by the parent class. It adds the VAT to
	 * the price.
	 */
	@Override
	public Float getPrice() {
		return Math.round((super.getPrice() + super.getPrice() * Book.VAT) * 100.0f) / 100.0f;
	}

	/**
	 * Overrides the toString method of this class, for personalised usage.
	 */
	@Override
	public String toString() {
		return "Buch - " + author + ": " + title + "(" + year + ")";
	}

}
