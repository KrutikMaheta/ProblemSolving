package ace_slidingwindow;

import acd_prefixarray.Ac_SubArrayWithSumK;

public class Aa_SubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1, 2};
        int K = 2;
        System.out.println(isSubArrWithSumKPresent(arr, K));
    }

    /**
     * Can work only for positive integers because when sum > k, reducing the window guarantees a smaller sum.
     * For Negative Integers and k = 0, refer {@link Ac_SubArrayWithSumK}
     */
    //  TC: O(N); SC: O(1)
    private static int isSubArrWithSumKPresent(int[] arr, int k) {
        int start = 0, sum = 0, count = 0;

        for (int end = 0; end < arr.length; end++) {
            // Add the current element to the current sum
            sum += arr[end];

            // Shrink the window until the currentSum is less than or equal to K
            while (sum > k && start <= end) {
                sum -= arr[start];
                start++;
            }
            // Check if we found a subarray with sum exactly equal to K
            if (sum == k) {
                count++;
            }
        }
        return count;
    }
}
