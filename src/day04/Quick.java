package day04;

public class Quick {

    public static void sort(int[] arr) {
        dijkstraThreeWay(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int j = partition(arr, low, high);
        sort(arr, low, j-1);
        sort(arr, j+1, high);
    }

    private static void dijkstraThreeWay(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int lt = low;
        int gt = high;

        int v = arr[low];
        int i = low;

        while (i <= gt) {
            if (arr[i] < v) {
                int temp = arr[lt];
                arr[lt] = arr[i];
                arr[i] = temp;
                lt++;
                i++;
            } else if (arr[i] > v) {
                int temp = arr[gt];
                arr[gt] = arr[i];
                arr[i] = temp;
                gt--;
            } else {
                i++;
            }
        }

        dijkstraThreeWay(arr, low, lt - 1);
        dijkstraThreeWay(arr, gt + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int i = low;
        int j = high+1;

        while (true) {
            while (arr[++i] < arr[low])
                if (i >= high)
                    break;
            while (arr[--j] > arr[low])
                if (j <= low)
                    break;
            if (i >= j)
                break;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }
}
