public class Student {
	private String name;
	private int id;
	private int age;
	private String gradeLevel;
	private static int order = 0;
	private int internalOrder;

	public Student(String name, int id, int age, String gradeLevel) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.gradeLevel = gradeLevel;
		order++;
		internalOrder = order;
	}

	public String getName() {
		return name;
	}

	public int getID() {
		return id;
	}

	public double getOrder() {
		return internalOrder;
	}

	public String toString() {
		return name + ", ID: " + id + ", Age: " + age + " Grade Level: " + gradeLevel;
	}
}
