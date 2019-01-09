import java.util.LinkedList;

public class Runner {
	public static void main(String[] args) {
		LinkedList<Item> ll = new LinkedList<Item>();

		ll.add(new Item("Pencil", .25));
		ll.add(new Item("Pen", .49));
		ll.add(new Item("Paper", .1));

		System.out.println(ll);
	}
}