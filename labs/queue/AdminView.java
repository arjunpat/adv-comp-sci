import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AdminView extends View {

	private Database database;

	public AdminView(Database database) {
		super();
		this.database = database;


	}

	public void draw(Graphics g) {

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400, 400);
	}

}
