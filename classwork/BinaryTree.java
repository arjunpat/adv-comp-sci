public class BinaryTree<E> {
  private Node<Integer> root;

  public BinaryTree() {
    root = new Node<Integer>(1);
    Node<Integer> left2 = new Node<Integer>(2);
    Node<Integer> right3 = new Node<Integer>(3);
    root.setLeft(left2);
    root.setRight(right3);
    left2.setLeft(new Node<Integer>(4));
    left2.setRight(new Node<Integer>(5));

    right3.setLeft(new Node<Integer>(6));
    right3.setRight(new Node<Integer>(7));
  }

  public void printInOrder() {
    printInOrder(root);
    System.out.println();
  }

  public void printPreOrder() {
    printPreOrder(root);
    System.out.println();
  }

  public void printPostOrder() {
    printPostOrder(root);
    System.out.println();
  }

  public void printReverseOrder() {
    printReverseOrder(root);
    System.out.println();
  }

  private void printInOrder(Node<Integer> current) {
    if (current != null){
	    printInOrder(current.getLeft());
	    System.out.print(current.get() + " ");
	    printInOrder(current.getRight());
    }
  }

  private void printPreOrder(Node<Integer> current) {
    if (current != null) {
      System.out.print(current.get() + " ");
      printPreOrder(current.getLeft());
      printPreOrder(current.getRight());
    }
  }

  private void printPostOrder(Node<Integer> current) {
    if (current != null) {
      printPostOrder(current.getLeft());
      printPostOrder(current.getRight());
      System.out.print(current.get() + " ");
    }
  }

  private void printReverseOrder(Node<Integer> current) {
    if (current != null) {
      printReverseOrder(current.getRight());
      System.out.print(current.get() + " ");
      printReverseOrder(current.getLeft());
    }
  }

  private class Node<E> {
    private Integer data;
    private Node<Integer> left;
    private Node<Integer> right;

    public Node(Integer data) {
      this.data = data;
      left = null;
      right = null;
    }

    public Integer get() {
      return data;
    }

    public Node<Integer> getLeft() {
      return left;
    }

    public Node<Integer> getRight() {
      return right;
    }

    public void setLeft(Node<Integer> left) {
      this.left = left;
    }

    public void setRight(Node<Integer> right) {
      this.right = right;
    }
  }
}
