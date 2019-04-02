

public class Item implements Comparable<Item> {
	private String name;
	private double price;

	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public boolean equals(Object o) {
		Item a = (Item)o;
		return toString().equals(a.toString());
	}

	public int compareTo(Item a) {
		return toString().compareTo(a.toString());
	}

	public String toString() {
		return name;
	}

	public double getPrice() {
		return price;
	}
}