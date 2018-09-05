import java.util.*;

public class Runner {
	public static void main(String[] args) {


		ArrayList<Animal> langs = new ArrayList<Animal>();
		langs.add(new Cat("Liam"));
		langs.add(new Dog("Tanay"));
		langs.add(new Bird("Birdo"));

		for (int i = 0; i < langs.size(); i++) {
			langs.get(i).printInfo();
		}

	}
}