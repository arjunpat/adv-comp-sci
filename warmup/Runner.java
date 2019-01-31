import java.util.Scanner;
public class Runner {
  public static void main(String[] args) {

    DLList<String> animals = new DLList<String>();
    animals.add("Bear");
    animals.add("Bat");
    animals.add("Dog");
    animals.add("Horse");
    animals.add("Rabbit");

    System.out.println("Recursive Print");
    animals.print();
    System.out.println();

    System.out.println("Reverse Order");
    System.out.println(animals);
    animals.reverse();
    System.out.println(animals);
  }
}
