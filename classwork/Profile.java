import java.util.*;

public class Profile {
	private String name;
	private int age;

	public Profile(String a, int b) {
		name = a;
		age = b;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return name + ", " + age;
	}
}
