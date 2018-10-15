import java.lang.Comparable;

public class Item implements Comparable<Item> {
	
	private String name;
	private String companyName;

	public Item(String name, String companyName) {
		this.name = name;
		this.companyName = companyName;
	}

	public int hashCode() {
		return name.hashCode();
	}

	public int compareTo(Item item) {
		return name.compareTo(item.getName());
	}

	public String getName() { return name; }
	public String getCompanyName() { return companyName; }

	public String toString() {
		return name + " (" + companyName + ")";
	}
}