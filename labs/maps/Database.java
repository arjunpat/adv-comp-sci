import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.ArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Database {
	
	HashMap<Item, Double> hashMapItems;
	TreeMap<Item, Double> treeMapItems;
	ArrayList<Pair<Item, Integer>> cart;

	public Database(String filename) {
		hashMapItems = new HashMap<Item, Double>();
		treeMapItems = new TreeMap<Item, Double>();
		cart = new ArrayList<Pair<Item, Integer>>();

		try {

			Scanner in = new Scanner(new File(filename));

			while (in.hasNextLine()) {

				String[] parts = in.nextLine().split(",");
				double weight = this.round((Math.random() * 10) + 1, 1);

				Item item = new Item(parts[0], parts[1], weight);

				double price = Double.parseDouble(parts[2]);

				hashMapItems.put(item, price);
				treeMapItems.put(item, price);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public String getAllItems() {
		String allItems = "";

		Iterator<Item> it = treeMapItems.keySet().iterator();
		
		while (it.hasNext()) {
			Item i = it.next();
			double price = treeMapItems.get(i);

			allItems += i.toString() + " — $" + price + "\n";
		}

		return allItems;
	}

	public void addToCart(String name, int quantity) {
		Item item = new Item(name, "", 0);

		if (hashMapItems.containsKey(item))
			return;

		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getKey().getName().equals(name)) {
				cart.remove(i);
			}
		}

		Pair<Item, Integer> p = new Pair<Item, Integer>(this.getFromHashMap(name), quantity);

		cart.add(p);

	}

	public Item getFromHashMap(String name) {
		Iterator<Item> it = hashMapItems.keySet().iterator();

		while (it.hasNext()) {
			Item i = it.next();
			if (i.getName().equals(name)) {
				return i;
			}
		}

		return null;
	}

	public String cartToString() {
		String all = "";
		double total = 0;
		double totalWeight = 0;

		for (int i = 0; i < cart.size(); i++) {
			Pair<Item, Integer> p = cart.get(i);
			Item item = p.getKey();
			int quantity = p.getValue();
			double cost = this.round((hashMapItems.get(item) * quantity), 2);
			double weight = this.round(item.getWeight() * quantity, 2);
			all += quantity + " " + item.getName() + " — $" + cost + " — " + weight + " lbs. \n";
			total += cost;
			totalWeight += weight;
		}

		all += "\n\nTotal weight: " + totalWeight + " lbs.\nTotal: $" + total + "\nTotal with shipping: $" + this.round((total + (.18 * totalWeight)), 2);

		return all;
	}

	public static double round(double value, int places) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public void changePrice(String name, double price, double weight) {

		Item i = this.getFromHashMap(name);
		i.setWeight(weight);
		hashMapItems.put(i, price);
		treeMapItems.put(i, price);

	}

	public void addItem(String name, String company, double price, double weight) {

		Item i = new Item(name, company, weight);
		hashMapItems.put(i, price);
		treeMapItems.put(i, price);

	}

	public void removeItem(String name) {

		Item item = this.getFromHashMap(name);
		hashMapItems.remove(item);
		treeMapItems.remove(item);

		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getKey().getName().equals(name)) {
				cart.remove(i);
			}
		}

	}

}
