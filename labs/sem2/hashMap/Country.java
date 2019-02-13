public class Country {
	private String abb, name;

	public Country(String name, String abb) {
		this.name = name;
		this.abb = abb;
	}

	public int hashCode() {
		return abb.hashCode();
	}

	public String toString() {
		return name + " (" + abb + ")";
	}
}