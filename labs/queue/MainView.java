import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MainView extends View {

	private Runner runner;
	private Database database;

	public MainView(Runner runner, Database database) {
		super();
		this.database = database;

		JButton toAdmin = new JButton("Admin View");
		toAdmin.setBounds(20, 70, 140, 60);
		toAdmin.addActionListener(e -> {
			runner.openAdminWindow();
		});
		this.add(toAdmin);

		JButton toBiller = new JButton("Biller View");
		toBiller.setBounds(20, 150, 140, 60);
		toBiller.addActionListener(e -> {
			runner.openBillerWindow();
		});
		this.add(toBiller);

		JButton toDoctor = new JButton("Doctor View");
		toDoctor.setBounds(20, 230, 140, 60);
		toDoctor.addActionListener(e -> {
			runner.openDoctorWindow();
		});
		this.add(toDoctor);

		JButton toNurse = new JButton("Nurse View");
		toNurse.setBounds(20, 310, 140, 60);
		toNurse.addActionListener(e -> {
			runner.openNurseWindow();
		});
		this.add(toNurse);

	}

	public void draw(Graphics g) {
		drawTitle(g, red, "Open a view", 20, 40);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(200, 400);
	}

}