package day05;

public class MaxBinaryHeap {
    private int[] heap;
    private int capacity;
    private int size;

    public MaxBinaryHeap(int capacity) {
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

        while (currentIndex > 1 && heap[currentIndex] > heap[currentIndex/2]) {
            swap(currentIndex, currentIndex/2);
            currentIndex = currentIndex / 2;
        }
    }

    public int deleteMax() {
        if (size == 0) {
            System.out.println("Heap is empty. Cannot extract maximum element.");
            return -1;
        }

        int max = heap[1];

        heap[1] = heap[size];
        size--;

        heapify(1);

        return max;
    }

    private void heapify(int index) {
        int leftChild = 2 * index;
        int rightChild = 2 * index + 1;
        int largest = index;

        if (leftChild <= size && heap[leftChild] > heap[largest]) {
            largest = leftChild;
        }

        if (rightChild <= size && heap[rightChild] > heap[largest]) {
            largest = rightChild;
        }

        if (largest != index) {
            swap(index, largest);
            heapify(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
