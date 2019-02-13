import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Runner extends View {

	private Database db = new Database("countries.txt");
	private JTextArea countriesTextArea = new JTextArea(390, 350);

	public Runner() {
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
			System.out.println(country);

			countryAbbr.setText("Country abbreviation");
		});
		add(findCountry);
	}

	public void draw(Graphics g) {
		drawTitle(g, Color.RED, "Countries", 400, 30);
	}

	public void populateCountriesTextArea() {
		DLList<String> keys = db.getCountriesAbbr();

		String str = "";

		for (int i = 0; i < keys.size(); i++) {
			str += db.getCountryByAbbr(keys.get(i)).toString() + "\n";
		}

		countriesTextArea.setText(str);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Poker");

		frame.add(new Runner());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}