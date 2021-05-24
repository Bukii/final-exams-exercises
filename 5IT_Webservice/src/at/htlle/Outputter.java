package at.htlle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * The main class of the project. It reads the csv file and converts its lines
 * to a list of Java objects. It also listens for any input and ouputs the
 * corresponding answer in the right format.
 * 
 * @author Lukas
 *
 */
public class Outputter {

	/**
	 * Has the url stored and calls the readFile function. Then converts the list of
	 * string from the readFile function to a list of Java obejcts for better usage.
	 * After all, it calls the inputListener function, which listens to any input.
	 * 
	 * @param args Optional parameter (environment parameter), which can be passed
	 *             to the program on start up.
	 */
	public static void main(String[] args) {
		String urlPath = "http://localhost:8080/fernsehprogramm.csv";
		List<String> lines = readFile(urlPath);

		List<Serie> series = new ArrayList<>();
		for (String line : lines) {
			series.add(new Serie(line));
		}

		inputListener(series);
	}

	/**
	 * Listens for any user input. If the user input is empty it will output all
	 * series. Otherwise it will only print those series, which contain the
	 * searchString in their name.
	 * 
	 * @param series The list of series in the csv file.
	 */
	public static void inputListener(List<Serie> series) {
		while (true) {
			System.out.print("Geben sie einen Suchbegriff ein: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String input = "";
			try {
				input = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			HashSet<String> hs = new HashSet<>();
			for (Serie s : series) {
				hs.add(s.name);
			}

			if (input.equals("")) {
				for (Serie s : series) {
					System.out.println(s);
				}
				groupSeries(hs, series);
				printHistogram(hs, series);
			} else {
				HashSet<String> newHs = new HashSet<>();
				for (String s : hs) {
					if (s.contains(input)) {
						newHs.add(s);
						System.out.println(s);
						for (Serie serie : series) {
							if (serie.name.endsWith(s)) {
								System.out.println(serie.time);
							}
						}
					}
				}
				groupSeries(newHs, series);
				printHistogram(newHs, series);
			}
		}
	}

	/**
	 * Prints the ASCII Art histogram of all the series, which have an amount
	 * greater than 2. At the end it also has a little legend, that explains all the
	 * columns.
	 * 
	 * @param hs     The HashSet of all series there are.
	 * @param series The list of series from the csv file.
	 */
	private static void printHistogram(HashSet<String> hs, List<Serie> series) {
		List<SeriesAmount> sa = new ArrayList<>();
		for (String str : hs) {
			if (getSeriesAmount(series, str) > 2) {
				sa.add(new SeriesAmount(str, getSeriesAmount(series, str)));
			}
		}
		Collections.sort(sa, Collections.reverseOrder());

		System.out.println();
		System.out.println("  ^\n" + "  |");

		int max = sa.get(0).amount;
		int counter = 0;
		for (int i = max; i > 0; i--) {
			for (SeriesAmount sas2 : sa) {
				if (sas2.amount == i) {
					counter++;
				}
			}
			String buildStr = i + " |  ";
			for (int j = 0; j < counter; j++) {
				buildStr += "XXX  ";
			}

			String buildStr2 = buildStr.replace(String.valueOf(i), " ");

			System.out.println(buildStr);
			System.out.println(buildStr2);
		}

		String endStr = "";
		for (int i = 0; i < counter; i++) {
			endStr += "-----";
		}
		System.out.println("  +-" + endStr + "->");

		String finalStr = "";
		for (int i = 0; i < counter; i++) {
			finalStr += " [" + i + "] ";
		}
		System.out.println("    " + finalStr + "");

		System.out.println();

		for (int i = 0; i < counter; i++) {
			System.out.println(" [" + i + "] ... " + sa.get(i).name);
		}

		System.out.println();
	}

	/**
	 * Outputs a table with 2 columns. The first one being the name of the series
	 * and the second one the amount of times the series is shown in TV.
	 * 
	 * @param hs     The HashSet of all series coming from the csv file.
	 * @param series A list of all series from the csv file.
	 */
	private static void groupSeries(HashSet<String> hs, List<Serie> series) {
		String outputString = "\n ________________________________________________ \n"
				+ "|         Name            |        Amount        |\n"
				+ "|------------------------------------------------|\n";

		List<SeriesAmount> sa = new ArrayList<>();
		for (String str : hs) {
			sa.add(new SeriesAmount(str, getSeriesAmount(series, str)));
		}
		Collections.sort(sa, Collections.reverseOrder());

		for (SeriesAmount sas : sa) {
			outputString += String.format("| %-23s | %-20d |%n", sas.name, sas.amount)
					+ "|------------------------------------------------|\n";
		}
		outputString += "|________________________________________________|";

		System.out.println(outputString);
	}

	/**
	 * Gets a name of one series and counts the total amount of times this series is
	 * shown on TV.
	 * 
	 * @param series The list of series provided by the csv file.
	 * @param str    The name of the series.
	 * @return The total amount of times this series is shown on TV.
	 */
	private static Integer getSeriesAmount(List<Serie> series, String str) {
		Integer counter = 0;
		for (Serie s : series) {
			if (s.name.equals(str)) {
				counter++;
			}
		}
		return counter;
	}

	/**
	 * Reads all lines from the csv file from the url, converts them to a list and
	 * returns the list to the parent.
	 * 
	 * @param path The URL path, where the csv is stored.
	 * @return The list of strings, which is basically a list of all rows in the
	 *         csv.
	 */
	private static List<String> readFile(String path) {
		List<String> lines = new ArrayList<>();

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new URL(path).openStream()));

			String line;
			while ((line = br.readLine()) != null) {
				if (!line.equals("")) {
					lines.add(line);
				}
			}
			br.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lines;
	}

}
