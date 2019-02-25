import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class HomeScreen extends View {

	private Database db;
	private JTextArea countriesTextArea = new JTextArea(390, 350);
	private Runner screenManager;
	private CountryScreen countryScreen;
	private int countryScreenY;

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
				countryScreenY = 400;
				double acc = 10;
				countryScreen = new CountryScreen(db, country, null);

				while (countryScreenY > 0) {
					countryScreenY -= acc;
					acc += 1.5;
					repaint();
					try { Thread.sleep(10); } catch (Exception e) {}
				}

				screenManager.showCountry(country);
			}
		});

		animate.start();
	}

	public void draw(Graphics g) {
		drawTitle(g, Color.RED, "Countries", 400, 30);

		if (countryScreen != null) {
			countryScreen.draw(g, countryScreenY);
		}
	}

	public void populateCountriesTextArea() {
		DLList<String> keys = db.getCountriesAbbr();

		String str = "";

		for (int i = 0; i < keys.size(); i++) {
			str += db.getCountryByAbbr(keys.get(i)).toString() + "\n";
		}

		countriesTextArea.setText(str);
	}
}