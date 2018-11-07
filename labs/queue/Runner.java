import javax.swing.JFrame;
import views.*;

public class Runner {

	private JFrame nurseView, doctorView, billerView, adminView;

	public Runner() {
		nurseView = new JFrame("Nurse View");
		doctorView = new JFrame("Doctor View");
		billerView = new JFrame("Biller View");
		adminView = new JFrame("Admin View");

		this.packView(nurseView, new NurseView());
		this.packView(doctorView, new DoctorView());
		this.packView(billerView, new BillerView());
		this.packView(adminView, new AdminView());
	}

	private void packView(JFrame frame, View view) {
		frame.setContentPane(view);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		new Runner();

	}
}