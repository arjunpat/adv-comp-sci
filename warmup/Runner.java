import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Runner extends View {

	private String hi;

	public Runner() {
		super();

		JTextField field = new JTextField(20);
		field.setBounds(20, 20, 200, 30);
		this.add(field);


		JButton undo = new JButton("Undo");
		undo.setBounds(20, 100, 100, 30);
		undo.addActionListener(e -> {
			Stack<String> theStack = new Stack<String>();

			String[] arr = field.getText().split(" ");

			for (int i = 0; i < arr.length; i++) {
				theStack.push(arr[i]);
			}

			System.out.println(theStack);

			theStack.pop();

			String toShow = "";
			while (!theStack.isEmpty()) {
				toShow = theStack.pop() + " " + toShow;
			}

			field.setText(toShow);

		});
		this.add(undo);

	}

	public void draw(Graphics g) {

	}

	public static void main(String[] args) {

		JFrame jFrame = new JFrame("Undo");
		jFrame.add(new Runner());

		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
		
	}
}