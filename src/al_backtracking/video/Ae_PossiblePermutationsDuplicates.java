package al_backtracking.video;

import java.util.*;

public class Ae_PossiblePermutationsDuplicates {
    public static void main(String[] args) {
        int[] arr = {7, 5, 7};  // Example array with duplicates
        possiblePermutationsSwapping(arr, 0);
        List<List<Integer>> result = possiblePermutations(arr);
        System.out.println(result);
    }

    public static void possiblePermutationsSwapping(int[] nums, int idx) {
        if (idx == nums.length) {
            System.out.println(Arrays.toString(nums));
            return;
        }
        HashSet<Integer> set = new HashSet<>();

        for (int i = idx; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            swap(nums, i, idx);
            possiblePermutationsSwapping(nums, idx + 1);
            swap(nums, i, idx);
        }

    }

    //  TC: O(N!) in the worst case when all elements are different.
    //  SC: O(N) used array, arr array & recursive stack space
    private static List<List<Integer>> possiblePermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] arr = new int[nums.length];
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);  // Sort the array to handle duplicates
        possiblePermutationsUtil(result, nums, arr, used, 0);
        return result;
    }

    private static void possiblePermutationsUtil(List<List<Integer>> result, int[] nums, int[] arr, boolean[] used, int index) {
        if (index == nums.length) {
            result.add(Arrays.stream(arr).boxed().toList());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;  // Skip if the element is already used
            }
            // Skip duplicate elements
            // The second 5 (index 1) is skipped if the first 5 (index 0) has not been used (!used[i - 1]).
            // This ensures we always process duplicates in order and do not start with a later duplicate before its previous occurrence.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            arr[index] = nums[i];
            used[i] = true;
            possiblePermutationsUtil(result, nums, arr, used, index + 1);
            used[i] = false;  // Backtrack and mark the element as unused
        }
    }

    private static void swap(int[] arr, int index, int i) {
        int temp = arr[index];
        arr[index] = arr[i];
        arr[i] = temp;
    }
}