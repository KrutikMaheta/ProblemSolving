//  https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
package acd_prefixarray.external;

import aa_basicmaths.modulararithmetic.Ab_PairDivisibleByK;
import aa_basicmaths.modulararithmetic.Ac_TripletDivisibleByK;

import java.util.HashMap;
import java.util.Map;

public class Aa_SubArraySumDivisibleByK {

    //  Approach:
    //  1. Use prefix sum and hashmap to track remainder frequencies.
    //  2. If the remainder is negative, adjust it by adding k to bring it within [0, k-1].
    //  3. Use a hashmap to count occurrences of remainders and find valid subarrays.

    /**
     * Same logic as {@link Ab_PairDivisibleByK}, {@link Ac_TripletDivisibleByK}
     */
    //  TC: O(N)
    //  SC: O(N)
    private static int countSubArraysWithSumK(int[] arr, int k) {
        int count = 0, prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // To count subarrays where sum itself is divisible by k
        map.put(0, 1);

        for (int num : arr) {
            prefixSum += num;
            int remainder = prefixSum % k;

            // Ensure remainder is positive [Without this 2nd example will give wrong output]
            if (remainder < 0) {
                remainder += k;
            }

            // If this remainder was seen before, add its count
            count += map.getOrDefault(remainder, 0);

            // Update remainder frequency
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        //int[] arr = {4, 5, 0, -2, -3, 1};
        int[] arr = {2, -7, 3, 5};
        int K = 5;
        System.out.println(countSubArraysWithSumK(arr, K));
    }

}
