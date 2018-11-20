import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class Client extends View {

	public Client() {

	}

	public void draw(Graphics g) {

	}

	public void poll() {
		
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Client");
		Client client = new Client();

		frame.add(client);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		client.poll();
	}
}