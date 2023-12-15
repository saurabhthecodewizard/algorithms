package day04;

public class Merge {

    public static void sort(int[] arr) {
        int[] aux = new int[arr.length];
        sort(arr, aux, 0, arr.length - 1);
    }

    public static void sortBottomUp(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i = i + i)
            for (int low = 0; low < length - i; low += i + i)
                merge(arr, low, low + i - 1, Math.min(low + i + i - 1, length - 1));
    }

    private static void sort(int[] arr, int[] aux, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(arr, aux, low, mid);
        sort(arr, aux, mid + 1, high);
        //Do not merge if already sorted
        if (arr[mid+1] > arr[mid]) {
            return;
        }
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int[] aux, int low, int mid, int high) {

        if (high + 1 - low >= 0) System.arraycopy(arr, low, aux, low, high + 1 - low);

        int j = low;
        int k = mid + 1;
        for (int i = low; i <= high; i++) {
            if (j > mid) {
                arr[i] = aux[k++];
            } else if (k > high) {
                arr[i] = aux[j++];
            } else if (aux[j] < aux[k]) {
                arr[i] = aux[j++];
            } else {
                arr[i] = aux[k++];
            }
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        System.out.println("In merge");

        int[] aux = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int auxIndex = 0;

        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                aux[auxIndex] = arr[left++];
            } else {
                aux[auxIndex] = arr[right++];
            }
            auxIndex++;
        }

        while (left <= mid) {
            aux[auxIndex++] = arr[left++];
        }

        while (right <= high) {
            aux[auxIndex++] = arr[right++];
        }

        auxIndex = 0;
        left = low;
        while (left <= high) {
            arr[left++] = aux[auxIndex++];
        }
    }
}
