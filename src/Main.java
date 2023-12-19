import day03.sort.Bubble;
import day03.sort.Insertion;
import day03.sort.Knuth;
import day03.sort.Selection;
import day04.Merge;
import day04.Quick;
import day05.Heap;
import day06.BinarySearchTree;
import day06.BinarySearchTreeImpl;

import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        sortingAlgo();
        int[] arr = new int[]{5, 3, 7, 2, 4, 6, 8, 1, 9, 7};

        BinarySearchTree bst = new BinarySearchTreeImpl();
        for (int data : arr) {
            bst.insert(data);
        }

        bst.print();

        System.out.println();
        System.out.println("After deleting (9)");
        bst.delete(9);
        bst.print();

        System.out.println();
        System.out.println("After deleting (7)");
        bst.delete(7);
        bst.print();
//        In order traversal: 1 2 3 4 5 6 7 7 8 9
//        Pre order traversal: 5 3 2 1 4 7 6 7 8 9
//        Post order traversal: 1 2 4 3 7 6 9 8 7 5
    }

    private static void sortingAlgo() {
        int[] arr = new int[]{2, 2, 2, 2, 5, 2, 2, 2, 7, 1, 0, 8, 9, 6, 6, 6, 3, 4};
        int[] sortedArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
        System.out.println();

        Heap.sort(arr);

        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
        System.out.println();

        Knuth.shuffle(arr);

        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
        System.out.println();
    }
}