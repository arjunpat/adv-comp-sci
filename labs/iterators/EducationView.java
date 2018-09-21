import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import resume.Resume;

public class EducationView extends View {

	private ScreenManager manager;
	private Resume resume;

	private JTextField name, gradYear, gradMonth, degree;

	public EducationView(ScreenManager manager, Resume resume) {
		super();

		this.manager = manager;
		this.resume = resume;

		JButton nextButton = new JButton("Next");
		nextButton.setBounds(600, 600, 160, 60);
		nextButton.addActionListener(e -> {

		});
		this.add(nextButton);

		name = new JTextField(20);
		name.setBounds(125, 200, 200, 30);
		name.setText("School name");
		this.add(name);

		gradYear = new JTextField(20);
		gradYear.setBounds(125, 300, 200, 30);
		gradYear.setText("Graduation year");
		this.add(gradYear);

		gradMonth = new JTextField(20);
		gradMonth.setBounds(125, 400, 200, 30);
		gradMonth.setText("Graduation month");
		this.add(gradMonth);

		degree = new JTextField(20);
		degree.setBounds(125, 500, 200, 30);
		degree.setText("Degree earned");
		this.add(degree);

		JButton addSchool = new JButton("Add school");
		addSchool.setBounds(165, 550, 110, 30);
		addSchool.addActionListener(e -> {
			resume.addSchool(name.getText(), degree.getText(), gradYear.getText(), gradMonth.getText());
			
			name.setText("School name");
			gradYear.setText("Graduation year");
			gradMonth.setText("Graduation month");
			degree.setText("Degree earned");

			this.repaint();
		});
		this.add(addSchool);

	}

	public void draw(Graphics g) {
		g.setColor(black);

		g.setFont(new Font("Arial", Font.PLAIN, 40));
		g.drawString("Education information", 125, 100);

		g.fillRect(350, 200, 2, 400);

		g.setFont(new Font("Arial", Font.PLAIN, 18));
		this.drawString(g, resume.schoolsToString(), 400, 250);
	}

	private void drawString(Graphics g, String text, int x, int y) {
		for (String line : text.split("\n")) {
			g.drawString(line, x, y);
			y += g.getFontMetrics().getHeight();
		}
	}

}