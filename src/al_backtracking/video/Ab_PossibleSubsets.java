/**
 * Backtracking + BitMasking approach
 */

package al_backtracking.video;

import java.util.ArrayList;
import java.util.List;

public class Ab_PossibleSubsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = possibleSubsetsBottomUp(nums);
        System.out.println(subsets);

        subsets = possibleSubsetsIterative(nums);
        System.out.println(subsets);

        subsets = possibleSubsetsBitMasking(nums);
        System.out.println(subsets);
    }

    public static List<List<Integer>> possibleSubsetsBottomUp(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int arr[] = new int[nums.length];
        possibleSubsetsUtil(nums, 0, arr, result);
        return result;
    }

    //  This is Bottom Up approach We keep inserting the elements as we go down and move bottom to up for forming the final result.
    //  In other words, when we reach bottom we have some result and from there on we start building final result.
    //  TC: O(N*2^N)
    private static void possibleSubsetsUtil(int[] nums, int index, int[] arr, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) {
                    list.add(nums[i]);
                }
            }
            result.add(list);
            return;
        }
        arr[index] = 0;
        possibleSubsetsUtil(nums, index + 1, arr, result);
        arr[index] = 1;
        possibleSubsetsUtil(nums, index + 1, arr, result);
    }


    //  TC: O(2^N)
    //  SC: O(1)
    private static List<List<Integer>> possibleSubsetsIterative(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>()); // Start with an empty subset.

        for (int num : nums) {
            // For each existing subset, create a new subset by adding the current number.
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                List<Integer> newSubset = new ArrayList<>(subsets.get(i));
                newSubset.add(num);
                subsets.add(newSubset);
            }
        }

        return subsets;
    }

    public static List<List<Integer>> possibleSubsetsBitMasking(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        // Total number of subsets = 2^n
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            // For each bit in the mask, decide whether to include the corresponding element
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {  // Check if the i-th bit is set in mask
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }
        return result;
    }

}
