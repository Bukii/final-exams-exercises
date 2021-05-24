package at.htlle;

/**
 * Represents one line in the csv file.
 * 
 * @author Lukas
 *
 */
public class Serie {

	protected String time;
	protected String name;
	protected String type;

	/**
	 * Basic constructor for this object. Takes the entire line and converts/splits
	 * it in order to get all parameters.
	 * 
	 * @param line The entire line of the of one entry in the csv file. ";" between columns.
	 */
	public Serie(String line) {
		super();

		if (line != null) {
			String[] split = line.split(";");

			this.time = split[0];
			this.name = split[1];
			this.type = split[2];
		}
	}

	/**
	 * Overrides the default toString method.
	 */
	@Override
	public String toString() {
		return "Serie [time=" + time + ", name=" + name + ", type=" + type + "]";
	}
	
}
