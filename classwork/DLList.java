public class DLList<E extends Comparable<E>> {
  private Node<E> dummy;
  private int size = 0;

  public DLList() {
    dummy = new Node<E>(null);
    dummy.setNext(dummy);
    dummy.setPrev(dummy);
  }

  public void add(E data) {
    Node<E> newNode = new Node<E>(data);

    if (size == 0) {
      dummy.setNext(newNode);
      dummy.setPrev(newNode);
      newNode.setNext(dummy);
      newNode.setPrev(dummy);
      size = 1;
    } else {

      Node<E> current = dummy.next();

      while (current.getData() != null) {
        if (current.getData().compareTo(data) > 0) {
          break;
        }
        current = current.next();
      }

      Node<E> before = current.prev();
      before.setNext(newNode);
      newNode.setPrev(before);
      newNode.setNext(current);
      current.setPrev(newNode);

      size++;

    }
  }

  private Node<E> getNode(int index) {
    Node<E> current = dummy.next();

    while (index != 0) {
      current = current.next();
      index--;
    }

    return current;
  }

  public E get(int index) {
    return getNode(index).getData();
  }

  public void remove(int index) {
    Node<E> toRemove = getNode(index);
    Node<E> before = toRemove.prev();
    Node<E> after = toRemove.next();

    before.setNext(after);
    after.setPrev(before);

    size--;
  }

  public void remove(E data) {
    Node<E> current = dummy.next();
    int index = 0;

    while (current.getData().compareTo(data) != 0) {
      current = current.next();
      index++;
    }

    remove(index);
  }

  public void set(int index, E data) {
    remove(index);
    add(data);
  }

  public int size() {
    return size;
  }

  public String toString() {
    String str = "[";

		Node<E> current = dummy.next();

		while (true) {

			str += current.getData().toString();

			current = current.next();

			if (current.getData() != null) {
				str += ", ";
			} else {
				break;
			}
		}

		return str + "]";
  }

  private class Node<E> {
    private Node<E> next, prev;
    private E data;

    public Node(E data) {
      this.data = data;
    }

    public void setPrev(Node<E> prev) {
      this.prev = prev;
    }

    public void setNext(Node<E> next) {
      this.next = next;
    }

    public E getData() {
      return data;
    }

    public void setData(E data) {
      this.data = data;
    }

    public Node<E> prev() {
      return prev;
    }

    public Node<E> next() {
      return next;
    }
  }

  public static void main(String[] args) {
    DLList<String> hello = new DLList<String>();

    hello.add("wassup");
    hello.add("how are you");
    hello.add("welcome");
    hello.add("a");
    System.out.println(hello);

    hello.remove(3);
    hello.add("YOUR MOM");
    System.out.println(hello);

    hello.remove("YOUR MOM");
    System.out.println(hello);

    hello.set(0, "b");
    System.out.println(hello);
    System.out.println(hello.size());

  }
}
