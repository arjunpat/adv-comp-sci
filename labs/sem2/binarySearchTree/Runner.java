import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Runner {
	private JFrame jFrame = new JFrame("Bank");
	private Database db;

	public Runner() {
		try {
			FileInputStream fis = new FileInputStream("database.ser");
			ObjectInputStream in = new ObjectInputStream(fis);
			db = (Database) in.readObject();
			in.close();
		} catch (Exception e) {
			db = new Database("names.txt");
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

	public void showHomeScreen() {
		updateScreen(new HomeScreen(this, db));
	}

	public void showAdminScreen() {
		updateScreen(new AdminScreen(this, db));
	}

	public void updateScreen(View view) {
		jFrame.setContentPane(view);
		jFrame.pack();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}

	public static void main(String[] args) {
		new Runner();
	}
}