import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import atoolkit.*;

public class Example extends View {

	private String hi;

	public Example() {
		super();

		setVerticalComponentSpacing(4);
		
		ATextField field = new ATextField();
		addToLeft(field);

		JTextField field2 = new JTextField(20);
		addToLeft(field2);

		ATextField field3 = new ATextField();
		addToRight(field3);

		addSpaceToLeft(400);


		AButton undo = new AButton("Undo");
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
		addToLeft(undo);

	}

	public void draw(Graphics g) {

	}

	public static void main(String[] args) {

		JFrame jFrame = new JFrame("Undo");
		jFrame.add(new Example());

		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
		
	}
}
