//  https://leetcode.com/problems/n-queens/

package al_backtracking.video;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ag_NQueens {

    //  Time Complexity:
    //  At the first row, we have N choices (placing the first queen in any of N columns).
    //  At the second row, we have at most N-1 choices (since one column is blocked).
    //  At the third row, we have at most N-2 choices; This pattern continues down to 1 choice at the last row.
    //  Thus, the worst-case time complexity is: O(N!) Which is same as generating all permutations of N elements.
    //  Pruning:
    //  Without pruning, the number of ways to place N queens in an N×N board is N^N. [As at each position we can place the number from 1....N]
    //  However, backtracking eliminates invalid placements early, reducing the number of recursive calls significantly.

    //  Space Complexity:
    //  Recursive Call Stack: The maximum depth of recursion is N (one recursive call per row). -> O(N)
    //  Board Storage:
    //  We store all valid board configurations.
    //  In the worst case, there can be O(N!) valid solutions.
    //  Each solution consists of N strings of length N, taking O(N²) per solution.
    //  Worst case, O(N! * N^2)

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n]; // Stores column positions of queens per row
        backtrack(result, queens, n, 0);
        return result;
    }

    private static void backtrack(List<List<String>> result, int[] queens, int n, int row) {
        if (row == n) {
            result.add(constructBoard(queens, n));
            return;
        }

        //  Trying to place the queens at each column at present row
        for (int col = 0; col < n; col++) {
            if (isSafe(queens, row, col)) {
                queens[row] = col;
                backtrack(result, queens, n, row + 1);
            }
        }
    }


    private static boolean isSafe(int[] arr, int rowIndex, int colIndex) {
        // Same column check
        for (int j = 0; j < rowIndex; j++) {
            if (arr[j] == colIndex) {
                return false;
            }
        }

        // Diagonal Check
        int pos = 0;
        for (int j = rowIndex - 1; j >= 0; j--) {
            pos++;
            if (arr[j] == colIndex + pos || arr[j] == colIndex - pos) {
                return false;
            }
        }
        return true;
    }

    private static List<String> constructBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }

        return board;
    }

    public static void main(String[] args) {
        int N = 4;
        List<List<String>> result = solveNQueens(N);
        result.forEach(solution -> {
            System.out.println("Solution: ");
            solution.stream().forEach(row -> System.out.println(row));
            System.out.println();
        });
    }

}
