import resume.Resume;
import javax.swing.*;
import java.util.*;

public class ScreenManager {

	private JFrame jFrame;
	private Resume resume;

	public ScreenManager(JFrame jFrame) {
		this.jFrame = jFrame;

		resume = new Resume();
		this.showBasicInformationView();
	}

	private void updateScreen(View view) {
		jFrame.setContentPane(view);
		jFrame.pack();
		jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jFrame.setVisible(true);
	}

	public void showBasicInformationView() {
		this.updateScreen(new BasicInformationView(this, resume));
	}

	public void showEducationView() {
		this.updateScreen(new EducationView(this, resume));
	}

}