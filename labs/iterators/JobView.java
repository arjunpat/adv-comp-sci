import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import resume.Resume;

public class JobView extends View {

	private ScreenManager manager;
	private Resume resume;

	private JTextField jobTitle, endYear, endMonth, company;

	private JButton[] deleteButtons = new JButton[0];

	public JobView(ScreenManager manager, Resume resume) {
		super();

		this.manager = manager;
		this.resume = resume;

		JButton nextButton = new JButton("Next");
		nextButton.setBounds(600, 700, 160, 60);
		nextButton.addActionListener(e -> {

		});
		this.add(nextButton);

		jobTitle = new JTextField(20);
		jobTitle.setBounds(125, 200, 200, 30);
		jobTitle.setText("Job title");
		this.add(jobTitle);

		endYear = new JTextField(20);
		endYear.setBounds(125, 300, 200, 30);
		endYear.setText("Job end year");
		this.add(endYear);

		endMonth = new JTextField(20);
		endMonth.setBounds(125, 400, 200, 30);
		endMonth.setText("Job end month");
		this.add(endMonth);

		company = new JTextField(20);
		company.setBounds(125, 500, 200, 30);
		company.setText("Company");
		this.add(company);

		JButton addJob = new JButton("Add job");
		addJob.setBounds(165, 550, 110, 30);
		addJob.addActionListener(e -> {
			resume.addJob(jobTitle.getText(), company.getText(), endYear.getText(), endMonth.getText());
			
			jobTitle.setText("Job title");
			endYear.setText("Job end year");
			endMonth.setText("Job end month");
			company.setText("Company");

			this.repaint();
		});
		this.add(addJob);

	}

	public void draw(Graphics g) {
		g.setColor(black);

		g.setFont(new Font("Arial", Font.PLAIN, 40));
		g.drawString(resume.getName() + ", add your work", 125, 100);

		g.fillRect(350, 200, 2, 400);

		g.setFont(new Font("Arial", Font.PLAIN, 18));
		this.drawString(g, resume.jobsToString(), 400, 250);


		if (deleteButtons.length != resume.getNumOfJobs()) {
			for (int i = 0; i < deleteButtons.length; i++) {
				this.remove(deleteButtons[i]);
			}
			deleteButtons = new JButton[resume.getNumOfJobs()];

			for (int i = 0; i < deleteButtons.length; i++) {
				deleteButtons[i] = new JButton("X");
				deleteButtons[i].setBounds(355, 250 + (88 * i), 40, 30);
				final int theI = i;
				deleteButtons[i].addActionListener(e -> {
					resume.removeJob(theI);
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