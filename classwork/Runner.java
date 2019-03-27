import java.util.Scanner;

public class Runner {
  public static void main(String[] args) {
    BinarySearchTree<Integer> bt = new BinarySearchTree<Integer>();
    Scanner kb = new Scanner(System.in);

    while (true) {
      System.out.println("Enter an integer or type 0 to stop");
      int response = kb.nextInt();

      if (response == 0) {
        break;
      }

      bt.add(response);
    }
    System.out.println(bt.isBalanced());
    bt.balance();
    System.out.println(bt.isBalanced());

    System.out.println(bt.toStringPreOrder());
  }
}
