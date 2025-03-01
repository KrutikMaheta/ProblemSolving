// This program calculates the Length of the Longest Common Subsequence (LCS) between two strings a and b.
// The LCS is the longest sequence that appears in both strings in the same relative order (but not necessarily consecutively).
// For example, the LCS of "abcd" and "adxc" is "ac", and its length is 2.

package au_dynamicprogramming.strings;

import java.util.ArrayList;
import java.util.List;

public class Ab_LongestCommonSubsequence {

    //  TC & SC: O(N*M)
    private static int lengthOfLCS(String a, String b) {
        int N = a.length();
        int M = b.length();
        int[][] lcs = new int[N + 1][M + 1];

        for (int i = 0; i <= N; i++) {  //  string a
            for (int j = 0; j <= M; j++) {  //  string b
                // Base case: if one string is empty, LCS length is
                if (i == 0 || j == 0) {
                    lcs[i][j] = 0;
                }
                // If characters match, increment the LCS length from previous diagonal cell
                else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                }
                // If characters don't match,
                // LCS length is the maximum of either excluding the character from a (lcs[i-1][j]) or excluding the character from b (lcs[i][j-1]).
                else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        //  Backtrack to reconstruct LCS
        int i = N, j = M;
        StringBuilder lcsString = new StringBuilder();
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                lcsString.append(a.charAt(i - 1));    // Add to LCS
                i--;
                j--;
            } else if (lcs[i - 1][j] > lcs[i][j - 1]) {
                i--;    // Move up
            } else {
                j--;    // Move left
            }
        }

        System.out.println("LCS is : " + lcsString.reverse().toString());

        return lcs[N][M];
    }

    // SC: O(MIN(N,M))
    private static int lengthOfLCSSpaceOptimized(String a, String b) {
        int N = a.length();  // Length of string a
        int M = b.length();  // Length of string b

        // Ensure 'b' is the shorter string to minimize space usage
        if (M > N) {
            return lengthOfLCSSpaceOptimized(b, a);  // Swap 'a' and 'b' to ensure M <= N
        }

        // Create two arrays to store current and previous row's LCS values
        int[] prev = new int[M + 1];
        int[] curr = new int[M + 1];

        // Loop through each character of string 'a'
        for (int i = 0; i <= N; i++) {
            // Loop through each character of string 'b'
            for (int j = 0; j <= M; j++) {

                // Base case: if one string is empty, LCS length is 0
                if (i == 0 || j == 0) {
                    curr[j] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    // If characters match, take the diagonal value from the previous row and add 1
                    curr[j] = 1 + prev[j - 1];
                } else {
                    // Otherwise, take the maximum of the value above or the value to the left
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }

            // After processing the current row, move 'curr' to 'prev' for the next iteration
            int[] temp = prev;
            prev = curr;
            curr = temp;  // Swap the references, avoiding copying the array
        }

        return prev[M];
    }


    public static void main(String[] args) {
        String A = "abbcdgf";
        String B = "bbadcgf";

        //String A = "abcd";
        //String B = "adxc";

        System.out.println(lengthOfLCS(A, B));
        System.out.println(lengthOfLCSSpaceOptimized(A, B));
    }


}
