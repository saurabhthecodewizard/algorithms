package day03.sort;

public class Insertion {

    public static void sort(int[] arr) {
        int length = arr.length;

        for (int i = 0; i < length; i++)
            for (int j = i; j > 0; j--)
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                } else
                    break;
    }
}
