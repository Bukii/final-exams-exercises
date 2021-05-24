package at.htlle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * The main class, which contains the logic of the program.
 * 
 * @author Lukas
 *
 */
public class Main {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Welcome to the LicenseTemplateReader of Lukas Weingand (161wit21).");
			System.out.println("Please give me as first argument the filename which should be processed.");
			System.exit(0);
		}

		String path = args[0];

		HashSet<String> hs = readFile(path);
		List<LicensePlate> licensePlates = new ArrayList<>();

		int count = 0;
		for (String st : hs) {
			licensePlates.add(new LicensePlate(count, st));
			count++;
		}

		Collections.sort(licensePlates);
		licensePlates.forEach(System.out::println);

		HashMap<String, Integer> hm = new HashMap<>();
		for (LicensePlate lp : licensePlates) {
			if (hm.containsKey(lp.getCountryCode())) {
				hm.replace(lp.getCountryCode(), hm.get(lp.getCountryCode()), hm.get(lp.getCountryCode()) + 1);
			} else {
				hm.put(lp.getCountryCode(), 1);
			}
		}
		
		HashSet<String> idk = new HashSet<>();
		for (LicensePlate lp : licensePlates) {
			if (!idk.contains(lp.getCountryCode())) {
				System.out.println("Land: " + lp.getCountryCode() + " | Anzahl: " + hm.get(lp.getCountryCode()));
				idk.add(lp.getCountryCode());
			}
		}
	}

	private static HashSet<String> readFile(String path) {
		File f = new File(path);

		HashSet<String> plates = new HashSet<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));

			String line = "";
			while ((line = br.readLine()) != null) {
				String[] arr = line.split(" ");
				for (String str : arr) {
					if (str.matches("[A-Z]*[-][A-Z0-9]*")) {
						plates.add(str);
					}
				}
			}

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return plates;
	}

}
