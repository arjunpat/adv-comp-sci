import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import resume.Resume;

public class DisplayResumeView extends View {
	
	private ScreenManager manager;
	private Resume resume;

	public DisplayResumeView(ScreenManager manager, Resume resume) {
		super();

		this.manager = manager;
		this.resume = resume;
	}

	public void draw(Graphics g) {

		g.setFont(new Font("Tahoma", Font.PLAIN, 45));
		g.setColor(yellow);
		g.fillRect(0, 64, 30, 42);

		g.setColor(black);
		g.drawString(resume.getName() + ", here is your resume", 45, 100);

		g.fillRect(350, 300, 2, 400);

		g.setFont(new Font("Times", Font.PLAIN, 18));
		this.drawString(g, resume.jobsToString(), 75, 350);
		this.drawString(g, resume.educationToString(), 400, 350);

	}

	private void drawString(Graphics g, String text, int x, int y) {
		for (String line : text.split("\n")) {
			g.drawString(line, x, y);
			y += g.getFontMetrics().getHeight();
		}
	}
}