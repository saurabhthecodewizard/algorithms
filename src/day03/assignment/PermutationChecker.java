package day03.assignment;
import java.util.Arrays;

public class PermutationChecker {
    public static boolean arePermutations(int[] array1, int[] array2) {
        if (array1 == null || array2 == null || array1.length != array2.length) {
            return false;
        }

        Arrays.sort(array1);
        Arrays.sort(array2);

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }

        return true;
    }
}

