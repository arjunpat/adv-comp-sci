import java.util.LinkedList;
import java.util.Scanner;

public class Runner {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    LinkedList[] table = new LinkedList[10];

    for (int i = 0; i < table.length; i++) {
      table[i] = new LinkedList();
    }

    while (true) {
      String input = sc.nextLine();

      if (input.equals("end")) {
        for (int i = 0; i < table.length; i++) {
          System.out.print("Bucket " + i + " ->");

          for (int j = 0; j < table[i].size(); j++) {
            System.out.print(table[i].get(j) + ", ");
          }

          System.out.println();
        }
        break;
      }

      Integer integer = Integer.parseInt(input);
      table[integer.hashCode() % table.length].add(integer);
    }
  }
}
