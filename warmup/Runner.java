import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<Student> list = new ArrayList<Student>();

		while (true) {

			System.out.println("Enter a name");
			String name = sc.next();

			System.out.println("Enter their grade");
			int grade = sc.nextInt();

			list.add(new Student(name, grade));

		}

	}
}