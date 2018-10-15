import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Database {
	
	HashMap<Item, Double> hashMapItems;
	TreeMap<Item, Double> treeMapItems;

	public Database(String filename) {
		hashMapItems = new HashMap<Item, Double>();
		treeMapItems = new TreeMap<Item, Double>();

		try {

			Scanner in = new Scanner(new File(filename));

			while (in.hasNextLine()) {

				String[] parts = in.nextLine().split(",");

				Item item = new Item(parts[0], parts[1]);

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

}