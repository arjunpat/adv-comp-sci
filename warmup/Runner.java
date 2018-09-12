import java.util.ArrayList;

public class Runner {
	public static void main(String[] args) {

		ArrayList<MyItem<String, Double>> list = new ArrayList<MyItem<String, Double>>();
		list.add(new MyItem<String, Double>("car", 15000.0));
		list.add(new MyItem<String, Double>("potato", 12.0));
		list.add(new MyItem<String, Double>("carrot", 1.0));

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}