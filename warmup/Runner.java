public class Runner {
	public static void main(String[] args) {



		SLList<Student> students = new SLList<Student>();
		students.add(new Student("John", 1234));
		students.add(new Student("Jen", 4321));
		students.add(new Student("Jose", 1111));

		students.remove(new Student("John",1234));
		students.remove(new Student("Jose",1111));

		System.out.println(students);

	}
}