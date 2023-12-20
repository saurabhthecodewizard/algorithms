package day09;

public class LinearProbingHash<K, V> {
    private int M = 30001;
    private V[] values = (V[]) new Object[M];
    private K[] keys = (K[]) new Object[M];

    private int hashCode(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value) {
        int i;
        for (i = hashCode(key); keys[i] != null; i = (i+1) % M) {
            if (keys[i].equals(key)) {
                break;
            }
            keys[i] = key;
            values[i] = value;
        }
    }

    public V get(K key) {
        int i;
        for (i = hashCode(key); keys[i] != null; i = (i+1) % M) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }

        return null;
    }
}
