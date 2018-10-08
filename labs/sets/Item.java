import java.lang.Comparable;

public class Item implements Comparable<Item> {
	private String name;
	private double price;


	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public boolean equals(Object o) {
		Item item = (Item)o;

		return item.hashCode() == o.hashCode();
	}

	public int hashCode() {
		int hashCode = 0;

		/*for (int i = name.length() - 1; i >= 0; i++) {
			int num = (int)name.charAt(i);
			num -= 96;

			hashCode += num * Math.pow(i, 26);
		}*/

		hashCode = name.hashCode();

		hashCode = (hashCode * 31) + (int)(price * 100);

		return hashCode;
	}

	public int compareTo(Item item) {
		return this.getCompareString().compareTo(item.getCompareString());
	}

	public String getCompareString() {
		return name + "-" + price;
	}

	public String toString() {
		return "Name: " + name + " Price: " + price;
	}
}