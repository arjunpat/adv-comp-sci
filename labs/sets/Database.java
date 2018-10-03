import java.util.HashSet;
import java.util.TreeSet;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Database {
	// used for retrieving the item price
	private HashSet<Item> hashSetItems;
	private TreeSet<Item> treeSetItems;

	public Database(String fileName) {

		hashSetItems = new HashSet<Item>();
		treeSetItems = new TreeSet<Item>();

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

	

}