public class MyItem<K, V> {

	private K key;
	private V value;

	public MyItem(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public String toString() {
		return "Key: " + key + " Value: " + value;
	}

}