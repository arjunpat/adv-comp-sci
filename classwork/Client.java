import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {

		Socket serverSocket = new Socket("localhost", 8080);
		BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
		PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
		Scanner kb = new Scanner(System.in);

		System.out.println("What is your name?");
		String name = kb.nextLine();


		Thread reader = new Thread(new Runnable() {
			public void run() {
				out.println(name + " has joined the chat");
				while (true) {
					String line = kb.nextLine();

					if (line.equals("bye")) {
						out.println(name + " has left the chat");
						out.flush();
						out.close();
						System.exit(1);
					} else {
						out.println(name + ": " + line);
					}
				}
			}
		});

		reader.start();

		try {
			while (true) {
				String fromServer = in.readLine();

				if (fromServer.indexOf(name) != 0)
					System.out.println(fromServer);
			}

			
		} catch (Exception e) {}
	}
}
