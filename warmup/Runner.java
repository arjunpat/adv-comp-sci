public class Runner {
	public static void main(String[] args) {
		Manager manager = new Manager();
		Animal a1 = new Animal("Dog", 5);

		System.out.println(a1);

		manager.changeMe(a1, "cat", 3);

		System.out.println(a1);
	}
}