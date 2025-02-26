package acd_prefixarray;

import java.util.HashMap;
import java.util.Map;

public class Ad_LargestSubArrWithEq0s1s {

    public static void main(String[] args) {
        int arr[] = {1, 0, 1, 1, 1, 0, 0};
        //int arr[] = { 0, 0, 1, 1, 0 };
        System.out.println(largestSubArrWithEq0s1s(arr));
    }

    private static int largestSubArrWithEq0s1s(int[] arr) {
        int maxLen = 0, prefixSum = 0, startIdx = -1, endIndex = -1;
        Map<Integer, Integer> prefixSumIdxMap = new HashMap<>();

        // Initialize HashMap with (0, -1) to handle cases where prefixSum itself is 0
        prefixSumIdxMap.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            // Treat 0 as -1 for sum calculations
            prefixSum += arr[i] == 0 ? -1 : 1;

            // If prefixSum is seen before, update max subarray length
            if (prefixSumIdxMap.containsKey(prefixSum)) {
                int prevIdx = prefixSumIdxMap.get(prefixSum);
                int currentLen = i - prevIdx;
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    startIdx = prevIdx + 1;
                    endIndex = i;
                }
            } else {
                // Store first occurrence of prefixSum
                prefixSumIdxMap.put(prefixSum, i);
            }
        }

        System.out.println("(Start Index : " + startIdx + ", End Index : " + endIndex + ")");

        return maxLen;
    }

}
