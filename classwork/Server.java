import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Server {
	public static void main(String[] args) throws IOException {
		int portNumber = 8080;
		ServerSocket serverSocket = new ServerSocket(portNumber);
		ArrayList<Socket> clientSockets = new ArrayList<Socket>();

		Thread acceptConnections = new Thread(new Runnable() {
			public void run() {
				while (true) {

					try {
						Socket clientSocket = serverSocket.accept();
						System.out.println("New connection");

						clientSockets.add(clientSocket);

						Thread each = new Thread(new Runnable() {
							public void run() {

								try {
									BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

									while (true) {
										String line = in.readLine();
										broadcast(line, clientSockets);
									}
								} catch (Exception e) {}
							}
						});

						each.start();
					} catch (Exception e) {}
				}
			}
		});

		acceptConnections.start();
	}

	public static void broadcast(String text, ArrayList<Socket> sockets) {
		for (int i = 0; i < sockets.size(); i++) {

			try {
				PrintWriter out = new PrintWriter(sockets.get(i).getOutputStream(), true);

				out.println(text);
			} catch (Exception e) {}
		}
	}
}
