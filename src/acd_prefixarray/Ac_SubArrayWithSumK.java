//  Video Explanation: https://www.youtube.com/watch?v=fFVZt-6sgyo&ab_channel=NeetCode

package acd_prefixarray;

import java.util.HashMap;
import java.util.Map;

public class Ac_SubArrayWithSumK {

    public static void main(String[] args) {
        //int arr[] = {10, 2, -2, -20, 10};
        //int K = -10;
        int arr[] = {1, -1, 1, 1, 1, -1};
        int K = 2;

        System.out.println(subArrayWithSumK(arr, K));
    }

    //  If the array elements are positive only we can use sliding window approach.
    //  As we iterate over the array, we maintain a running sum (prefixSum).
    //  If a sub-array arr[i...j] has a sum k, then -> prefixSum[j]−prefixSum[i−1]=k which can be rewritten as: prefixSum[j]−k=prefixSum[i−1]
    //  This means if prefixSum - k exists in our prefixCountMap, there exists at least one subarray ending at j with sum k.
    //  Maintain a Map to Store Frequency of Prefix Sums.
    //  TC: O(N)
    //  SC: O(N)
    private static int subArrayWithSumK(int[] arr, int k) {
        int result = 0;
        int prefixSum = 0;
        Map<Integer, Integer> prefixCountMap = new HashMap<>();

        // Initialize with (0,1) because a prefix sum of 0 can be valid
        prefixCountMap.put(prefixSum, 1);

        for (int num : arr) {
            prefixSum += num;
            result += prefixCountMap.getOrDefault(prefixSum - k, 0);
            prefixCountMap.put(prefixSum, prefixCountMap.getOrDefault(prefixSum, 0) + 1);
        }

        return result;
    }

}
