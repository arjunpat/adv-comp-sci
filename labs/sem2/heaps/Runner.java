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
		this.packView(new JFrame("Chef Window"), new ChefView(db));
	}

	public void openServerWindow() {
		this.packView(new JFrame("Server Window"), new ServerView(db));
	}

	public static void main(String[] args) {
		new Runner();
	}
}