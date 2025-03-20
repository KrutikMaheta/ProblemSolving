//	Return difference between the maximum possible contribution and the minimum possible contribution of elements in an array
//	when considering all possible subsets.

package ach_contribution;

import java.util.Arrays;

public class Ab_MinMaxWithSubSet {

    public static void main(String[] args) {
        int arr[] = {3, 2, 5};
        minMaxDiffWithSubset(arr);
    }

    //  For contriAsMin, each element arr[i] is multiplied by 2^(arr.length - 1 - i).
    //      This represents the number of subsets where arr[i] is the minimum element.
    //      Because the array is sorted, all elements after arr[i] can be in the subset.
    //  For contriAsMax, each element arr[i] is multiplied by 2^i.
    //      This represents the number of subsets where arr[i] is the maximum element.
    //      Because the array is sorted, all elements before arr[i] can be in the subset.
    //  TC: O(N * Log N)
    private static void minMaxDiffWithSubset(int[] arr) {
        Arrays.sort(arr);
        int contriAsMax = 0;
        int contriAsMin = 0;
        for (int i = 0; i < arr.length; i++) {
            contriAsMin += arr[i] * (Math.pow(2, (arr.length - 1) - i));
            contriAsMax += arr[i] * (Math.pow(2, i));
        }
        System.out.println(contriAsMax - contriAsMin);

    }

}
