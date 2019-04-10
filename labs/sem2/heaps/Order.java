import java.util.ArrayList;

public class Order implements Comparable<Order> {
	private double time;
	private ArrayList<MenuItem> items = new ArrayList<MenuItem>();

	public Order() {
		this.time = System.currentTimeMillis();
	}

	public int compareTo(Order o) {
		return (int)(o.getTime() - time);
	}

	public double getTime() {
		return time;
	}

	public void add(MenuItem m) {
		items.add(m);
	}

	public double getTotalPrice() {
		double price = 0;

		for (int i = 0; i < items.size(); i++) {
			price += items.get(i).getPrice();
		}

		return price;
	}

	public String toString() {
		return items.toString();
	}
}