//  https://leetcode.com/problems/find-the-punishment-number-of-an-integer/description/

//  Explanation of "i² has at most 2 log(n) digits"
//  The number of digits in a number x is given by: log10(x) + 1
//  for x=9, log10(9) = 0.95 + 1 = 1 digit
//  for x=100, log10(100) = 2 + 1 = 3 digit

//  for i^2,
//  log10(i^2) = 2log10(i)
//  No of digits = 2 log10(i) + 1

package al_backtracking.external;

public class Aa_PunishmentNumber {

    //  Time Complexity Analysis:
    //  Outer Loop: O(N)
    //  Backtracking: O(2^d) -> d is the no of digits in i^2
    //  Since i^2 can have max 2 log(N) digits,
    //  Overall TC: O(N * 2 ^ logN)
    private static int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (isValidPartition(String.valueOf(square), i, 0, 0)) {
                sum += square;
            }
        }

        return sum;
    }

    private static boolean isValidPartition(String str, int targetSum, int idx, int currentSum) {
        // Base case: if we've used all digits, check if sum matches target
        if (idx == str.length()) {
            return currentSum == targetSum;
        }

        int num = 0;

        // Try all possible partitions starting from current index
        for (int j = idx; j < str.length(); j++) {
            num = num * 10 + (str.charAt(j) - '0'); // Extract substring as an integer

            // If the sum exceeds the target, stop further recursion
            if (num > targetSum) break;

            // Recur for the next part of the string
            if (isValidPartition(str, targetSum, j + 1, currentSum + num)) {
                return true;
            }
        }

        return false;   // No valid partition found
    }

    public static void main(String[] args) {
        System.out.println(punishmentNumber(10)); // Output: 182
        System.out.println(punishmentNumber(37)); // Output: 1478
    }

}
