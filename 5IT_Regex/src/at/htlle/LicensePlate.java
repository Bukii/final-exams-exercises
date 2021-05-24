package at.htlle;

/**
 * Represents a license plate. E.g. AT-1235
 * 
 * @author Lukas
 *
 */
public class LicensePlate implements Comparable<LicensePlate> {
	
	private Integer id;
	private String countryCode;
	private String number;

	public LicensePlate(Integer id, String line) {
		this.id = id;
		this.countryCode = line.split("-")[0];
		this.number = line.split("-")[1];
	}

	@Override
	public String toString() {
		return "LicensePlate [countryCode=" + countryCode + ", number=" + number + "]";
	}

	@Override
	public int compareTo(LicensePlate lp) {
		return this.countryCode.compareTo(lp.countryCode);
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getNumber() {
		return number;
	}
}
