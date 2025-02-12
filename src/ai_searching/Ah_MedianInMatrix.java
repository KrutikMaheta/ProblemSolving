package ai_searching;

public class Ah_MedianInMatrix {

    public static void main(String[] args) {
        //int arr[][] = { { 2, 5, 9, 13, 16 }, { 10, 11, 15, 18, 20 }, { 5, 13, 20, 21, 22 }, { 1, 6, 19, 24, 30 } };
        int arr[][] = {{1, 2, 3}, {10, 15, 17}, {4, 8, 12}};
        //int arr[][] = {{-5, -4, -2}, {-3, -1, 0}, {1, 2, 3}}; // -1
        System.out.println(findMedian(arr, arr.length, arr[0].length));
    }

    /*
     * Possible range of median would be [MinElement,MaxElement] Finding min and max
     * will take O(N) + O(N)
     *
     * In sorted array of size (M*N), the median used to be at (M*N)/2 position
     * Median will have (N*M)/2 smaller than that it.
     *
     * We will use that fact and discard the right half from the possible answer
     * space if for the given random element i.e. mid, no of elements lesser than
     * that > (N*M)/2
     *
     * Finding lesser numbers in sorted for each row takes : O(N*LogM) Binary
     * Searching on answer space takes: O(log (Max-Min))
     *
     * Total TC: O((N*LogM) * log (Max-Min))
     *
     */

    private static int findMedian(int[][] arr, int N, int M) {

        if (N == 0 || M == 0) return -1;    // Edge case: Empty matrix

        int s = findMin(arr, N);
        int e = findMax(arr, N, M);
        int medianPos = (M * N) / 2;        // Median position in a sorted matrix

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (elementsLT(m, arr, N) <= medianPos) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return s;
    }

    private static int elementsLT(int m, int[][] arr, int N) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            count += elementLessInOneRow(arr[i], m);
        }
        return count;
    }

    private static int elementLessInOneRow(int[] arr, int X) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] <= X) {
                s = m + 1;  // Move right if value is ≤ X
            } else {
                e = m - 1;  // Move left if value is > X
            }
        }
        return s;
    }

    private static int findMin(int[][] arr, int N) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++)
            min = Integer.min(min, arr[i][0]);
        return min;
    }

    private static int findMax(int[][] arr, int N, int M) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++)
            max = Integer.max(max, arr[i][M - 1]);
        return max;
    }

}
