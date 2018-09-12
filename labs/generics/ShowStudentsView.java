import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ShowStudentsView extends View {

	private ScreenManager screenManager;
	private ArrayList<Pair<Student, Schedule>> students;

	public ShowStudentsView(ScreenManager screenManager, ArrayList<Pair<Student, Schedule>> students) {
		this.screenManager = screenManager;
		this.students = students;
	}

	public void draw(Graphics g) {


		int theX = 40;
		int theY = 100;
		int theI = 0;


		g.setFont(new Font("Arial", Font.PLAIN, 20));
		g.setColor(black);
		while (theY < 500 && theI < students.size()) {
			while (theX < 800 && theI < students.size()) {
				students.get(theI).getKey().drawStudent(g, theX, theY, 200, 200);
				g.drawString(students.get(theI).getKey().getName(), theX, theY + 220);
				theX += 200;
				theI++;
			}
			theX = 40;
			theY += 140;
		}
	}

}