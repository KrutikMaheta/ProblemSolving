package ai_searching;

// Case where we have applied binary search on non-sorted array.
public class Ad_FindPeakElement {

    public static void main(String[] args) {
        //int[] arr = { 10, 9, 8, 7, 1, 2, 3, 4, 5, 6 };
        //int[] arr = { 1, 5, 3, 2, 1, 6, 5, 7 };
        int[] arr = {1, 5, 3, 4, 1, 6, 5, 7};
        System.out.println(arr[findPeak(arr)]);
    }

    private static int findPeak(int[] arr) {
        int len = arr.length;
        int s = 0;
        int e = len - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if ((m + 1 >= len || arr[m] >= arr[m + 1]) && (m - 1 < 0 || arr[m] >= arr[m - 1]))
                return m;
            if (arr[m - 1] >= arr[m])
                e = m - 1;
            else
                s = m + 1;
        }
        return -1;
    }
}
