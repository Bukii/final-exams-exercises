package at.htlle;

/**
 * A child of Article. It's a DVD object. It has several variables and their
 * getters as well as a constructor, which is used to assign its variables and a
 * getPrice method, which calculates its price by taking the article's price and
 * multiplying that by the VAT.
 * 
 * @author Lukas
 *
 */
public class DVD extends Article {

	private String name;
	private Integer duration;
	private Integer countryCode;
	public static final Float VAT = 0.19f;

	/**
	 * Constructor for the DVD object. Calls the super method (constructor of the
	 * parent class) to initialise its variables.
	 * 
	 * @param articleNumber The number of this article.
	 * @param price         The price for which this article sells.
	 * @param name          The name of the DVD.
	 * @param duration      The duration of the DVD.
	 * @param countryCode   The country the DVD is from.
	 */
	public DVD(Integer articleNumber, Float price, String name, Integer duration, Integer countryCode) {
		super(articleNumber, price);
		this.name = name;
		this.duration = duration;
		this.countryCode = countryCode;
	}

	/**
	 * Get the name of the DVD.
	 * 
	 * @return The name of the DVD.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the duration of this DVD.
	 * 
	 * @return The duration.
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * The country, where this DVD is from.
	 * 
	 * @return The country code of this object.
	 */
	public Integer getCountryCode() {
		return countryCode;
	}

	/**
	 * The VAT of this article.
	 * 
	 * @return The VAT of this article.
	 */
	public Float getVat() {
		return VAT;
	}

	/**
	 * Overrides the getPrice method from the parent class (Article). It adds the
	 * VAT of this article.
	 */
	@Override
	public Float getPrice() {
		return Math.round((super.getPrice() + super.getPrice() * Book.VAT) * 100.0f) / 100.0f;
	}

	/**
	 * Overrides the normal toString method of this class. For personalisation
	 * purposes.
	 */
	@Override
	public String toString() {
		return "DVD - " + name;
	}

}
