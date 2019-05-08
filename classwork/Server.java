import java.next.*;
import java.io.*;

public class Server {
	public static void main(String[] args) throws IOException {
		int portNumber = 1024;
		ServerSocket serverSocket = new ServerSocket(portNumber);

		Manager cm = new Manager();

		while (true) {
			System.out.println("Waiting for a connection");
			Socket clientSocket = serverSocket.accept();

			ServerThread st = new ServerThread(clientSocket, cm);
			cm.addthread(st);

			Thread thread = new Thread(st);
			thread.start();
		}
	}
}
