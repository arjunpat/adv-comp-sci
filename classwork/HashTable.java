public class HashTable<E> {
  private DLList<E>[] table;

  public HashTable() {
    table = new DLList[10];

    for (int i = 0; i < table.length; i++) {
      table[i] = new DLList<E>();
    }
  }

  public void add(E add) {

    if (!contains(add)) {
      int index = getHashCode(add);

      table[index].add(add);
    }
  }

  public boolean contains(E val) {
    DLList<E> list = table[getHashCode(val)];

    for (int i = 0; i < list.size(); i++) {
      if (val.equals(list.get(i))) {
        return true;
      }
    }

    return false;
  }

  public void remove(E val) {
    table[getHashCode(val)].remove(val);
  }

  public int getHashCode(E add) {
    return add.hashCode() % 10;
  }

  public String toString() {
    String str = "[";

    for (int i = 0; i < table.length; i++) {
      str += "\n    " + table[i].toString();
    }

    return str + "\n]";
  }
}
