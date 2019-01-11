/*
Ask the user for information on a new student.  Then create a node of that student and add it your list of connected nodes.
Go through and print the connected nodes of students.
Ask the user the id of a student.  Then remove that student from your list of connected nodes.
Go through and print the connected nodes of students. (Hint: You can override the equals(Object) method to check for just the IDs).
*/

import java.util.Scanner;

public class Runner {
  public static void main(String[] args) {

    Scanner kb = new Scanner(System.in);

    LinkedList<Profile> profileList = new LinkedList<Profile>();

    profileList.add(new Profile("Marley", 16));
    profileList.add(new Profile("Arjun", 15));
    profileList.add(new Profile("Tanay", 16));

    LinkedList<Student> studentList = new LinkedList<Student>();

    studentList.add(new Student("Marley", 23423, 16, "11th"));
  	studentList.add(new Student("Arjun", 23492, 15, "11th"));
  	studentList.add(new Student("Tanay", 26432, 16, "10th"));

    System.out.println("What is the name of the student?");
    String name = kb.next();

    System.out.println("What is the student id?");
    int id = kb.nextInt();

    System.out.println("What is the student's age?");
    int age = kb.nextInt();

    System.out.println("What is the student's grade?");
    String grade = kb.next();

    studentList.add(new Student(name, id, age, grade));

    for (int i = 0; i < studentList.size(); i++) {
      System.out.println(studentList.get(i));
    }

    System.out.println("Enter an ID");
    int id2 = kb.nextInt();

    for (int i = 0; i < studentList.size(); i++) {
      if (id2 == studentList.get(i).getID()) {
        studentList.remove(i);
      }
    }

    for (int i = 0; i < studentList.size(); i++) {
      System.out.println(studentList.get(i));
    }

  }
}
