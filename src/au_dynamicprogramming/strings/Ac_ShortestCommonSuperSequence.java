//  https://leetcode.com/problems/shortest-common-supersequence/description/

package au_dynamicprogramming.strings;

public class Ac_ShortestCommonSuperSequence {

    //  Approach:
    //  Find the Longest Common Subsequence (LCS): The common order-preserved subsequence helps in determining the minimal merging points.
    //  Merge the Strings Using LCS:
    //  1. Insert characters from both strings while ensuring that the LCS is preserved.
    //  2. This guarantees the shortest common supersequence.
    //  TC: O(M*N); SC: O(M+N)
    private static String shortestCommonSubSeq(String s1, String s2) {
        int N = s1.length();
        int M = s2.length();
        int[][] lcs = new int[N + 1][M + 1];

        for (int i = 0; i <= N; i++) {  //  string a
            for (int j = 0; j <= M; j++) {  //  string b
                // Base case: if one string is empty, LCS length is
                if (i == 0 || j == 0) {
                    lcs[i][j] = 0;
                }
                // If characters match, increment the LCS length from previous diagonal cell
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                }
                // If characters don't match,
                // LCS length is the maximum of either excluding the character from a (lcs[i-1][j]) or excluding the character from b (lcs[i][j-1]).
                else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        // Step 2: Build the Shortest Common Supersequence
        StringBuilder result = new StringBuilder();
        int i = N, j = M;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                result.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (lcs[i - 1][j] > lcs[i][j - 1]) {
                result.append(s1.charAt(i - 1));
                i--;
            } else {
                result.append(s2.charAt(j - 1));
                j--;
            }
        }

        // Add remaining characters from both strings
        while (i > 0) {
            result.append(s1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            result.append(s2.charAt(j - 1));
            j--;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "abac";
        String s2 = "cab";
        System.out.println(shortestCommonSubSeq(s1, s2));

        s1 = "brute";
        s2 = "groot";
        System.out.println(shortestCommonSubSeq(s1, s2));
    }

}
