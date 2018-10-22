import java.util.Stack;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {

		Stack<String> stack = new Stack<String>();
		Scanner sc = new Scanner(System.in);

		int input;

		do {

			System.out.println("0. Quit");
			System.out.println("1. View the entire stack");
			System.out.println("2. View just the top of the stack.");
			System.out.println("3. Add a word to a stack.");
			System.out.println("4. Print the size of the stack.");

			input = sc.nextInt();

			switch (input) {
				case 1:
					System.out.println(stack);
					break;
				case 2:
					System.out.println(stack.peek());
					break;
				case 3:
					System.out.println("Type of word");
					String word = sc.next();
					stack.push(word);
					break;
				case 4:
					System.out.println("Size of stack: " + stack.size());
					break;

			}

		} while (input != 0);

	}

}