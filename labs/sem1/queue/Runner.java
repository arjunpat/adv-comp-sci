import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class Runner {

	private JFrame main;
	private Database database;

	public Runner() {
		this.main = new JFrame("Main View");
		this.database = new Database();

		this.packView(main, new MainView(this, database));

	}

	private void packView(JFrame frame, View view) {
		frame.setContentPane(view);
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	public void openAdminWindow() {
		this.packView(new JFrame("Admin View"), new AdminView(database));
	}

	public void openBillerWindow() {
		this.packView(new JFrame("Biller View"), new BillerView(database));
	}

	public void openDoctorWindow() {
		this.packView(new JFrame("Doctor View"), new DoctorView(database));
	}

	public void openNurseWindow() {
		this.packView(new JFrame("Nurse View"), new NurseView(database));
	}

	public static void main(String[] args) {

		new Runner();

	}
}