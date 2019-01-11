public class LinkedList<T> {

	private Node<T> first;

	public LinkedList() {}

	public T getFirst() {
		return first.getData();
	}

	public T getLast() {
		return get(size() - 1);
	}

	public void add(T val) {

		if (first == null) {
			first = new Node<T>(val);
			return;
		}

		Node<T> current = first;

		while (true) {
			if (!current.hasNext()) {
				current.setNext(new Node<T>(val));
				break;
			}

			current = current.next();
		}
	}

	public T get(int i) {
		return getNode(i).getData();
	}

  private Node<T> getNode(int i) {
    Node<T> current = first;

		for (int j = 0; j < i; j++) {

			if (current.hasNext()) {
				current = current.next();
			} else {
				throw new IndexOutOfBoundsException();
			}
		}

		return current;
  }

	public int size() {

		Node<T> current = first;
		int size = 0;

		while (true) {
			if (current != null) {
				size++;
				current = current.next();
			} else {
				return size;
			}
		}

	}

  public void remove(int i) {
    Node<T> before = getNode(i - 1);
    Node<T> after = getNode(i + 1);

    before.setNext(after);
  }
}
