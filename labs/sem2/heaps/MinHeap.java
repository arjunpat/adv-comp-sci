import java.util.LinkedList;

public class MinHeap<E extends Comparable<E>> {
	private LinkedList<E> heap;

	public MinHeap() {
		heap  = new LinkedList<E>();
	}

	public void add(E val) {
		heap.add(val);
		int current = heap.size() - 1;

		while (current > 0) {
			int parent = (current - 1) / 2;
			E a = heap.get(parent);
			E b = heap.get(current);
			if (a.compareTo(b) > 0) {
				heap.set(parent, b);
				heap.set(current, a);
				current = parent;
			} else {
				break;
			}
		}
	}

	public E poll() {
		E top = heap.remove(0);

		swapDown(0);

		return top;
	}

	public E peek() {
		if (heap.size() > 0) {
			return heap.get(0);
		}

		return null;
	}

	private void swapDown(int index) {
		if (heap.size() < 1) {
			return;
		}

		E top = heap.get(index);
		int leftChild = (int)Math.pow(index, 2) + 1;
		int rightChild = (int)Math.pow(index, 2) + 2;
		int size = heap.size();

		if (leftChild < size && rightChild < size) {
			E left = heap.get(leftChild);
			E right = heap.get(rightChild);

			if (left.compareTo(top) < 0 && right.compareTo(top) < 0) {
				if (left.compareTo(right) < 0) {
					heap.set(leftChild, top);
					heap.set(index, left);
					swapDown(leftChild);
				} else {
					heap.set(rightChild, top);
					heap.set(index, right);
					swapDown(rightChild);
				}
			} else if (left.compareTo(top) < 0 && right.compareTo(top) > 0) {
				heap.set(leftChild, top);
				heap.set(index, left);
				swapDown(leftChild);
			} else if (left.compareTo(top) > 0 && right.compareTo(top) < 0) {
				heap.set(rightChild, top);
				heap.set(index, right);
				swapDown(rightChild);
			}

		} else if (leftChild < size) {
			E left = heap.get(leftChild);
			if (left.compareTo(top) < 0) {
					heap.set(index, left);
					heap.set(leftChild, top);
					swapDown(leftChild);
			}
		} else if (rightChild < size) {
			E right = heap.get(rightChild);
			if (right.compareTo(top) < 0) {
				heap.set(index, right);
				heap.set(rightChild, top);
				swapDown(rightChild);
			}
		}
	}

	public void remove(E data) {
		for (int i = 0; i < heap.size(); i++) {
			if (heap.get(i).equals(data)) {
				heap.remove(i);
				swapDown(i);
				break;
			}
		}
	}

	public String toString() {
		int level = 0;
		String str = "";

		for (int i = 0; i < heap.size(); i++) {
			int l = (int)(Math.log(i + 1) / Math.log(2)) + 1;

			if (l != level) {
				level = l;
				str += "\n" + level + ": " + heap.get(i) + ", ";
			} else {
				str += heap.get(i) + ", ";
			}
		}

		return str + "\n";
	}

	public int size() {
		return heap.size();
	}
}
