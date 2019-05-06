import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(System.in);

		Socket serverSocket = new Socket("localhost", 8080);
		BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
		PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);

		try {
			while (true) {
				String fromServer = in.readLine();
				System.out.println(fromServer);

				out.println(kb.nextLine());
			}
		} catch (Exception e) {}
	}
}