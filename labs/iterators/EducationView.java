import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import resume.Resume;

public class EducationView extends View {

	private ScreenManager manager;
	private Resume resume;

	private JTextField name, gradYear, gradMonth, degree;

	private JButton[] deleteButtons = new JButton[0];

	public EducationView(ScreenManager manager, Resume resume) {
		super();

		this.manager = manager;
		this.resume = resume;

		JButton nextButton = new JButton("Next");
		nextButton.setBounds(600, 700, 160, 60);
		nextButton.addActionListener(e -> {
			manager.showJobView();
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
			resume.addEducation(name.getText(), degree.getText(), gradYear.getText(), gradMonth.getText());
			
			name.setText("School name");
			gradYear.setText("Graduation year");
			gradMonth.setText("Graduation month");
			degree.setText("Degree earned");

			this.repaint();
		});
		this.add(addSchool);

	}

	public void draw(Graphics g) {

		g.setFont(new Font("Tahoma", Font.PLAIN, 45));
		g.setColor(yellow);
		g.fillRect(0, 64, 30, 42);

		g.setColor(black);
		g.drawString(resume.getName() + ", add your education", 45, 100);

		g.fillRect(350, 200, 2, 400);

		g.setFont(new Font("Arial", Font.PLAIN, 18));
		this.drawString(g, resume.educationToString(), 400, 250);


		if (deleteButtons.length != resume.getNumOfSchools()) {
			for (int i = 0; i < deleteButtons.length; i++) {
				this.remove(deleteButtons[i]);
			}
			deleteButtons = new JButton[resume.getNumOfSchools()];

			for (int i = 0; i < deleteButtons.length; i++) {
				deleteButtons[i] = new JButton("X");
				deleteButtons[i].setBounds(355, 250 + (88 * i), 40, 30);
				final int theI = i;
				deleteButtons[i].addActionListener(e -> {
					resume.removeSchool(theI);
					this.repaint();
				});
				this.add(deleteButtons[i]);
			}
		}
	}

	private void drawString(Graphics g, String text, int x, int y) {
		for (String line : text.split("\n")) {
			g.drawString(line, x, y);
			y += g.getFontMetrics().getHeight();
		}
	}

}