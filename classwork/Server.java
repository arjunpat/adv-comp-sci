import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.*;


public class Server extends View {

	private JTextArea chatTextArea = new JTextArea(400, 400);
	private ServerSocket app;
	private Socket client;
	private BufferedReader in;
	private PrintWriter out;

	public Server() {

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

		app = new ServerSocket(8080);
		client = app.accept();

		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		out = new PrintWriter(client.getOutputStream(), true);

		while (true) {
			String entry = in.readLine();

			addToChatArea("Them", entry);
		}

	}

	private void addToChatArea(String from, String message) {
		chatTextArea.setText(chatTextArea.getText() + "\n" + from + ": " + message);
	}

	public static void main(String[] args) throws Exception {

		JFrame frame = new JFrame("Server");
		Server server = new Server();

		frame.add(server);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		server.poll();
	}

}