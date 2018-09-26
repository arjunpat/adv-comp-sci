import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Screen extends View {

	private Database db = new Database("names.txt");

	private JTextArea studentTextArea = new JTextArea(390, 780);
	//private JTextField searchTextBox;

	public Screen() {
		super();

		/*System.out.println(db);
		System.out.println(db.sequentialSearch("Fellman"));
		System.out.println(db.getPasses());*/

		// text area things
		studentTextArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(studentTextArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(400, 10, 390, 780);
		this.add(scrollPane);
		this.populateStudentTextArea();

		// show all
		JButton showAllButton = new JButton("Show all");
		showAllButton.addActionListener(e -> {
			this.populateStudentTextArea();
		});
		showAllButton.setBounds(20, 40, 140, 50);
		this.add(showAllButton);

		// randomize button
		JButton randomizeButton = new JButton("Scramble");
		randomizeButton.addActionListener(e -> {
			db.scramble();
			this.populateStudentTextArea();
		});
		randomizeButton.setBounds(20, 100, 140, 50);
		this.add(randomizeButton);

		// Search
		final JTextField searchTextBox = new JTextField(20);
		searchTextBox.setBounds(20, 230, 200, 30);
		this.add(searchTextBox);

		JButton binarySearchButton = new JButton("Binary search");
		binarySearchButton.setBounds(20, 280, 140, 30);
		binarySearchButton.addActionListener(e -> {
			int res = db.binarySearch(searchTextBox.getText());
			searchTextBox.setText("");

			if (res > -1) {
				studentTextArea.setText((res + 1) + ". " + db.getStudent(res).toString() + "\nPasses: " + db.getPasses());
			} else {
				studentTextArea.setText("Oof! No results found.");
			}

		});
		this.add(binarySearchButton);

	}

	public void draw(Graphics g) {
		
		g.setColor(black);
		g.setFont(new Font("Tahoma", Font.PLAIN, 24));
		g.drawString("Search by Last Name", 20, 200);

	}

	public void populateStudentTextArea() {
		studentTextArea.setText(db.toString());
	}
}