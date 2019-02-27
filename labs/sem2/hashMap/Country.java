import java.io.Serializable;

public class Country implements Serializable {
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