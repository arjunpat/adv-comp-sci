
public class Box {
	private String name;
	private double weight;

	public Box(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}

	public String toString() {
		return "Name: " + name + " Weight: " + weight + " lbs.";
	}

	public double getWeight() {
		return this.weight;
	}

}