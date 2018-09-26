import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Screen extends View {

	Database db = new Database("names.txt");

	private JTextArea studentTextArea = new JTextArea(390, 780);

	public Screen() {
		super();

		/*System.out.println(db);
		System.out.println(db.sequentialSearch("Fellman"));
		System.out.println(db.getPasses());*/


		studentTextArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(studentTextArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(400, 10, 390, 780);
		this.add(scrollPane);

		this.populateStudentTextArea();

	}

	public void draw(Graphics g) {

	}


	public void populateStudentTextArea() {
		studentTextArea.setText(db.toString());
	}
}