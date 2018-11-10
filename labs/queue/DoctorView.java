import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.border.Border;
import java.awt.geom.RoundRectangle2D;

public class DoctorView extends View {

	private Database database;
	private Patient patient;

	public DoctorView(Database database) {
		super();
		this.database = database;
		this.database.addChangeListener(this);
		this.patient = database.getTopPatient();

		JTextArea doctorsNoteTextArea = new JTextArea(350, 200);
		doctorsNoteTextArea.setBounds(25, 190, 350, 200);
		doctorsNoteTextArea.setBorder(new RoundBorder(10));
		this.add(doctorsNoteTextArea);

		JButton addDoctorsNote = new JButton("Next");
		addDoctorsNote.setBounds(275, 400, 100, 30);
		addDoctorsNote.addActionListener(e -> {
			this.patient.setDoctorsNote(doctorsNoteTextArea.getText());
			database.doneWithPatient(this.patient);
			this.patient = database.getTopPatient();

			repaint();
			doctorsNoteTextArea.setText("Type note here...");
		});
		this.add(addDoctorsNote);

		doctorsNoteTextArea.setText("Type note here...");

	}

	public void draw(Graphics g) {

		drawTitle(g, blue, "Doctor View", 20, 30);

		g.setFont(new Font("Tahoma", Font.PLAIN, 18));
		g.setColor(black);

		try {
			g.drawString("First name: "  + patient.getFirstName(), 20, 70);
			g.drawString("Last name: "  + patient.getLastName(), 20, 100);
			g.drawString("Priority: "  + patient.getPriorityString(), 20, 130);
			g.drawString("Illness: "  + patient.getIllness(), 20, 160);
		} catch (Exception e) {
			g.drawString("No patients waiting for service.", 20, 70);
		}

	}

	public void onChange() {
		this.patient = database.getTopPatient();
		repaint();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400, 450);
	}

	public class RoundBorder implements Border {

		private int radius;

		public RoundBorder(int radius) {
			this.radius = radius;
		}

		public int getRadius() {
			return radius;
		}

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, getRadius(), getRadius()));
			g2d.dispose();
		}

		@Override
		public Insets getBorderInsets(Component c) {
			int value = getRadius() / 2;
			return new Insets(value, value, value, value);
		}

		@Override
		public boolean isBorderOpaque() {
			return false;
		}

	}
}
