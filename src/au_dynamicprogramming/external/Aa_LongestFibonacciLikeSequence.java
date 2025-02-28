//  873. Length of Longest Fibonacci Subsequence
//  https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/description/

package au_dynamicprogramming.external;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Aa_LongestFibonacciLikeSequence {


    //  Approach:
    //  Use a HashMap to Store Indices: Store each number's index for quick lookup.
    //  Dynamic Programming Table (dp[j][i]): represents the length of the Fibonacci-like sequence ending at indices j and i.
    //  If arr[k] + arr[j] = arr[i] (Fibonacci property), update dp[j][i] = dp[k][j] + 1.
    //  Otherwise, initialize dp[j][i] = 2 (starting new sequence).
    //  Why 1D table is not enough and 2D table needs to consider?
    //  -> A Fibonacci sequence requires two previous numbers (arr[k], arr[j]) to determine the next (arr[i]).
    //  -> A 1D DP table would struggle to track pairs (j, i), which is why 2D DP is required.
    //  TC: O(N^2)
    //  SC: O(N^2)
    private static int lengthOfLongestFibonacciDP(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        //  dp[j][i] -> represents the length of fibonacci sequence ending at arr[j] & arr[i]
        int[][] dp = new int[n][n];
        int maxLen = 0;

        // Map value to its index
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        // Iterate over pairs (j, i) and find the previous number in Fibonacci-like sequence
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int prev = nums[i] - nums[j];   // Find the previous Fibonacci number

                //  The previous number should be smaller than arr[j] and should exist in array
                //  we are looking for fibonacci which has last 2nd term as arr[j] hence skipping if prev > arr[j]
                if (prev < nums[j] && map.containsKey(prev)) {
                    int k = map.get(prev);

                    // Update DP table (extend sequence)
                    dp[j][i] = dp[k][j] + 1;
                    maxLen = Math.max(maxLen, dp[j][i]);
                } else {
                    // Initialize sequence length to 2
                    dp[j][i] = 2;
                }
            }
        }

        return maxLen > 2 ? maxLen : 0;
    }

    //  TC: O(N^2 * log(max((nums))) Why?
    //  The inner while loop,
    //  The Fibonacci sequence grows exponentially. Each term is the sum of the previous two, so the numbers increase rapidly.
    //  Imagine the array arr contains a perfect Fibonacci sequence up to a number close to max(arr).
    //  In this scenario, the while loop would continue generating Fibonacci numbers until it reaches a number greater than max(arr).
    //  The number of iterations it takes to reach a value near max(arr) is proportional to the logarithm (base 1.618, roughly) of max(arr).
    //  SC: O(N) for hashset
    private static int lengthOfLongestFibonacci(int[] nums) {
        int maxLen = 0;
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        // Create a set to quickly check if a number exists in the array.
        for (int num : nums) {
            set.add(num);
        }

        // Iterate through all possible pairs (i, j) as the starting two numbers.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int first = nums[i];
                int second = nums[j];
                int currentMax = 2;

                // Keep generating the next Fibonacci number and checking if it exists.
                while (set.contains(first + second)) {
                    int next = first + second;
                    first = second;
                    second = next;
                    currentMax++;
                }
                maxLen = Math.max(maxLen, currentMax);
            }
        }

        return maxLen > 2 ? maxLen : 0;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        //int[] nums = {1, 3, 7, 11, 12, 14, 18};
        System.out.println(lengthOfLongestFibonacci(nums));
        System.out.println(lengthOfLongestFibonacciDP(nums));
    }

}
