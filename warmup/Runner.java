import java.util.ArrayList;
import java.util.Scanner;
import java.util.ListIterator;

public class Runner {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> list = new ArrayList<Integer>();

		while (true) {

			int input = sc.nextInt();

			if (input == -1) {
				break;
			}

			ListIterator<Integer> it = list.listIterator();

			if (!it.hasNext()) {
				it.add(input);
			} else {

				boolean isAdded = false;

				while (it.hasNext()) {
					if (it.next() > input) {
						it.previous();
						it.add(input);
						isAdded = true;
						break;
					}
				}

				if (!isAdded) {
					it.add(input);
				}
			}


		}

		System.out.println(list);

	}
}