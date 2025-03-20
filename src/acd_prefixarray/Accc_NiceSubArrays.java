//  https://leetcode.com/problems/count-number-of-nice-subarrays/description/
//  1248. Count Number of Nice Subarrays

package acd_prefixarray;
// Given an array, return count of possible sub arrays with exactly k odd elements.
// [2,4,1,3,8] -> [1],[3],[2,4,1],[3,8],[4,1]
// Convert even numbers to 0 and odd numbers to 1
// The problem will become subarray with sum = k


import java.util.HashMap;
import java.util.Map;

public class Accc_NiceSubArrays {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(noOfNiceSubArrays(arr, k));

        int[] arr1 = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1};
        k = 2;
        System.out.println(noOfNiceSubArrays(arr1, k));
    }

    private static int noOfNiceSubArrays(int[] arr, int k) {
        int result = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                sum++;
            }
            result += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
