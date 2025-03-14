//  https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
//  2461. Maximum Sum of Distinct Subarrays With Length K

package ace_slidingwindow.external;

import java.util.HashMap;
import java.util.Map;

public class Ac_MaxSumDistinctSubArraySizeK {

    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        System.out.println(maxSum(arr, k));

        int[] arr1 = {1, 1, 1, 7, 8, 9};
        System.out.println(maxSum(arr1, k));

        int[] arr2 = {9, 9, 9, 1, 2, 3};
        System.out.println(maxSum(arr2, k));
    }

    //  TC: O(N)
    //  SC: O(K)
    private static long maxSum(int[] nums, int k) {
        int n = nums.length;
        if (n < k) return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        long sum = 0;

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        long maxSum = (freq.size() == k) ? sum : 0;

        // Slide the window through the array
        for (int i = k; i < n; i++) {
            int add = nums[i];
            int remove = nums[i - k];

            // Add the new element to the window
            sum += add;
            freq.put(add, freq.getOrDefault(add, 0) + 1);

            // Remove the old element from the window
            sum -= remove;
            int count = freq.get(remove);
            if (count == 1) {
                freq.remove(remove);
            } else {
                freq.put(remove, count - 1);
            }

            // Check if current window has all distinct elements
            if (freq.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

}
