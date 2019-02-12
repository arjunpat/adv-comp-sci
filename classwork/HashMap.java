public class HashMap<K, V> {
  private DLList<V>[] table;
  private DLList<K> keys;

  public HashMap() {
    table = new DLList[10000];
    keys = new DLList<K>();

    for (int i = 0; i < table.length; i++) {
      table[i] = new DLList<V>();
    }
  }

  public void put(K key, V value) {
    table[key.hashCode()].add(value);
    if (!keys.contains(key))
      keys.add(key);
  }

  public DLList<V> get(K key) {
    return table[ key.hashCode() ];
  }

  public DLList<K> getKeys() {
    return keys;
  }

  public void remove(K key) {
    table[key.hashCode()] = new DLList<V>();
  }

  public void remove(K key, V value) {
    DLList<V> list = table[key.hashCode()];

    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).equals(value)) {
        list.remove(i);
      }
    }
  }

  public String toString() {
    String str = "[";

    for (int i = 0; i < table.length; i++) {
      if (table[i].size() != 0) {
        str += "\n\t" + getStudent(i) + " -> " + table[i].toString();
      }
    }

    return str + "\n]";
  }

  public String getStudent(int hash) {
    Student student = new Student("", hash);
    for (int i = 0; i < keys.size(); i++) {
      if (keys.get(i).equals(student)) {
        return keys.get(i).toString();
      }
    }

    return "";
  }
}
