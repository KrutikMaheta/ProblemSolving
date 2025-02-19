package ac_array.video;

import java.util.Arrays;

public class Aj_NextPermutation {

    //  Algorithm:
    //  1. Scan from right to left to find the first nums[i] such that nums[i] < nums[i + 1].
    //      If no such element is found, the array is the last permutation, so reverse it.
    //  2. From the right, find the smallest element larger than nums[i].
    //  3. Swap the two elements.
    //  4. Reverse the sequence after the original pivot index to get the next permutation.
    //  TC: O(N)
    private static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: Find the first decreasing element from the right
        while (i > 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // found the pivot element
            int j = n - 1;

            // Step 2: Find the next greater element than nums[i]
            while (nums[j] <= nums[i]) {
                j--;
            }

            // Step 3: Swap nums[i] and nums[j]
            swap(nums, i, j);
        }

        // Step 4: Reverse the suffix (elements after index i); if no pivot then reverse the whole array.
        reverse(nums, i + 1, n - 1);
    }

    private static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {6, 9, 7, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
