import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ServerView extends View {
	private Database db;

	public ServerView(Database db) {
		this.db = db;
	}

	public void draw(Graphics g) {
		
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(200, 400);
	}

	public void onChange() {

	}
}