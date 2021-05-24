package at.htlle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

/**
 * The main class, doing all the work needed.
 * 
 * @author Lukas
 *
 */
public class Main {

	/**
	 * Calls the readFile method to gather the JAVA objects and then use them to
	 * calculate the airplanes needed.s
	 * 
	 * @param args Optional parameter, that can be passed in on start up.
	 */
	public static void main(String[] args) {
		List<Delivery> deliveries = readFileToJson(args[0]);

		calcAirplanes(deliveries, args[0]);
	}

	/**
	 * Calculates the amount of airplanes that is needed to fly the boxes to
	 * specific regions.
	 * 
	 * @param deliveries The list of delivery objects, gathered from the JSON file.
	 */
	private static void calcAirplanes(List<Delivery> deliveries, String filename) {
		List<Airplane> emeaAirplanes = new ArrayList<>();
		List<Airplane> apacAirplanes = new ArrayList<>();
		List<Airplane> amerAirplanes = new ArrayList<>();

		Airplane em = new Airplane();
		Airplane ap = new Airplane();
		Airplane am = new Airplane();
		for (Delivery d : deliveries) {
			Integer emFreeAmount = em.hasSpaceFor(d.getBoxWeight());
			Integer apFreeAmount = ap.hasSpaceFor(d.getBoxWeight());
			Integer amFreeAmount = am.hasSpaceFor(d.getBoxWeight());

			if (d.getEmeaBoxes() != 0) {
				if (emFreeAmount > d.getEmeaBoxes()) {
					em.newBox(d.getEmeaBoxes(), d.getBoxWeight() * d.getEmeaBoxes(), d.getSusBoxes(), d.getDangerousBoxes());
				} else {
					em.newBox(emFreeAmount, d.getBoxWeight() * emFreeAmount, d.getSusBoxes(), d.getDangerousBoxes());
					emeaAirplanes.add(em);
					em = new Airplane();
					em.newBox(d.getEmeaBoxes() - emFreeAmount, d.getBoxWeight() * (d.getEmeaBoxes() - emFreeAmount), d.getSusBoxes(), d.getDangerousBoxes());
				}
			}

			if (d.getApacBoxes() != 0) {
				if (apFreeAmount > d.getApacBoxes()) {
					ap.newBox(d.getApacBoxes(), d.getBoxWeight() * d.getApacBoxes(), d.getSusBoxes(), d.getDangerousBoxes());
				} else {
					ap.newBox(apFreeAmount, d.getBoxWeight() * apFreeAmount, d.getSusBoxes(), d.getDangerousBoxes());
					apacAirplanes.add(ap);
					ap = new Airplane();
					ap.newBox(d.getApacBoxes() - apFreeAmount, d.getBoxWeight() * (d.getApacBoxes() - apFreeAmount), d.getSusBoxes(), d.getDangerousBoxes());
				}
			}

			if (d.getAmerBoxes() != 0) {
				if (amFreeAmount > d.getAmerBoxes()) {
					am.newBox(d.getAmerBoxes(), d.getBoxWeight() * d.getAmerBoxes(), d.getSusBoxes(), d.getDangerousBoxes());
				} else {
					am.newBox(amFreeAmount, d.getBoxWeight() * amFreeAmount, d.getSusBoxes(), d.getDangerousBoxes());
					amerAirplanes.add(am);
					am = new Airplane();
					am.newBox(d.getAmerBoxes() - amFreeAmount, d.getBoxWeight() * (d.getAmerBoxes() - amFreeAmount), d.getSusBoxes(), d.getDangerousBoxes());
				}
			}
		}
		emeaAirplanes.add(em);
		apacAirplanes.add(ap);
		amerAirplanes.add(am);

		System.out.println("EMEA: " + emeaAirplanes.size() + " Plane(s)");
		System.out.println("APAC: " + apacAirplanes.size() + " Plane(s)");
		System.out.println("AMER: " + amerAirplanes.size() + " Plane(s)");

		int count = 1;
		System.out.println();
		System.out.println("EMEA");
		System.out.println("====");
		for (int i = 0; i < emeaAirplanes.size(); i++) {
			System.out.println(count + i + ". Airplane with " + emeaAirplanes.get(i).getBoxes()
					+ " Boxes and a total weight of " + emeaAirplanes.get(i).getWeight() + " kg.");
		}
		count += emeaAirplanes.size();

		System.out.println();
		System.out.println("APAC");
		System.out.println("====");
		for (int i = 0; i < apacAirplanes.size(); i++) {
			System.out.println(count + i + ". Airplane with " + apacAirplanes.get(i).getBoxes()
					+ " Boxes and a total weight of " + apacAirplanes.get(i).getWeight() + " kg.");
		}
		count += apacAirplanes.size();

		System.out.println();
		System.out.println("AMER");
		System.out.println("====");
		for (int i = 0; i < amerAirplanes.size(); i++) {
			System.out.println(count + i + ". Airplane with " + amerAirplanes.get(i).getBoxes()
					+ " Boxes and a total weight of " + amerAirplanes.get(i).getWeight() + " kg.");
		}

		toHTMLTable(emeaAirplanes, apacAirplanes, amerAirplanes, filename);
	}

