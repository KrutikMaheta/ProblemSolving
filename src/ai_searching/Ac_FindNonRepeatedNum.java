package ai_searching;

public class Ac_FindNonRepeatedNum {

    public static void main(String[] args) {
        // int arr[] = { 0, 0, 4, 5, 5, 7, 7, 8, 8 };
        // int arr[] = { 0, 0, 4, 4, 5, 5, 7, 7, 8 };
        int arr[] = {0, 4, 4, 5, 5, 7, 7, 8, 8};
        System.out.println(findNonRepeatedNum(arr));
    }

    private static int findNonRepeatedNum(int[] arr) {
        int N = arr.length;
        int s = 0;
        int e = N - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            if ((m + 1 >= N || arr[m + 1] != arr[m]) &&
                    (m - 1 < 0 || arr[m - 1] != arr[m])) {
                return m;
            }

            int first = m;
            if (m - 1 >= 0 && arr[m - 1] == arr[m]) {
                first = m - 1;
            }
            if (first % 2 == 1) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return -1;
    }

}
