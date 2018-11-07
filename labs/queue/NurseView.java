import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class NurseView extends View {

	private Database database;
	private JTextArea patientTextArea = new JTextArea(400, 400);

	public NurseView(Database database) {
		super();
		this.database = database;

		this.patientTextArea.setEditable(false);
		JScrollPane patientScrollPane = new JScrollPane(patientTextArea);
		patientScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		patientScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		patientScrollPane.setBounds(0, 0, 400, 400);
		this.add(patientScrollPane);

		JTextField firstName = new JTextField(20);
		firstName.setBounds(420, 100, 200, 30);
		this.add(firstName);

		JTextField lastName = new JTextField(20);
		lastName.setBounds(420, 175, 200, 30);
		this.add(lastName);

		JTextField illness = new JTextField(20);
		illness.setBounds(420, 250, 200, 30);
		this.add(illness);

		JTextField priority = new JTextField(20);
		priority.setBounds(420, 325, 200, 30);
		this.add(priority);

		JButton addPatient = new JButton("Add patient");
		addPatient.setBounds(420, 375, 150, 30);
		addPatient.addActionListener(e -> {
			database.addPatient(firstName.getText(), lastName.getText(), illness.getText(), priority.getText());

			priority.setText("Priority");
			illness.setText("Illness");
			lastName.setText("Last name");
			firstName.setText("First name");
			this.populatePatientTextArea();
		});
		this.add(addPatient);

		JButton updatePatient = new JButton("Update patient");
		updatePatient.setBounds(600, 375, 150, 30);
		updatePatient.addActionListener(e -> {
			database.updatePatient();

		});
		this.add(updatePatient);

		priority.setText("Priority");
		illness.setText("Illness");
		lastName.setText("Last name");
		firstName.setText("First name");
		this.populatePatientTextArea();
	}

	public void draw(Graphics g) {

		drawTitle(g, blue, "Add/update a patient", 420, 30);

	}

	private void populatePatientTextArea() {
		this.patientTextArea.setText(database.getAllPatients());
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800, 400);
	}

}
