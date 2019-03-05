public class BinarySearchTree<E extends Comparable<E>> {
  private Node<E> root;

  public BinarySearchTree() {}

  public void add(E data) {
    if (root == null) {
      root = new Node<E>(data);
      return;
    } else {
      add(data, root);
    }
  }

  private void add(E data, Node<E> current) {
    if (current.get().compareTo(data) < 0) {
      if (current.getRight() == null) {
        current.setRight(new Node<E>(data));
      } else {
        add(data, current.getRight());
      }
    } else {
      if (current.getLeft() == null) {
        current.setLeft(new Node<E>(data));
      } else {
        add(data, current.getLeft());
      }
    }
  }

  private String str = "";

  public String toString() {
    str = "";
    toString(root);

    return str;
  }

  private void toString(Node<E> current) {
    if (current != null) {
	    toString(current.getLeft());
	    str += current.get() + " ";
	    toString(current.getRight());
    }
  }

  private class Node<E> {
    private E data;
    private Node<E> left;
    private Node<E> right;

    public Node(E data) {
      this.data = data;
    }

    public E get() {
      return data;
    }

    public Node<E> getLeft() {
      return left;
    }

    public Node<E> getRight() {
      return right;
    }

    public void setLeft(Node<E> left) {
      this.left = left;
    }

    public void setRight(Node<E> right) {
      this.right = right;
    }
  }
}
