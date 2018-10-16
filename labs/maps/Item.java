import java.lang.Comparable;

public class Item implements Comparable<Item> {
	
	private String name;
	private String companyName;
	private double weight;

	public Item(String name, String companyName, double weight) {
		this.name = name;
		this.companyName = companyName;
		this.weight = weight;
	}

	public int hashCode() {
		return name.hashCode();
	}

	public int compareTo(Item item) {
		return name.compareTo(item.getName());
	}

	public String getName() { return name; }
	public String getCompanyName() { return companyName; }
	public double getWeight() { return this.weight; }

	public void setWeight(double weight) { this.weight = weight; }

	public String toString() {
		return name + " (" + companyName + ") — " + weight + " lbs.";
	}
}
