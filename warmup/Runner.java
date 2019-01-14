import java.util.Iterator;

public class Runner {
	public static void main(String[] args) {
		/*SLList<String> ll = new SLList<String>();

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
		}*/

		SLList<String> strings = new SLList<String>();
		strings.add("cat");
		strings.add("dog");
		strings.add("pig");
		strings.add("bird");

		System.out.println(strings);

		SLList<Integer> integers = new SLList<Integer>();
		integers.add(5);
		integers.add(5);
		integers.add(2);
		integers.add(1);
		integers.add(7);
		integers.add(8);

		System.out.println(integers);
	}
}
