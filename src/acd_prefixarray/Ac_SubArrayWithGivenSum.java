// Similar Problem2:
// 1.
// Given an array, count no of sub-array where XOR = k

// 2.
// Given an array, return count of possible sub arrays with exactly k odd elements.
// [2,4,1,3,8] -> [1],[3],[2,4,1],[3,8],[4,1]
// Convert even numbers to 0 and odd numbers to 1
// The problem will become subarray with sum = k

package acd_prefixarray;

import ag_hashing.video.Ab_PairWithGivenDiff;

import java.util.Arrays;

public class Ac_SubArrayWithGivenSum {

    public static void main(String[] args) {
        //int arr[] = { 10, 2, -2, -20, 10 };
        //int K = -10;
        int arr[] = {4, 2, 2, 6, 4};
        int K = 6;
        System.out.println(countOfSubArrayWithGivenSum(arr, K));
    }

    private static int countOfSubArrayWithGivenSum(int[] arr, int k) {
        int[] prefixArray = getPrefixSubArray(arr);
        System.out.println(Arrays.toString(prefixArray));
        return Ab_PairWithGivenDiff.countPairWithGivenDiff(prefixArray, k);
    }

    private static int[] getPrefixSubArray(int[] arr) {
        int[] prefixArray = new int[arr.length + 1];
        prefixArray[0] = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixArray[i + 1] = prefixArray[i] + arr[i];
        }

        return prefixArray;
    }

}
