import javax.swing.*;
import java.util.*;

public class ScreenManager {

	private JFrame jFrame;
	private Database db;

	public ScreenManager(JFrame jFrame) {
		this.jFrame = jFrame;
		this.db = new Database("storeB.txt");

		this.showMainView();
	}

	private void updateScreen(View view) {
		jFrame.setContentPane(view);
		jFrame.pack();
		jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jFrame.setVisible(true);
	}

	public void showMainView() {
		this.updateScreen(new MainView(this, this.db));
	}
}