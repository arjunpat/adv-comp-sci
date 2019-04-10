import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Runner {
	private JFrame main;
	private Database db;

	public Runner() {
		this.main = new JFrame("Main View");
		this.db = new Database();
		this.packView(main, new MainView(this, db));
	}

	private void packView(JFrame frame, View view) {
		frame.setContentPane(view);
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	public void openChefWindow() {
		JFrame j = new JFrame("Chef Window");
		this.packView(j, new ChefView(db, j));
	}

	public void openServerWindow() {
		JFrame j = new JFrame("Server Window");
		this.packView(j, new ServerView(db, j));
	}

	public static void main(String[] args) {
		new Runner();
	}
}