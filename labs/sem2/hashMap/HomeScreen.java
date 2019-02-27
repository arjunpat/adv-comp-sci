import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class HomeScreen extends View {

	private Database db;
	private JTextArea countriesTextArea = new JTextArea(390, 350);
	private Runner screenManager;

	public HomeScreen(Database db, Runner screenManager) {
		this.db = db;
		this.screenManager = screenManager;

		countriesTextArea.setEditable(false);
		JScrollPane countriesScrollPane = new JScrollPane(countriesTextArea);
		countriesScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		countriesScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		countriesScrollPane.setBounds(400, 50, 390, 350);
		add(countriesScrollPane);
		populateCountriesTextArea();

		JTextField countryAbbr = new JTextField();
		countryAbbr.setBounds(20, 30, 240, 30);
		countryAbbr.setText("Country abbreviation");
		add(countryAbbr);

		JButton findCountry = new JButton("Show country");
		findCountry.setBounds(20, 70, 150, 50);
		findCountry.addActionListener(e -> {
			Country country = db.getCountryByAbbr(countryAbbr.getText());
			showCountry(country);

			countryAbbr.setText("Country abbreviation");
		});
		add(findCountry);
	}

	public void showCountry(Country country) {
		Thread animate = new Thread(new Runnable() {
			public void run() {
				int countryScreenY = 400;
				double acc = 20;
				CountryScreen countryScreen = new CountryScreen(db, country, null);
				countryScreen.setBounds(0, countryScreenY, 800, 800);
				add(countryScreen);

				while (countryScreenY > 0) {
					countryScreen.setOpacity((int)(255 * ((400 - countryScreenY) / 400.0)));
					countryScreen.setLocation(0, countryScreenY);
					repaint();
					try { Thread.sleep(10); } catch (Exception e) {}
					countryScreenY -= acc;
					acc += 3.5;
				}

				screenManager.showCountry(country);
			}
		});

		animate.start();
	}

	public void draw(Graphics g) {
		drawTitle(g, Color.RED, "Countries", 400, 30);
	}

	public void populateCountriesTextArea() {
		DLList<String> keys = db.getCountriesAbbr();

		String str = "";

		for (int i = 0; i < keys.size(); i++) {
			Country c = db.getCountryByAbbr(keys.get(i));
			str += c.toString() + " - " + db.getImageListByCountry(c).size() + " images\n";
		}

		countriesTextArea.setText(str);
	}
}