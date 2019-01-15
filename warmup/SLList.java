import java.util.Iterator;

public class SLList<T> {
	private Node<T> first;

	public SLList() {}

	public T getFirst() {
		if (first == null)
			throw new IndexOutOfBoundsException();

		return first.getData();
	}

	public T getLast() {
		Node<T> current = first;

		while (current.hasNext()) {
			current = current.next();
		}

		return current.getData();
	}

	public void add(T val) {
		if (first == null) {
			first = new Node<T>(val);
		} else {
			Node<T> current = first;

			while (current.hasNext()) {
				current = current.next();
			}

			current.setNext(new Node<T>(val));
		}
	}

	public void add(int index, T val) {

		if (index == 0) {
			Node<T> newNode = new Node<T>(val);
			newNode.setNext(first);
			first = newNode;
			return;
		}

		Node<T> before = getNode(index - 1);

		Node<T> after = before.next();
		Node<T> current = new Node<T>(val);

		before.setNext(current);
		current.setNext(after);
	}

	public T get(int i) {
		return getNode(i).getData();
	}

	public int size() {
		Node<T> current = first;
		int size = 0;

		while (current != null) {
			size++;
			current = current.next();
		}

		return size;
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

	public boolean contains(T val) {
		Node<T> current = first;

		while (current != null) {
			if (current.getData().equals(val)) {
				return true;
			}

			current = current.next();
		}

		return false;
	}

	public int indexOf(T val) {
		Node<T> current = first;
		int i = 0;

		while (current != null) {
			if (current.getData().equals(val)) {
				return i;
			}

			current = current.next();
			i++;
		}

		return -1;
	}

	public void set(int index, T val) {
		Node<T> current = first;
		int i = 0;

		while (current != null) {
			if (i == index) {
				current.setData(val);
			}

			current = current.next();
			i++;
		}

	}

	public void remove(int i) {

		if (i == 0) {
			first = getNode(1);
		} else {
			Node<T> before = getNode(i - 1);
			Node<T> after = getNode(i + 1);

			before.setNext(after);
		}
	}

	public void remove(T val) {
		int i = indexOf(val);
		remove(i);
	}

	public void clear() {
		first = null;
	}

	public String toString() {
		String str = "[";
		int size = size();

		for (int i = 0; i < size; i++) {
			str += get(i).toString();

			if (i != size - 1)
				str += ", ";
		}

		return str + "]";
	}

	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node<T> current = first;

			public boolean hasNext() {
				return current != null;
			}

			public T next() {
				T data = current.getData();
				current = current.next();
				return data;
			}
		};
	}

	private class Node<T> {

		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
		}

		public T getData() {
			return data;
		}

		public void setData(T val) {
			data = val;
		}

		public Node<T> next() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public boolean hasNext() {
			return next != null;
		}
	}
}
