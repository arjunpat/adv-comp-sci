import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DoctorView extends View {

	private Database database;
	private Patient patient;

	public DoctorView(Database database) {
		super();
		this.database = database;
		this.patient = database.getTopPatient();

		JButton addDoctorsNote = new JButton("Add doctor's note");
		this.add(addDoctorsNote);

	}

	public void draw(Graphics g) {

		drawTitle(g, blue, "Doctor View", 20, 30);

		g.setFont(new Font("Tahoma", Font.PLAIN, 18));
		g.setColor(black);
		g.drawString("First name: "  + patient.getFirstName(), 20, 70);
		g.drawString("Last name: "  + patient.getLastName(), 20, 100);
		g.drawString("Priority: "  + patient.getPriorityString(), 20, 130);
		g.drawString("Illness: "  + patient.getIllness(), 20, 160);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400, 400);
	}
}
