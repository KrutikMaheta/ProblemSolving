package al_backtracking;

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

    private static void possiblePermutationsSwapping(Integer[] arr, int index) {
        if (index == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            possiblePermutationsSwapping(arr, index + 1);
            swap(arr, index, i);
        }
    }

    private static void swap(Integer[] arr, int index, int i) {
        int temp = arr[index];
        arr[index] = arr[i];
        arr[i] = temp;
    }


}
