package at.htlle;

import com.google.gson.annotations.SerializedName;

/**
 * Model class for a delivery from a LKW. The SerializedName annotations are
 * used for object assignment in GSON.
 * 
 * @author Lukas
 *
 */
public class Delivery {

	@SerializedName("Arrival")
	private Integer arrival;
	@SerializedName("EMEA")
	private Integer emea;
	@SerializedName("APAC")
	private Integer apac;
	@SerializedName("AMER")
	private Integer amer;
	@SerializedName("Other")
	private Integer other;
	@SerializedName("Suspicious")
	private Integer sus;
	@SerializedName("Dangerous")
	private Integer dangerous;
	@SerializedName("Weight")
	private Double weight;
	@SerializedName("BoardingTime")
	private String boardingTime;

	/**
	 * Constructor method for this object.
	 * 
	 * @param arrival      Id number for the object.
	 * @param emea         Number of boxes going to the EMEA region.
	 * @param apac         Number of boxes going to the APAC region.
	 * @param amer         Number of boxes going to the AMER region.
	 * @param other        Number of boxes going to the other regions.
	 * @param sus          Number of boxes that are suspicious.
	 * @param dangerous    Number of boxes that are dangerous
	 * @param weight       The weight of all the boxes.
	 * @param boardingTime The time it took to store them in the LKW.
	 */
	public Delivery(Integer arrival, Integer emea, Integer apac, Integer amer, Integer other, Integer sus,
			Integer dangerous, Double weight, String boardingTime) {
		super();
		this.arrival = arrival;
		this.emea = emea;
		this.apac = apac;
		this.amer = amer;
		this.other = other;
		this.sus = sus;
		this.dangerous = dangerous;
		this.weight = weight;
		this.boardingTime = boardingTime;
	}

	/**
	 * Overrides the toString method in order to get all warnings away and for
	 * easier use in other classes.
	 */
	@Override
	public String toString() {
		return "Delivery [arrival=" + arrival + ", emea=" + emea + ", apac=" + apac + ", amer=" + amer + ", other="
				+ other + ", sus=" + sus + ", dangerous=" + dangerous + ", weight=" + weight + ", boardingTime="
				+ boardingTime + "]";
	}

	/**
	 * Calculates the weight of one box.
	 * 
	 * @return The weight of one box.
	 */
	public Double getBoxWeight() {
		return this.weight / (this.emea + this.apac + this.amer + this.other);
	}

	/**
	 * Get the number of EMEA boxes.
	 * 
	 * @return The amount of EMEA boxes.
	 */
	public Integer getEmeaBoxes() {
		return this.emea;
	}

	/**
	 * Get the number of APAC boxes.
	 * 
	 * @return The number of APAC boxes.
	 */
	public Integer getApacBoxes() {
		return this.apac;
	}

	/**
	 * Get the number of AMER boxes.
	 * 
	 * @return The number of AMER boxes.
	 */
	public Integer getAmerBoxes() {
		return this.amer;
	}

	/**
	 * Get the amount of boxes that are suspicious.
	 * 
	 * @return The amount of suspicious boxes.
	 */
	public Integer getSusBoxes() {
		return this.sus;
	}

	/**
	 * Get the amount of dangerous boxes in this delivery.
	 * 
	 * @return The amont of dangerous boxes.
	 */
	public Integer getDangerousBoxes() {
		return this.dangerous;
	}

}
