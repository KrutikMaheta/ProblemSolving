package ai_searching;

public class Ac_LowerBound {

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 5, 7, 7, 7, 8, 8, 13, 15, 18, 21};
        System.out.println(findLowerBound(arr, 6));
        System.out.println(findLowerBoundMethod2(arr, 6));
    }


    //  Approach1: If mid is my answer, then what should the condition look like
    private static int findLowerBound(int[] arr, int X) {
        int len = arr.length;
        int s = 0;
        int e = len - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] == X && (m == 0 || arr[m] != arr[m - 1]))
                return m;
            if (arr[m] < X && (m + 1 == len || arr[m + 1] > X))
                return m;
            if (arr[m] >= X)
                e = m - 1;
            else
                s = m + 1;
        }

        return -1;
    }

    //  Approach2: Keep searching for the maximum index which is lower than X instead of searching X.
    //  Maintain answer, keep updating the answer as we binary search.
    private static int findLowerBoundMethod2(int[] arr, int X) {
        int s = 0;
        int e = arr.length - 1;
        int max_index = -1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] < X) {
                s = m + 1;
                max_index = Integer.max(max_index, m);
            } else {
                e = m - 1;
            }
        }
        if (arr[max_index + 1] == X) {
            return max_index + 1;
        }
        return max_index;
    }

}
