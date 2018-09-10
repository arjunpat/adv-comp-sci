import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Screen extends JPanel implements ActionListener, KeyListener {
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

	private JButton showTeachersButton = new JButton("Show teachers");
	private JButton showPoliceOfficersButton = new JButton("Show police officers");
	private JButton showEngineersButton = new JButton("Show engineers");
	private JButton showBankersButton = new JButton("Show bankers");
	private JButton showAllButton = new JButton("Show all");
	private JButton searchNameButton = new JButton("Search for name");

	private JTextField searchTextField = new JTextField(20);

	private int viewingProfile = -1;
	private String showOnly = "";

	public Screen() {
		this.addKeyListener(this);

		employees = new ArrayList<Employee>();
		employees.add(new Teacher("Joe Bill", "History Teacher", "joebill", "Mountain View", "Mountain View High School"));
		employees.add(new Teacher("Bill Nye", "Science Teacher", "billnye", "Mountain View", "Mountain View High School"));

		employees.add(new PoliceOfficer("Ryan Lastname", "Highway Patrol", "ryanlastname", "Mountain View", "High"));
		employees.add(new PoliceOfficer("Tanay Sonthalia", "Downtown Control", "tanaysonthalia", "Mountain View", "Low"));

		employees.add(new Engineer("Arvind Patel", "Lead Engineer", "arvindpatel", "IBM", "Electrical"));
		employees.add(new Engineer("Svasti Patel", "Project Engineer", "svastipatel", "Arco", "Chemical"));

		employees.add(new Banker("Low Life", "Banker", "lowlife", "Wells Fargo", "Investment"));
		employees.add(new Banker("Mercy Feathers", "Lead Banker", "mercyfeathers", "Goldman Sachs", "Angel Investor"));


		showTeachersButton.setBounds(20, 20, 160, 60);
		showTeachersButton.addActionListener(this);
		this.add(showTeachersButton);
		showPoliceOfficersButton.setBounds(220, 20, 160, 60);
		showPoliceOfficersButton.addActionListener(this);
		this.add(showPoliceOfficersButton);
		showEngineersButton.setBounds(420, 20, 160, 60);
		showEngineersButton.addActionListener(this);
		this.add(showEngineersButton);
		showBankersButton.setBounds(620, 20, 160, 60);
		showBankersButton.addActionListener(this);
		this.add(showBankersButton);
		showAllButton.setBounds(620, 100, 160, 60);
		showAllButton.addActionListener(this);
		this.add(showAllButton);
		searchNameButton.setBounds(100, 500, 160, 60);
		searchNameButton.addActionListener(this);
		this.add(searchNameButton);

		searchTextField.setBounds(100, 450, 200, 30);
		this.add(searchTextField);

		this.setLayout(null);
		this.setFocusable(true);
	}

	public Dimension getPreferredSize() {
		return new Dimension(800, 800);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(white);
		g.fillRect(0, 0, 800, 800);

		int theX = 40;
		int theY = 100;
		int theI = 0;

		if (showOnly.equals("")) {
			while (theY < 500 && theI < employees.size()) {
				while (theX < 500 && theI < employees.size()) {
					employees.get(theI).drawPhoto(g, theX, theY, 100, 100);
					theX += 140;
					theI++;
				}
				theX = 40;
				theY += 140;
			}
		} else {
			while (theY < 500 && theI < employees.size()) {
				while (theX < 500 && theI < employees.size()) {
					if (employees.get(theI).getClass().getName().equals(showOnly)) {
						employees.get(theI).drawPhoto(g, theX, theY, 100, 100);
						theX += 140;
					}
					theI++;
				}
				theX = 40;
				theY += 140;
			}
		}

		g.setFont(new Font("Arial", Font.PLAIN, 30));
		g.drawString("Search for a person", 600, 600);

		if (viewingProfile > -1)
			this.paintEmployee(g, viewingProfile);
	}

	public void paintEmployee(Graphics g, int num) {
		Employee emp = employees.get(num);

		g.setColor(lblue);
		g.fillRect(50, 100, 700, 600);

		emp.drawPhoto(g, 65, 220, 200, 200);

		g.setColor(black);

		g.setFont(new Font("Arial", Font.BOLD, 50));
		this.drawString(g, emp.getName(), 65, 150);

		g.setFont(new Font("Arial", Font.PLAIN, 20));
		this.drawString(g, emp.getJobTitle(), 65, 190);

		g.setFont(new Font("Arial", Font.PLAIN, 15));
		this.drawString(g, emp.toString(), 65, 550);
		this.drawString(g, "Press esc to leave", 65, 600);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == showTeachersButton) {
			showOnly = "Teacher";
		} else if (e.getSource() == showPoliceOfficersButton) {
			showOnly = "PoliceOfficer";
		} else if (e.getSource() == showEngineersButton) {
			showOnly = "Engineer";
		} else if (e.getSource() == showBankersButton) {
			showOnly = "Banker";
		} else if (e.getSource() == showAllButton) {
			showOnly = "";
		} else if (e.getSource() == searchNameButton) {
			for (int i = 0; i < employees.size(); i++) {
				if (employees.get(i).getName().equals(searchTextField.getText())) {
					System.out.println(i);
					viewingProfile = i;
					this.remove(showTeachersButton);
					this.remove(showPoliceOfficersButton);
					this.remove(showEngineersButton);
					this.remove(showBankersButton);
					this.remove(showAllButton);
					this.remove(searchNameButton);
					this.remove(searchTextField);
				}
			}
		}

		this.repaint();
	}

	private void drawString(Graphics g, String text, int x, int y) {
		for (String line : text.split("\n")) {
			g.drawString(line, x, y);
			y += g.getFontMetrics().getHeight();
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 27) {
			viewingProfile = -1;
			this.add(showTeachersButton);
			this.add(showPoliceOfficersButton);
			this.add(showEngineersButton);
			this.add(showBankersButton);
			this.add(showAllButton);
			this.add(searchNameButton);
			this.add(searchTextField);
		}

		this.repaint();
	}

}