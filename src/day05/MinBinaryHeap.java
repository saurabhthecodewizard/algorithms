package day05;

public class MinBinaryHeap {

    private int[] heap;
    private int size;
    private int capacity;

    public MinBinaryHeap(int capacity) {
        this.heap = new int[capacity + 1];
        this.size = 0;
        this.capacity = capacity;
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert more elements.");
            return;
        }

        size++;
        heap[size] = value;

        int currentIndex = size;

        while (currentIndex > 1 && heap[currentIndex] < heap[currentIndex / 2]) {
            swap(currentIndex, currentIndex / 2);
            currentIndex = currentIndex / 2;
        }
    }

    public int deleteMin() {
        if (size == 0) {
            System.out.println("Heap is empty. Cannot extract minimum element.");
            return -1; // Assuming -1 represents an invalid value in this context.
        }

        int min = heap[1];

        heap[1] = heap[size];
        size--;
        heapify(1);

        return min;
    }

    public void heapify(int index) {
        int leftChild = index * 2;
        int rightChild = index * 2 + 1;
        int smallest = index;

        if (smallest <= size && heap[smallest] > heap[leftChild]) {
            smallest = leftChild;
        }

        if (smallest <= size && heap[smallest] > heap[rightChild]) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(smallest, index);
            heapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
