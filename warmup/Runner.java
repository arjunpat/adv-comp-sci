import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

class Runner {
  public static void main(String[] args) {

	Queue<Ticket> list = new LinkedList<Ticket>();
	PriorityQueue<Ticket> pq = new PriorityQueue<Ticket>();

	Scanner kb = new Scanner(System.in);


	int input;

	do {

		System.out.println("1. Create ticket");
		System.out.println("2. Service ticket");
		System.out.println("3. View completed");
		System.out.println("4. Quit");

		input = kb.nextInt();

		if (input == 1) {

			System.out.println("Enter a name");
			String name = kb.next();

			System.out.println("Enter a description");
			kb.nextLine();
			String description = kb.nextLine();

			System.out.println("Enter a priority");
			String priority = kb.next();
			int pri = 0;

			if (priority.equals("high")) {
				pri = 5;
			}

			pq.add(new Ticket(name, description, "", pri));

		} else if (input == 2) {

			Ticket t = pq.poll();

			System.out.println(t);
			System.out.println("Add a note");

			t.setNote( kb.next() );

			list.add(t);

		} else if (input == 3) {

			System.out.println(list);

		}

	} while (input != 4);
	
  }
}