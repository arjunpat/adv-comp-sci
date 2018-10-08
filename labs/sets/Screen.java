import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Screen extends View {
	private JTextArea itemTextArea = new JTextArea(390, 780);
	private Database db = new Database("StoreA.txt");

	public Screen() {
		
		this.itemTextArea.setEditable(false);
		JScrollPane itemScrollPane = new JScrollPane(itemTextArea);
		itemScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		itemScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		itemScrollPane.setBounds(400, 10, 390, 780);
		this.add(itemScrollPane);
		this.populateItems();


	}

	private void populateItems() {
		this.itemTextArea.setText(db.getAllItems());
	}

	public void draw(Graphics g) {



	}
}