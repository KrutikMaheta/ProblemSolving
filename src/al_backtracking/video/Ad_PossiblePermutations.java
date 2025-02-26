package al_backtracking.video;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ad_PossiblePermutations {

    public static void main(String[] args) {
        Integer[] arr = {5, 8, 7};
        List<List<Integer>> result = permutations(arr);
        System.out.println(result);
        possiblePermutationsSwapping(arr, 0);
    }

    private static List<List<Integer>> permutations(Integer[] nums) {
        boolean[] used = new boolean[nums.length];
        Integer[] arr = new Integer[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        collectPerms(result, nums, arr, used, 0);
        return result;
    }

    //  TC: O(N!) in the worst case when all elements are different.
    //  SC: O(N) used array, arr array & recursive stack space
    private static void collectPerms(List<List<Integer>> result, Integer[] nums, Integer[] arr, boolean[] used, int idx) {
        if (idx == arr.length) {
            result.add(Arrays.stream(arr).toList());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            arr[idx] = nums[i];
            used[i] = true;
            collectPerms(result, nums, arr, used, idx + 1);
            used[i] = false;
        }
    }

    //  TC: O(N!) in the worst case when all elements are different.
    //  SC: O(N) recursive stack space -> In-place swapping hence some space-saving compared to previous approach
    private static void possiblePermutationsSwapping(Integer[] nums, int index) {
        // Base Case: If index reaches the end of the array, print the permutation
        if (index == nums.length) {
            System.out.println(Arrays.toString(nums));
            return;
        }

        // Loop through elements starting from 'index'
        for (int i = index; i < nums.length; i++) {
            // Swap element at 'index' with element at 'i'
            swap(nums, index, i);

            // Recur with the next index
            possiblePermutationsSwapping(nums, index + 1);

            // Backtrack: Swap back to restore original array state
            swap(nums, index, i);
        }
    }

    private static void swap(Integer[] arr, int index, int i) {
        int temp = arr[index];
        arr[index] = arr[i];
        arr[i] = temp;
    }
}
