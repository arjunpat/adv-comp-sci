public class HashTable<E> {
	private DLList<E>[] table;

	public HashTable() {
		table = new DLList[400];

		for (int i = 0; i < table.length; i++) {
			table[i] = new DLList<E>();
		}
	}

	public void add(E val) {
		int index = getHashCode(e);
		table[index].add(val);
	}

	private int getHashCode(E val) {
		return val.hashCode() % 400;
	}

	public String toString() {
		String str = "[";

		for (int i = 0; i < table.length; i++) {
			str += "\n    " + table[i].toString();
		}

		return str + "\n]";
	}
}