package al_backtracking;

import java.util.*;

public class Ae_PossiblePermutationsDuplicates {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7};  // Example array with duplicates
        List<List<Integer>> result = possiblePermutations(arr);
        System.out.println(result);
    }

    private static List<List<Integer>> possiblePermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] arr = new int[nums.length];
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);  // Sort the array to handle duplicates
        backtrack(result, nums, arr, used, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, int[] nums, int[] arr, boolean[] used, int index) {
        if (index == nums.length) {
            result.add(Arrays.stream(nums).boxed().toList());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;  // Skip if the element is already used
            }
            // Skip duplicate elements
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            arr[index] = nums[i];
            used[i] = true;
            backtrack(result, nums, arr, used, index + 1);
            used[i] = false;  // Backtrack and mark the element as unused
        }
    }
}