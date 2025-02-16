//  https://leetcode.com/problems/find-the-punishment-number-of-an-integer/description/

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
        if (idx == str.length()) {
            return currentSum == targetSum;
        }

        int num = 0;
        for (int j = idx; j < str.length(); j++) {
            num = num * 10 + (str.charAt(j) - '0');
            if (isValidPartition(str, targetSum, j + 1, currentSum + num)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(punishmentNumber(10)); // Output: 182
        System.out.println(punishmentNumber(37)); // Output: 1478
    }

}