	/**
	 * Prints the data from the calcAirplanes method into a HTML table and writes
	 * that into a file.
	 * 
	 * @param emeaAirplanes All the airplanes flying to EMEA in a list.
	 * @param apacAirplanes List of all APAC airplanes.
	 * @param amerAirplanes List of all AMER airplanes.
	 * @param filename      The name of file of the JSON, which will then be a HTML
	 *                      type file.
	 */
	private static void toHTMLTable(List<Airplane> emeaAirplanes, List<Airplane> apacAirplanes,
			List<Airplane> amerAirplanes, String filename) {
		File htmlFile = new File(filename.replace("json", "html"));

		StringBuilder sb = new StringBuilder();

		StringBuilder sideBuilder = new StringBuilder();
		sideBuilder.append("<table>");
		sideBuilder.append("<tr>");
		sideBuilder.append("<th>Id</th>");
		sideBuilder.append("<th>Box amount</th>");
		sideBuilder.append("<th>Weight</th>");
		sideBuilder.append("<th>Suspicious OR Dangerous</th>");
		sideBuilder.append("</tr>");

		int count = 0;
		sb.append("<h1>EMEA</h1>");
		sb.append(sideBuilder);
		for (Airplane a : emeaAirplanes) {
			sb.append("<tr>");
			sb.append("<td>" + count + "</td>");
			sb.append("<td>" + a.getBoxes() + "</td>");
			sb.append("<td>" + a.getWeight() + "</td>");
			sb.append("<td>" + a.getSusOrDang() + "</td>");
			sb.append("</tr>");
			count++;
		}
		sb.append("</table>");
		sb.append("<h1>APAC</h1>");
		sb.append(sideBuilder);
		for (Airplane a : apacAirplanes) {
			sb.append("<tr>");
			sb.append("<td>" + count + "</td>");
			sb.append("<td>" + a.getBoxes() + "</td>");
			sb.append("<td>" + a.getWeight() + "</td>");
			sb.append("<td>" + a.getSusOrDang() + "</td>");
			sb.append("</tr>");
			count++;
		}
		sb.append("</table>");
		sb.append("<h1>AMER</h1>");
		sb.append(sideBuilder);
		for (Airplane a : amerAirplanes) {
			sb.append("<tr>");
			sb.append("<td>" + count + "</td>");
			sb.append("<td>" + a.getBoxes() + "</td>");
			sb.append("<td>" + a.getWeight() + "</td>");
			sb.append("<td>" + a.getSusOrDang() + "</td>");
			sb.append("</tr>");
			count++;
		}
		sb.append("</table>");

		FileWriter writer;
		try {
			writer = new FileWriter(htmlFile);
			writer.write(sb.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Read the JSON objects from the JSON file and convert it to JAVA objects and
	 * store those in a list.
	 * 
	 * @return The list of JAVA objects.
	 */
	private static List<Delivery> readFileToJson(String path) {
		File f = new File(path);

		JsonReader jr = null;
		try {
			jr = new JsonReader(new FileReader(f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Gson gson = new GsonBuilder().create();

		Type listType = new TypeToken<ArrayList<Delivery>>() {
		}.getType();
		List<Delivery> list = gson.fromJson(jr, listType);

		return list;
	}

}
