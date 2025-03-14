//  Given an array of positive integers, and an integer k.
//  Return the kth positive integer that is missing from this array.
//  arr = [11,2,4,3,7], k = 5
//  o/p: 9
//  if we consider sequence from 1 to max element which is 11,
//  first missing is 1
//  2nd missing is 5
//  3rd missing is 6
//  4th missing is 8
//  5th missing is 9
package ai_searching.external;

public class Aa_KthMissingNumberSorted {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11}; // Sorted input
        int k = 5;
        System.out.println("The " + k + "th missing number is: " + findKthMissing(arr, k));
    }

    //  Approach: Binary Search
    //  If an array is sorted, Missing count at i = nums[i]−(i+1)
    //  Binary Search on missingCount:
    //  1. We look at the middle element and check how many numbers are missing before it.
    //  2. If the missing count is less than k, move left rightward.
    //  3. If the missing count is greater than or equal to k, move right leftward.
    //  left ends up at the index where the kth missing number should be.
    //  The result is given by: missing number=left+k
    //  TC: O(logN)
    private static int findKthMissing(int[] nums, int k) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            int missingElementsAtMid = nums[m] - (m + 1);
            if (missingElementsAtMid < k) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return s + k;   // kth missing number
    }
}
