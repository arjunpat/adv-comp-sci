import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.*;


public class Client extends View {

	private JTextArea chatTextArea = new JTextArea(400, 400);
	private Socket conn;
	private BufferedReader in;
	private PrintWriter out;

	public Client() {

		this.chatTextArea.setEditable(false);
		JScrollPane chatScrollPane = new JScrollPane(chatTextArea);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setBounds(20, 20, 400, 400);
		this.add(chatScrollPane);

		JTextField typeHere = new JTextField(20);
		typeHere.setBounds(20, 440, 200, 30);
		typeHere.addActionListener(e -> {
			out.println(typeHere.getText());
			addToChatArea("Me", typeHere.getText());
			typeHere.setText("");
		});
		this.add(typeHere);

	}

	public void draw(Graphics g) {

	}


	public void poll() throws Exception {
		conn = new Socket("localhost", 8080);

		in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		out = new PrintWriter(conn.getOutputStream(), true);

		while (true) {
			String entry = in.readLine();
			addToChatArea("Them", entry);
		}
	}

	private void addToChatArea(String from, String message) {
		chatTextArea.setText(chatTextArea.getText() + "\n" + from + ": " + message);
	}

	public static void main(String[] args) throws Exception {

		JFrame frame = new JFrame("Client");
		Client client = new Client();

		frame.add(client);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		client.poll();
	}

}