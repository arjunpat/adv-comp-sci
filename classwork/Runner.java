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
    System.out.println(bt.getHeight());
    System.out.println(bt.getLevels());
    System.out.println(bt.getLevel(90));
    System.out.println(bt.getLevel(120));

    System.out.println("Part 2");
    BinarySearchTree<Integer> bt2 = new BinarySearchTree<Integer>();
    bt2.add(90);
    bt2.add(91);
    bt2.add(92);
    bt2.add(93);
    System.out.println(bt2.toString());
    System.out.println(bt2.toStringPreOrder());
    System.out.println(bt2.getHeight());
    System.out.println(bt2.getLevels());
    System.out.println(bt2.getLevel(90));
    System.out.println(bt2.getLevel(120));

    System.out.println("Part 3");
    BinarySearchTree<Integer> bt3 = new BinarySearchTree<Integer>();
    bt3.add(90);
    bt3.add(150);
    bt3.add(170);
    bt3.add(160);
    bt3.add(171);
    bt3.add(151);
    System.out.println(bt3.toString());
    System.out.println(bt3.toStringPreOrder());
    System.out.println(bt3.getHeight());
    System.out.println(bt3.getLevels());
    System.out.println(bt3.getLevel(150));
    System.out.println(bt3.getLevel(151));

    System.out.println("Classwork 2A");
    BinarySearchTree<Integer> bt4 = new BinarySearchTree<Integer>();
    bt4.add(90);
    bt4.add(80);
    bt4.add(100);
    bt4.add(70);
    bt4.add(85);
    bt4.add(98);
    bt4.add(120);
    System.out.println(bt4.getNodes(90));
    System.out.println(bt4.getNodes(80));
    System.out.println(bt4.getNodes(100));
    System.out.println(bt4.getNodes(98));

    System.out.println("Classwork 2B");
    BinarySearchTree<Integer> bt5 = new BinarySearchTree<Integer>();
    bt5.add(90);
    bt5.add(150);
    bt5.add(170);
    bt5.add(160);
    bt5.add(171);
    bt5.add(151);
    System.out.println(bt5.getNodes(90));
    System.out.println(bt5.getNodes(150));
    System.out.println(bt5.getNodes(170));
    System.out.println(bt5.getNodes(160));
  }
}
