import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import resume.Resume;

public class BasicInformationView extends View {

	private ScreenManager manager;
	private Resume resume;
	private JTextField name, address, email, objective, phone;

	public BasicInformationView(ScreenManager manager, Resume resume) {
		super();

		this.manager = manager;
		this.resume = resume;

		JButton nextButton = new JButton("Next");
		nextButton.setBounds(600, 700, 160, 60);
		nextButton.addActionListener(e -> {
			resume.init(name.getText(), email.getText(), address.getText(), objective.getText(), phone.getText());
			manager.showEducationView();
		});
		this.add(nextButton);

		name = new JTextField(20);
		name.setBounds(125, 200, 200, 30);
		name.setText("Name");
		this.add(name);

		address = new JTextField(20);
		address.setBounds(125, 300, 200, 30);
		address.setText("Address");
		this.add(address);

		email = new JTextField(20);
		email.setBounds(125, 400, 200, 30);
		email.setText("Email");
		this.add(email);

		objective = new JTextField(20);
		objective.setBounds(125, 500, 200, 30);
		objective.setText("Objective");
		this.add(objective);

		phone = new JTextField(20);
		phone.setBounds(125, 600, 200, 30);
		phone.setText("Phone");
		this.add(phone);

	}

	public void draw(Graphics g) {

		g.setFont(new Font("Tahoma", Font.PLAIN, 45));
		g.setColor(yellow);
		g.fillRect(0, 64, 30, 42);

		g.setColor(black);
		g.drawString("Basic information", 45, 100);
	}

}