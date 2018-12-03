import java.util.HashSet;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.io.FileNotFoundException;
import java.io.File;

public class Database {
	// used for retrieving the item price
	private HashSet<Item> hashSetItems;
	private TreeSet<Item> treeSetItems;
	private ArrayList<Pair<Item, Integer> > cart;

	public Database(String fileName) {

		hashSetItems = new HashSet<Item>();
		treeSetItems = new TreeSet<Item>();
		cart = new ArrayList<Pair<Item, Integer> >();

		try {
			Scanner in = new Scanner(new File(fileName));

			while (in.hasNextLine()) {

				String[] itemParts = in.nextLine().split(",");
				Item item = new Item(itemParts[0], Double.parseDouble(itemParts[1]));

				hashSetItems.add(item);
				treeSetItems.add(item);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}


	public String getAllItems() {
		String things = "";
		Iterator it = treeSetItems.iterator();

		while (it.hasNext()) {
			things += it.next().toString() + "\n";
		}

		return things.substring(0, things.length() - 1);
	}


	public void addToCart(Item item, int quantity) {

		if (!hashSetItems.contains(item))
			return;

		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getKey().compareTo(item) == 0) {
				cart.remove(i);
			}
		}
		if (quantity > 0) {
			Pair<Item, Integer> p = new Pair<Item, Integer>(item, quantity);
			cart.add(p);
		}
	}

	public void addToInventory(Item item) {
		if (hashSetItems.contains(item))
			return;

		hashSetItems.add(item);
		treeSetItems.add(item);
	}

	public void removeFromInventory(Item item) {
		
		if (!hashSetItems.contains(item))
			return;

		hashSetItems.remove(item);
		treeSetItems.remove(item);
	}

	public String cartToString() {
		String things = "";
		double totalCost = 0;

		for (int i = 0; i < cart.size(); i++) {
			Pair<Item, Integer> p = cart.get(i);
			Item item = p.getKey();
			String name = item.getName();
			int quantity = p.getValue();
			double price = this.round(item.getPrice() * quantity, 2);
			totalCost += price;

			things += name + ", quantity: " + quantity + ", price: $" + price + "\n";
		}

		totalCost = this.round(totalCost, 2);
		things += "Total: $" + totalCost;

		return things;
	}

	public static double round(double value, int places) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

}