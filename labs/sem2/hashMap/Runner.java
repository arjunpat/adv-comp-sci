import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Runner {

	private Database db = new Database("countries.txt");
	private JFrame jFrame = new JFrame("Thing");;

	public Runner() {
		showHomeScreen();
	}

	private void updateScreen(View view) {
		jFrame.setContentPane(view);
		jFrame.pack();
		jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jFrame.setVisible(true);
	}

	public void showHomeScreen() {
		updateScreen(new HomeScreen(db, this));
	}

	public void showCountry(Country country) {
		updateScreen(new CountryScreen(db, country, this));
	}

	public static void main(String[] args) {
		new Runner();
	}
}