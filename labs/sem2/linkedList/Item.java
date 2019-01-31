
public class Item {
	private String name;
	private double price;
	private int quantity;
	private double created;

	public Item(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;

		this.created = System.currentTimeMillis();
	}

	public boolean equals(Object o) {
		Item i = (Item)o;

		return i.getName().equals(name) && i.getPrice() == price;
	}

	public String getName() { return name; }
	public double getPrice() { return price; }
	public int getQuantity() { return quantity; }
<<<<<<< HEAD
=======
	public double getTime() { return created; }
>>>>>>> eea68ad21adb6f64f8f9d99e0e7d5ef2e0ff433c

	public String toString() {
		return name + ", $" + price + ", " + quantity;
	}
}