import java.net.*;
import java.io.*;

public class Server {
	public static void main(String[] args) {

		try {
			ServerSocket app = new ServerSocket(8080);
			Socket client = app.accept();

			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);

			out.println("What is the capital of Washington?");
			if (in.readLine().equals("Olympia")) {
				out.println("correct");
			} else {
				out.println("incorrect, it is Olympia");
			}

			out.println("What is the capital of India?");
			if (in.readLine().equals("New Delhi")) {
				out.println("correct");
			} else {
				out.println("incorrect, it is New Delhi");
			}

			out.println("What is the capital of England?");
			if (in.readLine().equals("London")) {
				out.println("correct");
			} else {
				out.println("incorrect, it is London");
			}

			out.println("Is New York on the West or East of the United States?");
			if (in.readLine().equals("East")) {
				out.println("correct");
			} else {
				out.println("incorrect, it is on the East");
			}

			out.println("What is earth's largest continent?");
			if (in.readLine().equals("Asia")) {
				out.println("correct");
			} else {
				out.println("incorrect, the answer is Asia");
			}

			out.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}