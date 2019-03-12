public class Runner {
  public static void main(String[] args) {
    System.out.println("Part 1");
    BinarySearchTree<Integer> bt = new BinarySearchTree<Integer>();
    bt.add(90);
    bt.add(80);
    bt.add(100);
    bt.add(70);
    bt.add(85);
    bt.add(98);
    bt.add(120);
    System.out.println(bt.toString());
    System.out.println(bt.toStringPreOrder());
    System.out.println(bt.contains(85));
    System.out.println(bt.contains(86));
    System.out.println();

    System.out.println("Part 2");
    bt.remove(70);
    bt.remove(120);
    System.out.println(bt.toString());
    System.out.println(bt.toStringPreOrder());
    System.out.println();

    System.out.println("Part 3");
    BinarySearchTree<Integer> bt2 = new BinarySearchTree<Integer>();
    bt2.add(90);
    bt2.add(80);
    bt2.add(100);
    bt2.add(70);
    bt2.add(85);
    bt2.add(98);
    bt2.add(120);
    bt2.remove(100);
    System.out.println(bt2.toString());
    System.out.println(bt2.toStringPreOrder());
    System.out.println();

    System.out.println("Part 4");
    BinarySearchTree<Integer> bt3 = new BinarySearchTree<Integer>();
    bt3.add(90);
    bt3.add(80);
    bt3.add(100);
    bt3.add(98);
    bt3.add(91);
    bt3.add(99);
    bt3.remove(100);
    System.out.println(bt3.toString());
    System.out.println(bt3.toStringPreOrder());
    System.out.println();

    System.out.println("Part 5");
    BinarySearchTree<Integer> bt4 = new BinarySearchTree<Integer>();
    bt4.add(90);
    bt4.add(100);
    bt4.add(98);
    bt4.add(110);
    bt4.remove(90);
    System.out.println(bt4.toString());
    System.out.println(bt4.toStringPreOrder());
    System.out.println();

    System.out.println("Part 6");
    BinarySearchTree<Integer> bt5 = new BinarySearchTree<Integer>();
    bt5.add(90);
    bt5.add(80);
    bt5.add(100);
    bt5.add(98);
    bt5.add(110);
    bt5.add(91);
    bt5.add(95);
    bt5.remove(90);
    System.out.println(bt5.toString());
    System.out.println(bt5.toStringPreOrder());
    System.out.println();

    System.out.println("Part 7");
    BinarySearchTree<Integer> bt6 = new BinarySearchTree<Integer>();
    bt6.add(90);
    bt6.remove(90);
    System.out.println(bt6.toString());
    System.out.println(bt6.toStringPreOrder());
  }
}
