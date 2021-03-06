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

  public void remove(int index) {
    remove(getNode(index));
  }

  public void remove(T data) {
    Node<T> current = head.next();

    while (current != null) {
      if (data.equals(current.getData())) {
        remove(current);
        break;
      }

      current = current.next();
    }
  }

  private void remove(Node<T> current) {
    Node<T> before = current.prev();
    Node<T> after = current.next();

    before.setNext(after);
    after.setPrev(before);

    if (size > 0)
      size--;
  }

  public void add(int index, T data) {
    Node<T> after = getNode(index);
    Node<T> before = after.prev();
    Node<T> newNode = new Node<T>(data);

    before.setNext(newNode);
    after.setPrev(newNode);
    newNode.setPrev(before);
    newNode.setNext(after);

    size++;
  }

  public void set(int index, T data) {
    getNode(index).setData(data);
  }

  public int size() {
    return size;
  }

  public void print() {
    print(head);
  }

  public void print(Node<T> node)  {

    System.out.println(node.getData());

    if (node.next() != null)
      print(node.next());
  }

  public void reverse() {
     for (int i = 0; i < size/2; i++) {
        T beg = get(i);
        T end = get(size-i-1);
        set(i,end);
        set(size-i-1,beg);
     }
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

    public void setData(T data) {
      this.data = data;
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
