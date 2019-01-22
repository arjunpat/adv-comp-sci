public class DLList<T> {
  private Node<T> head = new Node<T>(null);
  private Node<T> tail = new Node<T>(null);
  private int size = 0;

  public DLList() {
    head.setNext(tail);
    head.setPrev(null);
    tail.setPrev(head);
    tail.setNext(null);
  }

  public void add(T data) {
    Node<T> newNode = new Node<T>(data);
    Node<T> currentLast = tail.prev();

    currentLast.setNext(newNode);
    newNode.setPrev(currentLast);
    newNode.setNext(tail);
    tail.setPrev(newNode);

    size++;
  }

  private Node<T> getNode(int index) {
    Node<T> current;

    if (index < (size / 2)) {
      current = head;

      for (int i = 0; i <= index; i++) {
        current = current.next();
      }

    } else {
      current = tail;

      for (int i = size - 1; i >= index; i--) {
        current = current.prev();
      }

    }

    return current;
  }

  public T get(int index) {
    return getNode(index).getData();
  }

  public String toString() {
		String str = "[";
		Node<T> current = head.next();

    for (int i = 0; i < size; i++) {
      str += current.getData().toString();

      current = current.next();

      if (i != size - 1) {
        str += ", ";
      }
    }

    return str + "]";
  }

  public void add(int index, T data) {
    Node<T> newNode = new Node<T>(data);
    Node<T> before = head;

    for (int i = 0; i < index; i++) {
      before = before.next();
    }

    Node<T> after = before.next();

    before.setNext(newNode);
    after.setPrev(newNode);
    newNode.setPrev(before);
    newNode.setNext(after);

    size++;
  }

  public int size() {
    return size;
  }

  private class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> prev;

    public Node(T data) {
      this.data = data;
    }

    public T getData() {
      return data;
    }

    public Node<T> next() {
      return next;
    }

    public Node<T> prev() {
      return prev;
    }

    public void setNext(Node<T> next) {
      this.next = next;
    }

    public void setPrev(Node<T> prev) {
      this.prev = prev;
    }
  }
}
