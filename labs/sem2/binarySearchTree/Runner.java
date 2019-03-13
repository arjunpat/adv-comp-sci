import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Runner {
	private JFrame jFrame = new JFrame("Bank");
	private Database db = new Database("names.txt");

	public Runner() {
		showHomeScreen();
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