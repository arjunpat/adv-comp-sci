public class Runner {
  public static void main(String[] args) {
    BinarySearchTree<Integer> bt = new BinarySearchTree<Integer>();

    System.out.println("Part 1");
    bt.add(91);
    bt.add(80);
    bt.add(100);
    bt.add(98);
    bt.add(110);
    bt.add(99);
    System.out.println(bt);
    System.out.println(bt.toStringPreOrder());
    System.out.println(bt.getHeight());
    System.out.println();

    BinarySearchTree<Integer> bt2 = new BinarySearchTree<Integer>();
    System.out.println("Part 2");
    bt2.add(90);
    bt2.add(100);
    bt2.add(98);
    bt2.add(110);
    System.out.println(bt2);
    System.out.println(bt2.toStringPreOrder());
    System.out.println(bt2.getHeight());
  }
}
