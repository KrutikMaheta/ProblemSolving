package acf_2pointers.external;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aa_3Sum {

    //  Approach:
    //  1. The array is first sorted to make it easier to find triplets and avoid duplicates.
    //  2. We fix one number (nums[i]) and use two pointers (left and right) to find pairs that sum to -nums[i].
    //  3. To prevent duplicate triplets, we skip repeated elements for both the fixed number and the left/right pointers.
    // TC: O(N^2)
    private static List<List<Integer>> tripletsWithSum0(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (nums == null || n < 3) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate elements for fixed number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for 'left' and 'right'
                    while (left < right && nums[left + 1] == nums[left]) left++;
                    while (left < right && nums[right - 1] == nums[right]) right--;

                    left++;
                    right--;
                } else if (sum > 0) {
                    right--; // Decrease sum by moving right pointer
                } else {
                    left++; // Increase sum by moving left pointer
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //int[] arr = {-1, 0, 1, 2, -1, -4};
        int[] arr = {0, 0, 0};
        List<List<Integer>> result = tripletsWithSum0(arr);
        result.forEach(ans -> System.out.println(ans));
    }

}
