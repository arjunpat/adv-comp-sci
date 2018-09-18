import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class StudentView extends View {

	private ScreenManager screenManager;
	private Pair<Student, Schedule> student;
	private JButton backButton = new JButton("Back");

	public StudentView(ScreenManager screenManager, Pair<Student, Schedule> student) {

		this.screenManager = screenManager;
		this.student = student;

		backButton.setBounds(20, 30, 100, 30);
		backButton.addActionListener(e -> {
			screenManager.showAllStudents();
		});
		this.add(backButton);

	}

	public void draw(Graphics g) {
		g.setColor(black);

		g.setFont(new Font("Arial", Font.PLAIN, 50));
		g.drawString(student.getKey().getName() + "'s Classes", 125, 125);

		g.setFont(new Font("Arial", Font.PLAIN, 20));
		Schedule schedule = student.getValue();
		this.drawString(g, schedule.toString(), 125, 300);
	}

	private void drawString(Graphics g, String text, int x, int y) {
		for (String line : text.split("\n")) {
			g.drawString(line, x, y);
			y += g.getFontMetrics().getHeight();
		}
	}
}