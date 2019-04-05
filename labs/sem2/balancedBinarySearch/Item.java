

public class Item implements Comparable<Item> {
	private String name;
	private double price;

	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public boolean equals(Object o) {
		Item a = (Item)o;
		return getName().equals(a.getName());
	}

	public int compareTo(Item a) {
		return getName().compareTo(a.getName());
	}

	public String toString() {
		return name + ", $" + price;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
}