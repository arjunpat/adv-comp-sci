import java.util.LinkedList;

public class Runner {
	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();

		ll.add("hello");
		ll.add("wassup!");

		System.out.println(ll.size());

		for (int i = 0; i < ll.size(); i++) {
			System.out.println(ll.get(i));
		}
	}
}