import java.util.Iterator;

public class SLList<T> {
	private Node<T> head;

	public SLList() {}

	public T getFirst() {
		if (head == null)
			throw new IndexOutOfBoundsException();

		return head.getData();
	}

	public T getLast() {
		Node<T> current = head;

		while (current.hasNext()) {
			current = current.next();
		}

		return current.getData();
	}

	public void add(T data) {
		if (head == null) {
			head = new Node<T>(data);
		} else {
			Node<T> current = head;

			while (current.hasNext()) {
				current = current.next();
			}

			current.setNext(new Node<T>(data));
		}
	}

	public void add(int index, T data) {
		Node<T> newNode = new Node<T>(data);

		if (index == 0) {
			newNode.setNext(head);
			head = newNode;
			return;
		}

		Node<T> before = getNode(index - 1);
		Node<T> after = before.next();

		before.setNext(newNode);
		newNode.setNext(after);
	}

	private Node<T> getNode(int index) {
		Node<T> current = head;

		while (current != null) {
			if (index == 0) {
				return current;
			}

			index--;

			current = current.next();
		}

		return null;
	}

	public T get(int index) {
		return getNode(index).getData();
	}

	public int size() {
		Node<T> current = head;
		int size = 0;

		while (current != null) {
			size++;
			current = current.next();
		}

		return size;
	}

	public boolean remove(T data) {
		if (head != null) {

			Node<T> current = head;

			if (head.getData().equals(data)) {
				head = head.next();
				return true;
			}

			while (current.hasNext()) {
				if (current.next().getData().equals(data)) {
					current.setNext(current.next().next());
					return true;
				}
				current = current.next();
			}

		}

		return false;
	}


	public boolean contains(T data) {
		return indexOf(data) > -1;
	}

	public int indexOf(T data) {
		Node<T> current = head;
		int i = 0;

		while (current != null) {
			if (current.getData().equals(data)) {
				return i;
			}

			current = current.next();
			i++;
		}

		return -1;
	}

	public void set(int index, T data) {
		getNode(index).setData(data);
	}

	public void remove(int i) {

		if (i == 0) {
			head = getNode(1);
		} else {
			Node<T> before = getNode(i - 1);
			Node<T> after = getNode(i + 1);

			before.setNext(after);
		}
	}

	public void clear() { head = null; }

	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node<T> current = head;

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

	public String toString() {
		String str = "[";

		Node<T> current = head;

		while (true) {

			str += current.getData().toString();

			current = current.next();

			if (current != null) {
				str += ", ";
			} else {
				break;
			}
		}

		return str + "]";
	}

	private class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
		}

		public boolean hasNext() {
			return next != null;
		}

		public Node<T> next() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}
	}
}