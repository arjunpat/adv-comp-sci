public class Runner {
  public static void main(String[] args) {
    BinarySearchTree<Integer> bt = new BinarySearchTree<Integer>();
    bt.add(90);
    bt.add(80);
    bt.add(100);
    bt.add(70);
    bt.add(85);
    bt.add(98);
    bt.add(120);

    System.out.println(bt.toString());
  }
}
