import java.util.Scanner;
import java.io.File;

import java.io.Serializable;

public class Database implements Serializable {
	private HashMap<String, Country> countries = new HashMap<String, Country>();
	private HashMap<Country, EachImage> images = new HashMap<Country, EachImage>();

	public Database(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));

			while (in.hasNextLine()) {
				String[] parts = in.nextLine().split(",");
				countries.put(parts[0], new Country(parts[1], parts[0]));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		images.put(getCountryByAbbr("af"), new EachImage("https://images.huffingtonpost.com/2015-11-05-1446719735-6867599-Kabul_Skyline-thumb.jpg", "Nice view", "2006-03-15"));
		images.put(getCountryByAbbr("af"), new EachImage("https://c8.alamy.com/comp/DGYJNE/casa-granda-building-parque-cespedes-park-santiago-de-cuba-historic-DGYJNE.jpg", "Nice view", "2006-09-09"));
		images.put(getCountryByAbbr("af"), new EachImage("https://media2.trover.com/T/58173ed09984285a63002e8e/fixedw_large_4x.jpg", "Nice view", "2015-10-4"));

	}

	public DLList<String> getCountriesAbbr() {
		return countries.getKeys();
	}

	public Country getCountryByAbbr(String abbr) {
		return countries.get(abbr).get(0);
	}

	public DLList<EachImage> getImageListByCountry(Country c) {
		return images.get(c);
	}

	public void addImage(Country c, EachImage i) {
		images.put(c, i);
	}
}