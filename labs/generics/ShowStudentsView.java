import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ShowStudentsView extends View {

	private ScreenManager screenManager;
	private ArrayList<Pair<Student, Schedule>> students;
	private JButton[] buttons;
	private boolean firstPaint = true;

	private JTextField nameTextField = new JTextField(20);
	private JButton search = new JButton("Search");

	public ShowStudentsView(ScreenManager screenManager, ArrayList<Pair<Student, Schedule>> students) {
		this.screenManager = screenManager;
		this.students = students;
		this.buttons = new JButton[students.size()];

		nameTextField.setBounds(300, 500, 200, 30);
		this.add(nameTextField);

		search.setBounds(300, 550, 160, 60);
		search.addActionListener(e -> {
			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getKey().getName().equals(nameTextField.getText())) {
					screenManager.showStudent(i);
					nameTextField.setText("");
					break;
				}
			}

			nameTextField.setText("");
		});
		this.add(search);

		//getComponents();
	}

	public void draw(Graphics g) {


		int theX = 40;
		int theY = 100;
		int theI = 0;


		g.setFont(new Font("Arial", Font.PLAIN, 20));
		g.setColor(black);

		g.drawString("Search a name", 300, 450);

		while (theY < 500 && theI < students.size()) {
			while (theX < 800 && theI < students.size()) {
				students.get(theI).getKey().drawStudent(g, theX, theY, 200, 200);
				g.drawString(students.get(theI).getKey().getName(), theX, theY + 225);

				if (firstPaint) {
					this.buttons[theI] = new JButton("See classes");
					
					final int theIToGoTo = theI;
					this.buttons[theI].addActionListener(e -> {
						screenManager.showStudent(theIToGoTo);
					});

					this.buttons[theI].setBounds(theX + 20, theY + 250, 120, 40);

					this.add(this.buttons[theI]);
				}

				theX += 200;
				theI++;
			}
			theX = 40;
			theY += 140;
		}

		firstPaint = false;
	}

}