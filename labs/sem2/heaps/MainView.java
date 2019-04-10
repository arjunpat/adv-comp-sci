import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MainView extends View {

	private Runner runner;
	private Database db;

	public MainView(Runner runner, Database db) {
		this.db = db;
		db.addChangeListener(this);

		JButton toServer = new JButton("Server View");
		toServer.setBounds(20, 70, 140, 60);
		toServer.addActionListener(e -> {
			runner.openServerWindow();
		});
		this.add(toServer);

		JButton toChef = new JButton("Chef View");
		toChef.setBounds(20, 150, 140, 60);
		toChef.addActionListener(e -> {
			runner.openChefWindow();
		});
		this.add(toChef);

	}

	public void onChange() {}

	public void draw(Graphics g) {
		drawTitle(g, Color.RED, "Open a view", 20, 40);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(200, 250);
	}
}