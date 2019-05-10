import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Scanner;

public class Client extends View {
	public Client() throws Exception {
		setBackground(new Color(255, 255, 255));

		Socket serverSocket = new Socket("10.210.18.235", 8080);
		BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
		PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
		JTextArea accountsTextArea = new JTextArea(390, 350);
		JTextField theName = new JTextField();
		theName.setText("");

		accountsTextArea.setText("Type your name below and press enter");

		accountsTextArea.setEditable(false);
		JScrollPane accountsScrollPane = new JScrollPane(accountsTextArea);
		accountsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		accountsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		accountsScrollPane.setBounds(20, 50, 390, 350);
		add(accountsScrollPane);

		new Thread(new Runnable() {
			public void run() {

				try {
					while (true) {
						String fromServer = in.readLine();

						if (fromServer.indexOf(theName.getText()) != 0)
							accountsTextArea.setText(accountsTextArea.getText() + "\n" + fromServer);
					}

				} catch (Exception e) {}
			}
		}).start();

		JTextField enterText = new JTextField();
		enterText.setBounds(20, 600, 300, 50);
		enterText.addActionListener(e -> {
			String line = enterText.getText();

			if (theName.getText().equals("")) {
				theName.setText(line);
				out.println(theName.getText() + " has joined the chat");
				accountsTextArea.setText(accountsTextArea.getText() + "\n" + theName.getText() + " has joined the chat");
			} else {
				if (line.equals("bye")) {
					out.println(theName.getText() + " has left the chat");
					out.flush();
					out.close();
					System.exit(1);
				} else {
					out.println(theName.getText() + ": " + line);
					accountsTextArea.setText(accountsTextArea.getText() + "\n" + line);
				}
			}

			enterText.setText("");
		});
		add(enterText);
	}

	public void draw(Graphics g) {
		drawBigTitle(g, Color.RED, "Chat", 20, 30);
	}

	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("Scenery Grid");

		frame.add(new Client());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
