import java.util.Iterator;

public class Runner {
	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();

		ll.add("hello");
		ll.add("wassup!");
		ll.add("arjun!");
		ll.add("bob!");
		ll.add("carl!");
		ll.add("tv!");

		System.out.println(ll.size());

		ll.add(3, "after arjun");

		System.out.println(ll);

		Iterator<String> it = ll.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}