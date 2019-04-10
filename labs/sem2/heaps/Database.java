import java.util.ArrayList;

public class Database {
	private MinHeap<Order> orders;
	private ArrayList<View> allTheViews;

	public Database() {
		allTheViews = new ArrayList<View>();
		orders = new MinHeap<Order>();

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