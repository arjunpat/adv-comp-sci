import java.util.Stack;

public class Runner {
	public static void main(String[] args) {

		Stack<Box> stack = new Stack<Box>();

		stack.push(new Box("Shoes", 2.5));
		stack.push(new Box("Speakers", 4.1));
		stack.push(new Box("Cups", 3));

		double totalWeight = 0;

		while (!stack.isEmpty()) {
			Box box = stack.pop();
			totalWeight += box.getWeight();
			System.out.println(box);
		}
		
		System.out.println("Total Weight: " + totalWeight + " lbs.");
	}
}