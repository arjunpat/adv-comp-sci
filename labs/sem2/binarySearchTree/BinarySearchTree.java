public class BinarySearchTree<E extends Comparable<E>> {
	private Node<E> root;
	private String str = "";
	private int passes;

	public BinarySearchTree() {}

	public int add(E data) {
		passes = 1;
		if (root == null) {
			root = new Node<E>(data);
			return passes;
		} else {
			add(data, root);
		}

		return passes;
	}

	private void add(E data, Node<E> current) {
		passes++;
		Node<E> newNode = new Node<E>(data);
		newNode.setParent(current);

		if (current.get().compareTo(data) < 0) {
			if (current.getRight() == null) {
				current.setRight(newNode);
			} else {
				add(data, current.getRight());
			}
		} else {
			if (current.getLeft() == null) {
				current.setLeft(newNode);
			} else {
				add(data, current.getLeft());
			}
		}
	}

	public String toString() {
		str = "";
		toString(root);

		return str;
	}

	private void toString(Node<E> current) {
		if (current != null) {
			toString(current.getLeft());
			str += current.get().toString() + "\n";
			toString(current.getRight());
		}
	}

	public String toStringPreOrder() {
		str = "";
		toStringPreOrder(root);

		return str;
	}

	public void toStringPreOrder(Node<E> current) {
		if (current != null) {
			str += current.get() + " ";
			toStringPreOrder(current.getLeft());
			toStringPreOrder(current.getRight());
		}
	}

	public boolean contains(E data) {
		return contains(data, root);
	}

	private boolean contains(E data, Node<E> current) {
		if (current.get().equals(data)) {
			return true;
		}

		if (current.get().compareTo(data) > 0) {
			if (current.getLeft() == null) {
				return false;
			}

			return contains(data, current.getLeft());
		} else  {
			if (current.getRight() == null) {
				return false;
			}

			return contains(data, current.getRight());
		}
	}

	public int getPasses() {
		return passes;
	}

	public E get(E data) {
		passes = 0;
		return get(data, root);
	}

	private E get(E data, Node<E> current) {
		passes++;
		if (current.get().equals(data)) {
			return current.get();
		}

		if (current.get().compareTo(data) > 0) {
			if (current.getLeft() == null) {
				return null;
			}

			return get(data, current.getLeft());
		} else  {
			if (current.getRight() == null) {
				return null;
			}

			return get(data, current.getRight());
		}
	}

	public void remove(E data) {
		if (contains(data)) {
			remove(data, root);
		}
	}

	private void remove(E data, Node<E> current) {
		Node<E> parent = current.getParent();

		if (current.get().equals(data)) {

			if (current.getLeft() == null && current.getRight() == null) {
				if (parent == null) {
					root = null;
					return;
				}

				if (parent.getRight().get().equals(data)) {
					parent.setRight(null);
				} else {
					parent.setLeft(null);
				}
			} else if (current.getLeft() == null && current.getRight() != null) {
				if (parent == null) {
					root = current.getRight();
					return;
				}


				if (parent.getRight().get().equals(data)) {
					parent.setRight(current.getRight());
				} else {
					parent.setLeft(current.getRight());
				}
			} else if (current.getLeft() != null && current.getRight() == null) {

				if (parent == null) {
					root = current.getLeft();
					return;
				}

				if (parent.getRight().get().equals(data)) {
					parent.setRight(current.getLeft());
				} else {
					parent.setLeft(current.getLeft());
				}
			} else if (current.getLeft() != null && current.getRight() != null) {
				Node<E> smallest = findSmallestAndDelete(data, current.getRight(), current);
				current.setData(smallest.get());
			}

		} else {

			if (current.get().compareTo(data) > 0) {
				remove(data, current.getLeft());
			} else  {
				remove(data, current.getRight());
			}

		}
	}

	public Node<E> findSmallestAndDelete(E data, Node<E> current, Node<E> parent) {
		if (current.getLeft() != null) {
			return findSmallestAndDelete(data, current.getLeft(), current);
		}

		if (parent.get().equals(data)) {
			parent.setRight(null);
		} else {
			parent.setLeft(null);
		}
		return current;
	}

	public int getHeight() {
		return getHeight(root, -1);
	}

	private int getHeight(Node<E> current, int num) {
		num++;

		if (current.getLeft() != null && current.getRight() != null) {
			int leftHeight = getHeight(current.getLeft(), num);
			int rightHeight = getHeight(current.getRight(), num);

			return Math.max(leftHeight, rightHeight);
		} else if (current.getLeft() != null && current.getRight() == null) {
			return getHeight(current.getLeft(), num);
		} else if (current.getLeft() == null && current.getRight() != null) {
			return getHeight(current.getRight(), num);
		}

		return num;
	}

	private class Node<E> {
		private E data;
		private Node<E> left;
		private Node<E> right;
		private Node<E> parent;

		public Node(E data) {
			this.data = data;
		}

		public E get() {
			return data;
		}

		public Node<E> getLeft() {
			return left;
		}

		public Node<E> getRight() {
			return right;
		}

		public Node<E> getParent() {
			return parent;
		}

		public void setLeft(Node<E> left) {
			this.left = left;
		}

		public void setRight(Node<E> right) {
			this.right = right;
		}

		public void setParent(Node<E> parent) {
			this.parent = parent;
		}

		public void setData(E data) {
			this.data = data;
		}
	}
}
