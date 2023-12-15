package day03.sort;

public class Bubble {

    public static void sort(int[] arr) {
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++)
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
        }
    }
}
