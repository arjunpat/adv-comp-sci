import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Runner {

	private Database db /*= new Database("countries.txt")*/;
	private JFrame jFrame = new JFrame("Thing");;

	public Runner() {
		try {
			FileInputStream fis = new FileInputStream("database.ser");
			ObjectInputStream in = new ObjectInputStream(fis);
			db = (Database) in.readObject();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		showHomeScreen();

		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				try {
					FileOutputStream fos = new FileOutputStream("database.ser");
					ObjectOutputStream out = new ObjectOutputStream(fos);
					out.writeObject(db);

					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}));	
	}

	private void updateScreen(View view) {
		jFrame.setContentPane(view);
		jFrame.pack();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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