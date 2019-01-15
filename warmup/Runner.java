import java.util.Iterator;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

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

		System.out.println("Enter an index");
		System.out.println(strings.get(kb.nextInt()));

		System.out.println("Enter a word");
		String word = kb.next();

		if (strings.contains(word)) {
			System.out.println("Is in list at index " + strings.indexOf(word));
		} else {
			System.out.println("Is not in list");
		}

		System.out.println("Enter a word");
		word = kb.next();
		strings.remove(word);
		System.out.println(strings);

		System.out.println("Type a location");
		int location = kb.nextInt();
		strings.set(location, "Hello");
		System.out.println(strings);

	}
}
