import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

import java.io.Serializable;

public class Database implements Serializable {

	private BinarySearchTree<Account> accounts = new BinarySearchTree<Account>();

	public Database(String filename) {

		try {
			Scanner in = new Scanner(new File(filename));

			while (in.hasNextLine()) {

				String[] itemParts = in.nextLine().split(",");
				Account account = new Account(itemParts[1], itemParts[0], (int)(8999 * Math.random()) + 1000, 100000 * Math.random());

				accounts.add(account);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public String getAllNames() {
		return accounts.toString();
	}

	public int addAccount(Account account) {
		return accounts.add(account);
	}

	public Account search(Account account) {
		return accounts.get(account);
	}

	public void remove(Account account) {
		accounts.remove(account);
	}

	public int getPasses() {
		return accounts.getPasses();
	}
}