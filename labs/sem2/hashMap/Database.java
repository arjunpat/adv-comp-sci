import java.util.Scanner;
import java.io.File;

public class Database {
	private HashMap<String, Country> countries = new HashMap<String, Country>();
	private HashMap<Country, Image> images = new HashMap<Country, Image>();

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
	}

	public DLList<String> getCountriesAbbr() {
		return countries.getKeys();
	}

	public Country getCountryByAbbr(String abbr) {
		return countries.get(abbr).get(0);
	}
}