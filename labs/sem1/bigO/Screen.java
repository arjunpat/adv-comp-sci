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
				studentTextArea.setText((res + 1) + ". " + db.getStudent(res).toString());
			} else {
				studentTextArea.setText("Oof! No results found.");
			}

			this.repaint();

		});
		this.add(binarySearchButton);

		JButton sequentialSearchButton = new JButton("Sequential search");
		sequentialSearchButton.setBounds(180, 280, 140, 30);
		sequentialSearchButton.addActionListener(e -> {
			int res = db.sequentialSearch(searchTextBox.getText());
			searchTextBox.setText("");

			if (res > -1) {
				studentTextArea.setText((res + 1) + ". " + db.getStudent(res).toString());
			} else {
				studentTextArea.setText("Oof! No results found.");
			}

			this.repaint();
		});
		this.add(sequentialSearchButton);


		// challenge things - randomization/sorting
		JButton randomizeButton = new JButton("Scramble");
		randomizeButton.addActionListener(e -> {
			db.scramble();
			this.populateStudentTextArea();

			this.repaint();
		});
		randomizeButton.setBounds(20, 400, 140, 50);
		this.add(randomizeButton);

		JButton bubbleSortButton = new JButton("Bubble sort");
		bubbleSortButton.addActionListener(e -> {
			db.bubbleSort();
			this.populateStudentTextArea();

			this.repaint();
		});
		bubbleSortButton.setBounds(20, 480, 140, 50);
		this.add(bubbleSortButton);

		JButton mergeSortButton = new JButton("Merge sort");
		mergeSortButton.addActionListener(e -> {
			db.mergeSort();
			this.populateStudentTextArea();
			this.repaint();
		});
		mergeSortButton.setBounds(20, 530, 140, 50);
		this.add(mergeSortButton);

	}

	public void draw(Graphics g) {
		
		g.setColor(black);
		g.setFont(new Font("Tahoma", Font.PLAIN, 24));
		g.drawString("Search by Last Name", 20, 200);
		g.drawString("Sort", 20, 380);

		if (db.getPasses() != 0) {
			g.setFont(new Font("Tahoma", Font.PLAIN, 18));
			g.drawString("Passes: " + db.getPasses(), 20, 120);
		}

	}

	public void populateStudentTextArea() {
		studentTextArea.setText(db.toString());
	}
}