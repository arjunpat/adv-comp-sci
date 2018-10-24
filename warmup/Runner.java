import java.util.Stack;

public class Runner {
	public static void main(String[] args) {

		char[] operators = {'+', '-', '*', '/'};
		char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

		String[] test = new String[5];
		test[0] = "2 7 + 1 2 + +";
		test[1] = "1 2 3 4 + + +";
		test[2] = "3 3 + 7 * 9 2 / +";
		test[3] = "9 3 / 2 * 7 9 * + 4 -";
		test[4] = "5 5 + 2 * 4 / 9 +";


		for (int y = 0; y < test.length; y++) {
			String str = test[y];

			Stack<Double> theStack = new Stack<Double>();

			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);

				if (isInArr(ch, operators)) {
					if (theStack.size() > 1) {
						double first = theStack.pop();
						double second = theStack.pop();

						if (ch == '+') {
							theStack.push( second + first );
						} else if (ch == '-') {
							theStack.push( second - first );
						} else if (ch == '*') {
							theStack.push( second * first );
						} else if (ch == '/') {
							theStack.push( second / first );
						}

					}
				} else if (isInArr(ch, nums)) {
					int val = Character.getNumericValue(ch);
					theStack.push( (double)val );
				}
			}

			System.out.println(theStack);
		}
	}

	public static boolean isInArr(char str, char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (str == arr[i]) {
				return true;
			}
		}

		return false;
	}
}