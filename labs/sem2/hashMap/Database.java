import java.util.Scanner;
import java.io.File;

public class Database {
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

		images.put(getCountryByAbbr("af"), new EachImage("https://images.huffingtonpost.com/2015-11-05-1446719735-6867599-Kabul_Skyline-thumb.jpg", "Nice view", "3/15/06"));
		images.put(getCountryByAbbr("af"), new EachImage("https://images.huffingtonpost.com/2015-11-05-1446719735-6867599-Kabul_Skyline-thumb.jpg", "Nice view", "3/15/06"));
		images.put(getCountryByAbbr("af"), new EachImage("https://images.huffingtonpost.com/2015-11-05-1446719735-6867599-Kabul_Skyline-thumb.jpg", "Nice view", "3/15/06"));
		images.put(getCountryByAbbr("af"), new EachImage("https://images.huffingtonpost.com/2015-11-05-1446719735-6867599-Kabul_Skyline-thumb.jpg", "Nice view", "3/15/06"));
		images.put(getCountryByAbbr("af"), new EachImage("https://images.huffingtonpost.com/2015-11-05-1446719735-6867599-Kabul_Skyline-thumb.jpg", "Nice view", "3/15/06"));
		images.put(getCountryByAbbr("af"), new EachImage("https://images.huffingtonpost.com/2015-11-05-1446719735-6867599-Kabul_Skyline-thumb.jpg", "Nice view", "3/15/06"));
		images.put(getCountryByAbbr("af"), new EachImage("https://images.huffingtonpost.com/2015-11-05-1446719735-6867599-Kabul_Skyline-thumb.jpg", "Nice view", "3/15/06"));
		images.put(getCountryByAbbr("af"), new EachImage("https://images.huffingtonpost.com/2015-11-05-1446719735-6867599-Kabul_Skyline-thumb.jpg", "Nice view", "3/15/06"));
		images.put(getCountryByAbbr("af"), new EachImage("https://images.huffingtonpost.com/2015-11-05-1446719735-6867599-Kabul_Skyline-thumb.jpg", "Nice view", "3/15/06"));
		images.put(getCountryByAbbr("af"), new EachImage("https://images.huffingtonpost.com/2015-11-05-1446719735-6867599-Kabul_Skyline-thumb.jpg", "Nice view", "3/15/06"));
		images.put(getCountryByAbbr("af"), new EachImage("https://images.huffingtonpost.com/2015-11-05-1446719735-6867599-Kabul_Skyline-thumb.jpg", "Nice view", "3/15/06"));
		images.put(getCountryByAbbr("af"), new EachImage("https://images.huffingtonpost.com/2015-11-05-1446719735-6867599-Kabul_Skyline-thumb.jpg", "Nice view", "3/15/06"));
		

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
}