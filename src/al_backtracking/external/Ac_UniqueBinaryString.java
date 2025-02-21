//  https://leetcode.com/problems/find-unique-binary-string/description/

package al_backtracking.external;

import ab_bitmanipulation.external.Ab_UniqueBinaryString;

import java.util.HashSet;
import java.util.Set;

public class Ac_UniqueBinaryString {

    //  TC: O(2^N) // worst case, we will generate all binary string possible
    //  SC: O(N)   // Hashset
    /**
     * Optimized Approach: {@link Ab_UniqueBinaryString#findDifferentBinaryString(String[])}
     */

    private static String findDifferentBinaryString(String[] nums) {
        char[] arr = new char[nums.length];
        Set<String> strings = new HashSet<>();
        for (String num : nums) {
            strings.add(num);
        }
        return generateBinaryStrings(strings, arr, 0);
    }

    private static String generateBinaryStrings(Set<String> nums, char[] arr, int idx) {
        if (idx == nums.size()) {
            String candidate = new String(arr);
            return nums.contains(candidate) ? null : candidate;
        }
        arr[idx] = '0';
        String result = generateBinaryStrings(nums, arr, idx + 1);

        if (result != null) {
            return result;
        }
        arr[idx] = '1';
        return generateBinaryStrings(nums, arr, idx + 1);
    }

    public static void main(String[] args) {
        String[] nums = {"000", "011", "001"};
        System.out.println(findDifferentBinaryString(nums));
    }


}
