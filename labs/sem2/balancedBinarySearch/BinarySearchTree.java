import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BinarySearchTree<E extends Comparable<E>> implements Serializable {
	private Node<E> root;
	private String str = "";
	private int passes;

	public BinarySearchTree() {}

	public void draw(Graphics g, int height, int width) {
		int lineHeight = height / (getHeight() + 2);

		g.setFont(new Font("Tahoma", Font.PLAIN, 18));
		g.setColor(Color.BLACK);
		draw(g, root, width, width / 2, 0, lineHeight);
	}

	private void draw(Graphics g, Node<E> current, int width, int x, int y, int dy) {
		g.drawString(root.get().toString(), x, y);

		int dx = x / 2;

		if (root.getLeft() != null) {
			int ix = x - dx;
			g.drawLine(x, y, ix, y + dy);
			draw(g, current, width, ix, y + dy, dy);
		}

		if (root.getRight() != null) {
			int ix = x + dx;
			g.drawLine(x, y, ix, y + dy);
			draw(g, current, width, ix, y + dy, dy);
		}
	}

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
			str += current.get().toString() + " ";
			toString(current.getRight());
		}
	}

	private List<E> getArr() {
		List<E> arr = new ArrayList<E>();
		getArr(root, arr);

		Collections.sort(arr);
		return arr;
	}

	private void getArr(Node<E> current, List<E> arr) {
		if (current != null) {
			getArr(current.getLeft(), arr);
			arr.add(current.get());
			getArr(current.getRight(), arr);
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

  public Node<E> getNode(E data) {
		passes = 0;
		return getNode(data, root);
	}

	private Node<E> getNode(E data, Node<E> current) {
		passes++;
		if (current.get().equals(data)) {
			return current;
		}

		if (current.get().compareTo(data) > 0) {
			if (current.getLeft() == null) {
				return null;
			}

			return getNode(data, current.getLeft());
		} else  {
			if (current.getRight() == null) {
				return null;
			}

			return getNode(data, current.getRight());
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

  public int getLevel(E data) {
    Node<E> current = getNode(data);
    if (current == null) {
      return -1;
    } /*else if (current == root) {
      return 1;
    }*/else {
      return (getHeight() - getHeight(current, -1)) + 1;
    }
  }

  public int getLevels() {
    return getHeight() + 1;
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

  public int getNodes() {
    return getNodes(root, 0);
  }

  public int getNodes(E data) {
    Node<E> current = getNode(data);
    if (current == null) {
      return 0;
    } else {
      return getNodes(current, 0);
    }
  }

  private int getNodes(Node<E> current, int num) {
    if (current == null) {
      return num;
    } else {
      num++;
      num = getNodes(current.getLeft(), num);
      num = getNodes(current.getRight(), num);

      return num;
    }
  }

	public boolean isBalanced() {
		int left = 0;
		int right = 0;
		if (root.getLeft() != null) {
			left = getHeight(root.getLeft(), 0);
		}

		if (root.getRight() != null) {
			right = getHeight(root.getRight(), 0);
		}

		if (Math.abs(right - left) > 1) {
			return false;
		}

		int leftNodes = getNodes(root.getLeft(), 0);
		int rightNodes = getNodes(root.getRight(), 0);

		int height = getHeight();
		int nodes = getNodes();
		if (
			Math.pow(2, height) - 1 > nodes && nodes > Math.pow(2, height + 1) - 1
		) {
			return false;
		}

		return true;
	}

	public void balance() {
		List<E> arr = getArr();
		root = null;
		balance(arr);
	}

	private void balance(List<E> arr) {
		int mid = (int)Math.ceil(arr.size() / 2);
		add(arr.get(mid));

		if (arr.size() > 2) {
			List<E> first = arr.subList(0, mid);
			List<E> second = arr.subList(mid + 1, arr.size());

			balance(first);
			balance(second);
		}
	}

	private class Node<E> implements Serializable {
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
