package at.htlle;

/**
 * Parent class for Book and DVD.
 * 
 * @author Lukas
 *
 */
public class Article {

	private Integer articleNumber;
	private Float price;

	/**
	 * Constructor for the Article class object.
	 * 
	 * @param articleNumber The number of this article object.
	 * @param price         The price this article has.
	 */
	public Article(Integer articleNumber, Float price) {
		this.articleNumber = articleNumber;
		this.price = price;
	}

	/**
	 * Returns the price of this article.
	 * 
	 * @return The price of this object.
	 */
	public Float getPrice() {
		return this.price;
	}

	/**
	 * Returns the number of this article object.
	 * 
	 * @return The article number.
	 */
	public Integer getArticleNumber() {
		return articleNumber;
	}

}
