//  https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
package ace_slidingwindow;

public class Abb_SubarrayWithMaxAbsoluteSum {

    // We reset the Minsum/MaxSum = 0 because of this contraint -> Return the maximum absolute sum of any (possibly empty) subarray of nums.
    //  TC: O(N); SC: O(1)
    private static int maxAbsoluteSum(int[] arr) {
        int minSum = 0, maxSum = 0, currentMax = 0, currentMin = 0;

        for (int num : arr) {
            currentMax = Integer.max(0, currentMax + num);
            maxSum = Integer.max(maxSum, currentMax);

            currentMin = Integer.min(0, currentMin + num);
            minSum = Integer.min(minSum, currentMin);
        }

        return Math.max(maxSum, Math.abs(minSum));
    }


    public static void main(String[] args) {
        int[] arr = {2, -5, 1, -4, 3, -2};
        //int[] arr = {1, -3, 2, 3, -4};
        System.out.println(maxAbsoluteSum(arr));
    }

}
