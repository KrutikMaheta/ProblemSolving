//  https://leetcode.com/problems/count-number-of-bad-pairs/description/
//  A pair of indices (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i]
//  1 <= nums.length <= 10^5
//  1 <= nums[i] <= 10^9

package ag_hashing.external;

import java.util.HashMap;
import java.util.Map;

public class Ac_CountBadPairs {
    public static void main(String[] args) {
        //int[] arr = {4, 1, 3, 3};
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(countGoodPairs(arr));
    }


    //  Algorithm:
    //  j - i != nums[j] - nums[i] is equivalent to i - nums[i] != j - nums[j]
    //  This transformation suggests that for indices i and j to form a good pair, the value of i - nums[i] should equal j - nums[j].
    //  By counting how many times each value of i - nums[i] appears as we iterate through the array, we can determine the number of good pairs and
    //  subsequently the number of bad pairs.
    //  Note: Taken long to prevent integer overflow
    //  TC: O(N); SC: O(N)
    private static long countGoodPairs(int[] arr) {
        Map<Long, Integer> map = new HashMap<>();
        long goodPairs = 0;
        long totalPairs = 0;

        for (int i = 0; i < arr.length; i++) {
            long diff = i - arr[i];
            if (map.containsKey(diff)) {
                goodPairs += map.get(diff);
            }
            totalPairs += i;
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }

        return totalPairs - goodPairs;
    }
}
