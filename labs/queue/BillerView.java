import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BillerView extends View {

	private Database database;
	private Patient patient;

	public BillerView(Database database) {
		super();
		this.database = database;
		this.patient = database.getPatientToBill();

		JTextField cost = new JTextField(20);
		cost.setBounds(30, 300, 200, 30);
		this.add(cost);

		JButton next = new JButton("Next");
		next.setBounds(275, 350, 100, 30);
		next.addActionListener(e -> {
			double theCost = Double.parseDouble(cost.getText());
			patient.setCost(theCost);
			database.removePatientFromBilling(patient);

			this.patient = database.getPatientToBill();
			repaint();
			cost.setText("");
		});
		this.add(next);

	}

	public void draw(Graphics g) {
		drawTitle(g, blue, "Biller View", 20, 30);

		g.setFont(new Font("Tahoma", Font.PLAIN, 18));
		g.setColor(black);
		g.drawString("First name: "  + patient.getFirstName(), 20, 70);
		g.drawString("Last name: "  + patient.getLastName(), 20, 100);
		g.drawString("Priority: "  + patient.getPriorityString(), 20, 130);
		g.drawString("Illness: "  + patient.getIllness(), 20, 160);
		g.drawString("Doctor's note: " + patient.getDoctorsNote(), 20, 190);

		g.drawString("Enter cost below", 20, 300);
		g.drawString("$", 20, 320);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400, 400);
	}

}
