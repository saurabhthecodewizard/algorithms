package day09;

public class SeparateChainingHash<K, V> {
    private static final int M = 97;
    private final Node<K, V>[] symbolTable = (Node<K, V>[]) new Node[M];

    private static class Node<K, V> {
        private final K key;
        private V data;
        private final Node<K, V> next;

        Node(K key, V data) {
            this.key = key;
            this.data = data;
            this.next = null;
        }
    }

    private int hashCode(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public V get(K key) {
        int i = hashCode(key);
        for (Node<K, V> trav = symbolTable[i]; trav != null; trav = trav.next) {
            if (key.equals(trav.key)) {
                return trav.data;
            }
        }
        return null;
    }

    public void put(K key, V data) {
        int i = hashCode(key);
        for (Node<K, V> trav = symbolTable[i]; trav != null; trav = trav.next) {
            if (key.equals(trav.key)) {
                trav.data = data;
                return;
            }
        }
        symbolTable[i] = new Node<>(key, data);
    }
}
