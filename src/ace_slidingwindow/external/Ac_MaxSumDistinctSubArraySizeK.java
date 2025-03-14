package ace_slidingwindow.external;

import java.util.HashMap;
import java.util.Map;

public class Ac_MaxSumDistinctSubArraySizeK {

    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        System.out.println(maxSum(arr, k));

        int[] arr1 = {1, 1, 1, 7, 8, 9};
        System.out.println(maxSum(arr1, k));

        int[] arr2 = {9, 9, 9, 1, 2, 3};
        System.out.println(maxSum(arr2, k));
    }

    private static long maxSum(int[] nums, int k) {
        int n = nums.length;
        long sum = 0, maxSum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int i;
        for (i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        if (map.size() == k) {
            maxSum = sum;
        }

        for (; i < n; i++) {
            sum -= nums[i - k];
            Integer count = map.get(nums[i - k]);
            if (count != null) {
                map.put(nums[i - k], count - 1);
                if (count == 1) {
                    map.remove(nums[i - k]);
                }
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];

            if (map.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }

        }
        return maxSum;
    }

}
