/**
 * Given an array with +ve integers, find maximum k such that sum of no subarrays of size k > X.
 */

package ai_searching;

public class Af_MaxSizeSubArray {

    public static void main(String[] args) {
        int arr[] = {6, 17, 2, 4, 6, 8};
        System.out.println(maxSizeSubArray(arr, 30));
    }

    /*
     * 1. Sub array size could be in the range of 0 to N
     * 2. We will pick the random number between 1 to N and will calculate the sum of all possible subarrays of that size using sliding window
     * and will check that size could be possible answer or not.
     * 3. If size k satisfies the condition then all size < k will also satisfies and as we want to find the max size we can discard left portion (which is size < k)
     *
     * TC : O(NLogN)
     * LogN for reducing the answer by half each time.
     * O(N) Traversing linearly for checking the sum of all possible sub arrays.
     *
     */
    public static int maxSizeSubArray(int[] arr, int X) {
        int len = arr.length;
        int s = 0;
        int e = len - 1;
        int m;

        while (s <= e) {
            m = s + (e - s) / 2;
            if (possibleAnswer(m, arr, X)) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return e;
    }

    // k is subarray size
    // Subarray sum with sliding window
    private static boolean possibleAnswer(int k, int[] arr, int X) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        for (int i = k; i < arr.length; i++) {
            if (sum > X)
                return false;
            sum = sum - arr[i - k] + arr[i];
        }
        return true;
    }

}
