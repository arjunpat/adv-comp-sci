import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AdminView extends View {

	private Database database;
	private JTextArea patientTextArea = new JTextArea(600, 350);

	public AdminView(Database database) {
		super();
		this.database = database;
		this.database.addChangeListener(this);

		patientTextArea.setEditable(false);
		JScrollPane patientScrollPane = new JScrollPane(patientTextArea);
		patientScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		patientScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		patientScrollPane.setBounds(0, 50, 600, 350);
		this.add(patientScrollPane);

		this.populateTextView();


	}

	public void draw(Graphics g) {
		drawTitle(g, blue, "Admin View", 20, 30);
	}

	public void onChange() {
		this.populateTextView();
	}

	public void populateTextView() {
		patientTextArea.setText(database.getCompletedPatients());
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(600, 400);
	}

}
