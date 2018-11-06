import java.util.Queue;
import java.util.LinkedList;

public class Runner {

	public static void main(String[] args) {

		Queue<Customer> waitingList = new LinkedList<Customer>();

		waitingList.add(new Customer("Arjun", "12391203"));
		waitingList.add(new Customer("Tanay", "12312432"));
		waitingList.add(new Customer("Marley", "12958281"));

		while (waitingList.size() > 0) {
			System.out.println(waitingList.poll());
		}



	}

}