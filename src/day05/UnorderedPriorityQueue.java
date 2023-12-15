package day05;

public class UnorderedPriorityQueue {
    private int[] pq;
    private int N;

    public UnorderedPriorityQueue(int capacity) {
        N = 0;
        pq = new int[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(int key) {
        pq[N++] = key;
    }

    public int deleteMax() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++)
            Math.max(max, pq[i]);

        int temp = max;
        max = pq[N - 1];
        pq[N - 1] = temp;

        return pq[--N];
    }
}
