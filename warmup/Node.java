
public class Node<T> {

	private T data;
	private Node<T> next;

	public Node(T data) {
		this.data = data;
	}

	public Node() {}

	public T getData() {
		return data;
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

	public boolean hasData() {
		return data != null;
	}

	public void setData(T data) {
		this.data = data;
	}
}