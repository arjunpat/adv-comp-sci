import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class StudentView extends View {

	private ScreenManager screenManager;
	private Pair<Student, Schedule> student;
	private JButton backButton = new JButton("Back");
	private JButton addClass = new JButton("Add");
	private JButton deletePeriodButton = new JButton("Delete period");


	private JTextField name = new JTextField(20);
	private JTextField period = new JTextField(20);
	private JTextField deletePeriod = new JTextField(20);

	public StudentView(ScreenManager screenManager, Pair<Student, Schedule> student) {

		this.screenManager = screenManager;
		this.student = student;

		backButton.setBounds(20, 30, 100, 30);
		backButton.addActionListener(e -> {
			screenManager.showAllStudents();
		});
		this.add(backButton);

		name.setBounds(400, 550, 200, 30);
		name.setText("Name");
		this.add(name);

		period.setText("Period number");
		period.setBounds(125, 550, 200, 30);
		this.add(period);

		deletePeriod.setText("Period number to delete");
		deletePeriod.setBounds(125, 650, 200, 30);
		this.add(deletePeriod);

		deletePeriodButton.setBounds(400, 650, 150, 30);
		deletePeriodButton.addActionListener(e -> {
			student.getValue().deletePeriod(Integer.parseInt(deletePeriod.getText()));
			deletePeriod.setText("");
			this.repaint();
		});
		this.add(deletePeriodButton);

		addClass.setBounds(625, 550, 75, 30);
		addClass.addActionListener(e -> {
			student.getValue().addClass(
				Integer.parseInt(period.getText()),
				name.getText()
			);
			period.setText("");
			name.setText("");
			this.repaint();
		});
		this.add(addClass);
	}

	public void draw(Graphics g) {
		g.setColor(black);

		student.getKey().drawStudent(g, 125, 150, 150, 150);

		g.setFont(new Font("Arial", Font.PLAIN, 50));
		g.drawString(student.getKey().getName() + "'s Classes", 125, 125);

		g.setFont(new Font("Arial", Font.PLAIN, 20));
		this.drawString(g, student.getValue().toString(), 125, 400);
 
		g.fillRect(50, 610, 700, 1);
	}

	private void drawString(Graphics g, String text, int x, int y) {
		for (String line : text.split("\n")) {
			g.drawString(line, x, y);
			y += g.getFontMetrics().getHeight();
		}
	}
}