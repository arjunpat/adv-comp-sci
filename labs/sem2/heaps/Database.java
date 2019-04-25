import java.util.ArrayList;

public class Database {
	private MinHeap<Order> orders;
	private MinHeap<Order> completedOrders;
	private ArrayList<MenuItem> menuItems;
	private ArrayList<View> allTheViews;

	public Database() {
		allTheViews = new ArrayList<View>();
		orders = new MinHeap<Order>();
		menuItems = new ArrayList<MenuItem>();
		completedOrders = new MinHeap<Order>();

		menuItems.add(new MenuItem("Burger", 6.5, "https://s3.amazonaws.com/pixtruder/original_images/9fbb73a7cba9b7b75c3d05484f6b6d087470641d"));
		menuItems.add(new MenuItem("Pizza", 10.5, "https://upload.wikimedia.org/wikipedia/commons/a/a3/Eq_it-na_pizza-margherita_sep2005_sml.jpg"));
		menuItems.add(new MenuItem("Chole", 198.99, "https://www.cookwithmanali.com/wp-content/uploads/2014/03/punjabi-chole-masala-1-notitle-cwm.jpg"));
		menuItems.add(new MenuItem("Chow Mein", 12.0, "https://www.recipetineats.com/wp-content/uploads/2016/07/Chow-Mein_9.jpg"));
		menuItems.add(new MenuItem("Oreo", 199.99, "https://images.britcdn.com/wp-content/uploads/2017/05/Oreos-and-milk-645x430.jpg?w=1000&auto=format"));
		menuItems.add(new MenuItem("Ice Cream Sundae", 9.99, "https://upload.wikimedia.org/wikipedia/commons/3/31/Ice_Cream_dessert_02.jpg"));

	}

	public ArrayList<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void addOrder(Order o) {
		orders.add(o);
		changesMade();
	}

	public Order peekOrder() {
		return orders.peek();
	}

	public Order peekCompletedOrder() {
		return completedOrders.peek();
	}

	public void doneWithCompletedOrder() {
		completedOrders.poll();
	}

	public void doneWithOrder() {
		completedOrders.add(orders.poll());
		changesMade();
	}

	public void addChangeListener(View v) {
		allTheViews.add(v);
	}

	public void changesMade() {
		for (int i = 0; i < allTheViews.size(); i++) {
			allTheViews.get(i).onChange();
		}
	}
}