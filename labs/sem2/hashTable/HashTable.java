public class HashTable<E> {
	private DLList<E>[] table;

	public HashTable() {
		table = new DLList[400];

		for (int i = 0; i < table.length; i++) {
			table[i] = new DLList<E>();
		}
	}

	public void add(E val) {
		int index = getHashCode(val);
		table[index].add(val);
	}

	private int getHashCode(E val) {
		return val.hashCode() % 400;
	}

	public DLList<E>[] getTable() {
		return table;
	}

	public DLList<E> get(E val) {
		int index = getHashCode(val);
		return table[index];
	}

	public String toString() {
		String str = "[";

		for (int i = 0; i < table.length; i++) {
			str += "\n    " + table[i].toString();
		}

		return str + "\n]";
	}
}