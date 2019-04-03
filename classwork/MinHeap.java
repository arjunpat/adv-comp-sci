import java.util.ArrayList;

public class MinHeap<E extends Comparable<E>> {
  private ArrayList<E> heap;

  public MinHeap() {
    heap  = new ArrayList<E>();
  }

  public void add(E val) {
    heap.add(val);
    int current = heap.size() - 1;

    while (current > 0) {
      int parent = (current - 1) / 2;
      E a = heap.get(parent);
      E b = heap.get(current);
      if (a.compareTo(b) < 0) {
        heap.set(parent, b);
        heap.set(current, a);
        current = parent;
      } else {
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
}
