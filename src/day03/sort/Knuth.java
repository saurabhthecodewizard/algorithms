package day03.sort;

import java.util.Random;

public class Knuth {

    public static void shuffle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int random = new Random().nextInt(i + 1);
            int temp = arr[random];
            arr[random] = arr[i];
            arr[i] = temp;
        }
    }
}
