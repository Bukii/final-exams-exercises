package at.htlle;

/**
 * Represents an airplane.
 * 
 * @author Lukas
 *
 */
public class Airplane {

	private final Integer CARRY = 20000;
	private Integer boxes = 0;
	private Double weight = 0.0;
	private Integer sus = 0;
	private Integer dang = 0;

	/**
	 * Returns the number of boxes that fit in that airplane with a specific weight.
	 * 
	 * @param boxWeight The weight one box weighs.
	 * @return The number of boxes that fit in this airplane.
	 */
	public Integer hasSpaceFor(Double boxWeight) {
		return (int) Math.floor((this.CARRY - this.weight) / boxWeight);
	}

	/**
	 * Adds new boxes to this airplane and increments the weight and adds the amount
	 * of suspicious and dangerous boxes to the object.
	 * 
	 * @param newBoxes  The number of boxes.
	 * @param incWeight The weight of all this boxes.
	 * @param sus       The amount of suspicious boxes.
	 * @param dang      The amount of dangerous boxes.
	 */
	public void newBox(Integer newBoxes, Double incWeight, Integer sus, Integer dang) {
		this.boxes += newBoxes;
		this.weight += incWeight;
		this.sus += sus;
		this.dang += dang;
	}

	/**
	 * Get all the boxes in this airplane.
	 * 
	 * @return The number of boxes.
	 */
	public Integer getBoxes() {
		return this.boxes;
	}

	/**
	 * Get the total weight this airplane has.
	 * 
	 * @return The total weight of this airplane.
	 */
	public Double getWeight() {
		return this.weight;
	}

	public String getSusOrDang() {
		if (this.sus > 0) {
			if (this.dang > 0) {
				return "This Airplane might have suspicious and dangerous boxes onboard.";
			}
			return "This Airplane might have suspicious boxes onboard.";
		}
		return "This Airplane is fine!";
	}

}
