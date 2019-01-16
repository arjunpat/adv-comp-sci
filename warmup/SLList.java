public class SLList<T> {
	private Node<T> head;

	public SLList() {

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

	public void remove(T data) {
		if (head != null) {

			Node<T> current = head;

			if (head.getData().equals(data)) {
				head = head.next();
				return;
			}

			while (current.hasNext()) {
				if (current.next().getData().equals(data)) {
					current.setNext(current.next().next());
					break;
				}
				current = current.next();
			}

		}
	}

	public String toString() {
		String str = "[";

		Node<T> current = head;

		while (true) {

			str += current.getData().toString();

			current = current.next();

			if (current != null) {
				str += ", ";
			} else
				break;
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
	}

}