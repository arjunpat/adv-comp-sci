import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Screen extends View {

	boolean works = false;

	public Screen() {

		JTextField enterInHere = new JTextField(20);
		enterInHere.setBounds(10, 30, 200, 30);
		this.add(enterInHere);

		JButton clickMe = new JButton("Click to validate");
		clickMe.setBounds(10, 100, 200, 30);
		clickMe.addActionListener(e -> {
			works = isCorrect(enterInHere.getText());

			this.repaint();
		});
		this.add(clickMe);


	}

	public void draw(Graphics g) {
		if (works) {
			drawTitle(g, red, "It works!", 10, 160);
		} else {
			drawTitle(g, red, "It doesn't work", 10, 160);
		}
	}

	public boolean isCorrect(String str) {
		char[] openingSymbols = {'{','(','<','['};
		char[] closingSymbols = {'}',')','>',']'};

		Stack<Character> theStack = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (isInArr(ch, openingSymbols)) {
				theStack.push(ch);
			} else if (isInArr(ch, closingSymbols)) {

				if (theStack.size() == 0) {
					return false;
				}

				char top = theStack.pop();

				if (top == '{' && ch != '}') {
					return false;
				} else if (top == '(' && ch != ')') {
					return false;
				} else if (top == '<' && ch != '>') {
					return false;
				} else if (top == '[' && ch != ']') {
					return false;
				}

			}

		}

		return theStack.size() == 0;

	}

	public boolean isInArr(char str, char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (str == arr[i]) {
				return true;
			}
		}

		return false;
	}
}