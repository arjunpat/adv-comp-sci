import java.util.Stack;

public class Classwork {
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();

		stack.push(88);
		stack.push(23);
		stack.push(11);


		System.out.println(stack);

		stack.pop();
		stack.pop();


		System.out.println(stack);

	}
}