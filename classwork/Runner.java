/*
Create a DLList object.
Add the following strings "Cat", "Dog", "Bird", "Bear", and "Pig".
Display the list.
Ask the user to add in an Animal.  Add that animal and display the list.
Ask the user to add in an Animal at a location.  Add that animal and display the list.
Ask the user to get  an Animal at a location.  Get it, and display that animal.
*/
import java.util.Scanner;

public class Runner {
  public static void main(String[] args) {
    DLList<String> list = new DLList<String>();
    Scanner kb = new Scanner(System.in);

    list.add("Cat");
    list.add("Dog");
    list.add("Bird");
    list.add("Bear");
    list.add("Pig");

    System.out.println(list);

    System.out.println("Ender an animal");
    String name = kb.next();
    list.add(name);
    System.out.println(list);

    System.out.println("Enter an animal");
    String name2 = kb.next();
    System.out.println("Enter an index");
    int index = kb.nextInt();
    list.add(index, name2);
    System.out.println(list);

    System.out.println("Enter an index");
    int index2 = kb.nextInt();
    System.out.println(list.get(index2));
  }
}
