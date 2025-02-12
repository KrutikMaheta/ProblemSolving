//  Search the number in the given sorted array. If there are multiple occurrences then return first index.

package ai_searching;

public class Aa_SearchNum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 5, 5, 6, 6, 8};
        System.out.println(searchNum(arr, 5));
    }

    private static int searchNum(int[] arr, int X) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == X && (mid == 0 || arr[mid - 1] != X)) {
                return mid;
            } else if (arr[mid] < X) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
