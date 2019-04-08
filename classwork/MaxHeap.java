
public class MaxHeap<E extends Comparable<E>> {
  private E[] heap;
  private int size;

  @SuppressWarnings("unchecked")
  public MaxHeap() {
    size = 0;
    heap = (E[]) new Comparable[1000];
  }

  public void add(E data) {
    int current = size;
    heap[current] = data;

    while (current > 0) {
      int parent = (current - 1) / 2;
      E a = heap[parent];
      E b = heap[current];
      if (a.compareTo(b) < 0) {
        heap[parent] = b;
        heap[current] = a;
        current = parent;
      } else {
        break;
      }
    }

    size++;
  }

  public String toString() {
    int level = 0;
    String str = "";

    for (int i = 0; i < size; i++) {
      int l = (int)(Math.log(i + 1) / Math.log(2)) + 1;

      if (l != level) {
        level = l;
        str += "\n" + level + ": " + heap[i] + ", ";
      } else {
        str += heap[i] + ", ";
      }
    }

    return str + "\n";
  }

  public E poll() {
    E top = heap[0];

    for (int i = 0; i < size; i++) {
      if (heap[i + 1] == null) {
        break;
      }
      heap[i] = heap[i + 1];
    }

    size--;

    swapDown(0);

    return top;
  }

  private void swapDown(int index) {
    if (size < 1) {
      return;
    }

    E top = heap[index];
    int leftChild = (int)Math.pow(index, 2) + 1;
    int rightChild = (int)Math.pow(index, 2) + 2;

    if (leftChild < size && rightChild < size) {
      E left = heap[leftChild];
      E right = heap[rightChild];

      if (left.compareTo(top) > 0 && right.compareTo(top) > 0) {
        if (left.compareTo(right) > 0) {
          heap[leftChild] = top;
          heap[index] = left;
          swapDown(leftChild);
        } else {
          heap[rightChild] = top;
          heap[index] = right;
          swapDown(rightChild);
        }
      } else if (left.compareTo(top) > 0 && right.compareTo(top) < 0) {
        heap[leftChild] = top;
        heap[index] = left;
        swapDown(leftChild);
      } else if (left.compareTo(top) < 0 && right.compareTo(top) > 0) {
        heap[rightChild] = top;
        heap[index] = right;
        swapDown(rightChild);
      }

    } else if (leftChild < size) {
      E left = heap[leftChild];
      if (left.compareTo(top) > 0) {
          heap[index] = left;
          heap[leftChild] = top;
          swapDown(leftChild);
      }
    } else if (rightChild < size) {
      E right = heap[rightChild];
      if (right.compareTo(top) > 0) {
        heap[index] = right;
        heap[rightChild] = top;
        swapDown(rightChild);
      }
    }
  }

  public int size() {
    return size;
  }
}
