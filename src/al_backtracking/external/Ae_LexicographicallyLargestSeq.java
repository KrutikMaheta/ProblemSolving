//  https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence

package al_backtracking.external;

import java.util.Arrays;

public class Ae_LexicographicallyLargestSeq {

    //  Approach:
    //  We use backtracking with a greedy approach:
    //  1. Start from n down to 1 (to ensure the lexicographically largest order).
    //  2. Use a boolean array (used[]) to track placed numbers.
    //  3. Recursively attempt to place each number while following constraints.
    //  TC: O(2^n) (worst case, since each number can either be placed or skipped).
    //  SC: O(n) (for the used[] array and recursion stack).
    private static int[] generateSequence(int n) {
        int[] result = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];
        generateSequenceUtil(result, used, 0, n);
        return result;
    }

    private static boolean generateSequenceUtil(int[] result, boolean[] used, int idx, int n) {

        // Base Case: If we filled the sequence, return true
        if (idx == result.length) {
            return true;
        }

        // Skip already filled positions
        if (result[idx] != 0) {
            return generateSequenceUtil(result, used, idx + 1, n);
        }

        // Try placing numbers from largest to smallest
        for (int num = n; num >= 1; num--) {

            if (used[num]) continue; // If already used, skip

            //  Place the number at current Index
            result[idx] = num;
            //  mark it as used.
            used[num] = true;

            // If num == 1, we place it once
            if (num == 1) {
                if (generateSequenceUtil(result, used, idx + 1, n)) {
                    return true;
                }
            }
            // If num > 1, check if we can place it at (index + num)
            else if (num + idx < result.length && result[num + idx] == 0) {
                result[num + idx] = num;
                if (generateSequenceUtil(result, used, idx + 1, n)) {
                    return true;
                }
                //  Since answer is not possible reset to 0
                result[num + idx] = 0;
            }
            //  reset & backtrack as not possible to generate sequence.
            used[num] = false;
            result[idx] = 0;

        }

        // No valid placement found
        return false;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.toString(generateSequence(n))); // 3,1,2,3,2

        n = 5;
        System.out.println(Arrays.toString(generateSequence(n))); // 5, 3, 1, 4, 3, 5, 2, 4, 2
    }

}
