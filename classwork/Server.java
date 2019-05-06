import java.io.*;
import java.net.*;
import java.util.ArrayList;

import java.util.Collections;

public class Server {
	public static void main(String[] args) throws IOException {
		new Server();
	}

	public Server() throws IOException {
		ServerSocket serverSocket = new ServerSocket(8080);

		while (true) {
			Socket clientSocket = serverSocket.accept();

			Thread thread = new Thread(new Runnable() {
				public void run() {
					try {
						ArrayList<Places> list = new ArrayList<Places>();

						list.add(new Places("Where is Ha Long Bay?", "Vietnam"));
						list.add(new Places("Where is Yosemite National Park?", "California"));
						list.add(new Places("Where is Yellowstone National Park?", "Wyoming"));

						Collections.shuffle(list);

						PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
						BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

						for (int i = 0; i < list.size(); i++) {
							Places p = list.get(i);

							out.println(p.question);
							String answer = in.readLine();

							while (!answer.equals(p.answer)) {
								out.println("Wrong, try again.");
								answer = in.readLine();
							}

						}

						out.flush();
						out.close();
						System.out.println(Thread.currentThread().getName() + ": connection closed.");
					} catch (Exception e) {}
				}
			});

			thread.start();
		}
	}

	private class Places {
		public String question, answer;
		public Places(String question, String answer) {
			this.question = question;
			this.answer = answer;
		}
	}
}