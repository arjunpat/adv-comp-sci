import java.util.LinkedList;
import java.util.Scanner;

class Runner {
  public static void main(String[] args) {

    Scanner kb = new Scanner(System.in);
  	LinkedList<Student> ll = new LinkedList<Student>();

  	ll.add(new Student("Marley", 23423, 16, "11th"));
  	ll.add(new Student("Arjun", 23492, 15, "11th"));
  	ll.add(new Student("Tanay", 26432, 16, "10th"));

    int input = 0;

  	while (input != 8) {

      System.out.println("What would you like to do?");
      System.out.println("1. View the student list");
      System.out.println("2. View student by name");
      System.out.println("3. Delete a student by name");
      System.out.println("4. Sort by student id");
      System.out.println("5. Sort by alphabetically");
      System.out.println("6. Sort by time added");
      System.out.println("7. Add a student");
      System.out.println("8. Quit");

      input = kb.nextInt();


      if (input == 1) {

        for (int i = 0; i < ll.size(); i++) {
          System.out.println(ll.get(i));
        }

      } else if (input == 2) {
        System.out.println("Enter a name");
        String name = kb.next();

        for (int i = 0; i < ll.size(); i++) {
          if (name.equals(ll.get(i).getName())) {
            System.out.println(ll.get(i));
          }
        }
      } else if (input == 3) {
        System.out.println("Enter a name");
        String name = kb.next();

        for (int i = 0; i < ll.size(); i++) {
          if (name.equals(ll.get(i).getName())) {
            ll.remove(i);
          }
        }
      } else if (input == 4) {
        for (int i = 0; i < ll.size() - 1; i++) {
          for (int j = i + 1; j < ll.size(); j++) {
            Student one = ll.get(i);
            Student two = ll.get(j);

            if (two.getID() < one.getID()) {
              ll.set(j, one);
              ll.set(i, two);
            }
          }
        }
      } else if (input == 5) {

        for (int i = 0; i < ll.size() - 1; i++) {
          for (int j = i + 1; j < ll.size(); j++) {
            Student one = ll.get(i);
            Student two = ll.get(j);

            if (one.getName().compareTo(two.getName()) > 0) {
              ll.set(j, one);
              ll.set(i, two);
            }

          }
        }

      } else if (input == 6) {

        for (int i = 0; i < ll.size() - 1; i++) {
          for (int j = i + 1; j < ll.size(); j++) {
            Student one = ll.get(i);
            Student two = ll.get(j);

            if (one.getOrder() > two.getOrder()) {
              ll.set(j, one);
              ll.set(i, two);
            }

          }
        }

      } else if (input == 7) {
        System.out.println("What is the name of the student?");
        String name = kb.next();

        System.out.println("What is the student id?");
        int id = kb.nextInt();

        System.out.println("What is the student's age?");
        int age = kb.nextInt();

        System.out.println("What is the student's grade?");
        String grade = kb.next();

        ll.add(new Student(name, id, age, grade));
      }

    }

	}
}
