import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Screen extends JPanel implements ActionListener {
	ArrayList<Employee> employees;

	private Color green = new Color(79, 255, 146);
	private Color white = new Color(255, 255, 255);
	private Color purple = new Color(192, 179, 224);
	private Color lblue = new Color(176, 224, 230);
	private Color blue = new Color(0, 0, 255);
	private Color red = new Color(255, 0, 0);
	private Color black = new Color(0, 0, 0);
	private Color yellow = new Color(244, 236, 8);
	private Color dblue = new Color(30, 144, 255);
	private Color red1 = new Color(242, 106, 117);
	private Color yellow1 = new Color(249, 228, 89);

	public Screen() {
		employees = new ArrayList<Employee>();

		employees.add(new Teacher("Joe Bill", "History Teacher", "joebill", "Mountain View", "Mountain View High School"));


		this.setLayout(null);
		this.setFocusable(true);
	}

	public Dimension getPreferredSize() {
		return new Dimension(800, 800);
	}

	public void paintComponent(Graphics g) {

		employees.get(0).drawPhoto(g, 500, 500);

		super.paintComponent(g);

	}

	public void actionPerformed(ActionEvent e) {

		this.repaint();
	}

}