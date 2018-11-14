import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);


		try {
			Socket conn = new Socket("localhost", 8080);

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			PrintWriter out = new PrintWriter(conn.getOutputStream(), true);

			System.out.println(in.readLine());
			out.println(kb.nextLine());
			System.out.println(in.readLine());


			System.out.println(in.readLine());
			out.println(kb.nextLine());
			System.out.println(in.readLine());


			System.out.println(in.readLine());
			out.println(kb.nextLine());
			System.out.println(in.readLine());


			System.out.println(in.readLine());
			out.println(kb.nextLine());
			System.out.println(in.readLine());


			System.out.println(in.readLine());
			out.println(kb.nextLine());
			System.out.println(in.readLine());

			in.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}