package at.htlle;

/**
 * Represents one row for the table that should be shown. Also implements the
 * Comparable class, which is used to compare this object to others.
 * 
 * @author Lukas
 *
 */
public class SeriesAmount implements Comparable<SeriesAmount> {

	protected String name;
	protected Integer amount;

	/**
	 * Assigns the parameter to the objects values.
	 * 
	 * @param name   The name of the series.
	 * @param amount The amount of times this series is shown.
	 */
	public SeriesAmount(String name, Integer amount) {
		super();
		this.name = name;
		this.amount = amount;
	}

	/**
	 * Overrides the compareTo method to tell the object, what to use to sort the
	 * object.
	 */
	@Override
	public int compareTo(SeriesAmount sa) {
		return this.amount.compareTo(sa.amount);
	}

}
