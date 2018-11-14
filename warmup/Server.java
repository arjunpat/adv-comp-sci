import java.net.*;
import java.io.*;
import java.util.HashMap;

public class Server {
	public static void main(String[] args) {

		try {
			HashMap<String, String> responses = new HashMap<String, String>();

			responses.put("problem", "Please explain your problem");
			responses.put("hi", "Hello");
			responses.put("hello", "Hello");
			responses.put("age", "I am 42 years old");
			responses.put("name", "My name is Bobita, the chat bot");
			responses.put("food", "My favorite food is pizza!");
			responses.put("bad", "Why do you feel bad?");
			responses.put("happy", "Why do you feel happy?");

			ServerSocket app = new ServerSocket(8080);
			Socket client = app.accept();

			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);

			while (true) {
				String entry = in.readLine();

				if (entry.equals("bye"))
					break;

				System.out.println("Entry: " + entry);

				out.println(getResponse(entry, responses));
			}


			in.close();
			out.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static String getResponse(String in, HashMap<String, String> map) {

		String[] parts = in.toLowerCase().split(" ");
		for (int i = 0; i < parts.length; i++) {
			if (map.containsKey(parts[i]))
				return map.get(parts[i]);
		}

		return "Sorry. I don't understand.";

	}
}