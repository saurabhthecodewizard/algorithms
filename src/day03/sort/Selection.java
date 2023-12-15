package day03.sort;

public class Selection {

    public static void sort(int[] arr) {
        int length = arr.length;

        for (int i = 0; i < length - 1; i++)
            for (int j = i + 1; j < length; j++)
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
    }
}
