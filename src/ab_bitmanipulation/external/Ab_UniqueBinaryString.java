//  https://leetcode.com/problems/find-unique-binary-string/description/

package ab_bitmanipulation.external;

public class Ab_UniqueBinaryString {

    //  Algorithm: Cantor's Diagonalization method
    //  1. We can construct a unique string by taking the i-th bit from the i-th string and flipping it (0 → 1 or 1 → 0).
    //  2. This ensures the new binary string is different from every given string in at least one position.
    //  TC: O(N)
    public static String findDifferentBinaryString(String[] nums) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            char flippedBit = nums[i].charAt(i) == '0' ? '1' : '0';
            result.append(flippedBit);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] nums = {"100", "011", "001"};
        System.out.println(findDifferentBinaryString(nums));
    }

}
