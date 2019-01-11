public class LinkedList<T> {

	private Node<T> first;

	public LinkedList() {}

	public T getFirst() {
		return first.getData();
	}

	public T getLast() {
		Node<T> current = first;

		while (true) {
			if (!current.hasNext()) {
				return current.getData();
			}
			current = current.next();
		}
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
		Node<T> current = first;

		for (int j = 0; j < i; j++) {

			if (current.hasNext()) {
				current = current.next();
			} else {
				throw new IndexOutOfBoundsException();
			}
		}

		return current.getData();
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
}
