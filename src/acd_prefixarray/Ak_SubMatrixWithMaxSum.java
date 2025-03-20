package acd_prefixarray;

public class Ak_SubMatrixWithMaxSum {
    public static void main(String[] args) {
        int[][] arr = {{-5, -4, -1}, {-3, 2, 4}, {2, 5, 8}};
        System.out.println(findMaxSumInSubArray(arr));
    }

    private static int[][] prefixSumMatrix(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] prefixSumMatrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefixSumMatrix[i][j] = j > 0 ? prefixSumMatrix[i][j - 1] + arr[i][j] : arr[i][j];
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                prefixSumMatrix[i][j] = i > 0 ? prefixSumMatrix[i - 1][j] + prefixSumMatrix[i][j] : prefixSumMatrix[i][j];
            }
        }

        return prefixSumMatrix;
    }

    //  O(N^2)
    //  Since all the rows (n) and columns (m) are sorted, a[n-1][m-1] will be the largest element.
    //  If all numbers within array are positive then return entire array sum as largest sum.
    //  If all numbers within array are negative then return a[n-1][m-1] as answer.
    //  For rest of the cases,  a[n-1][m-1] will definitely be part of the answer. So we know BR of the answer, now its matter of finding TL.
    //  we can reverse the entire matrix (row and column both). so that max number will come at (0,0) position.
    //  Now we can compute the prefixsumsubarray and maximum out of those will be the answer.
    private static int findMaxSumInSubArray(int[][] arr) {
        int[][] rarr = reverseMatrix(arr);
        int[][] prefixSumMatrix = prefixSumMatrix(rarr);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                max = Math.max(max, prefixSumMatrix[i][j]);
            }
        }
        return max;
    }

    private static int[][] reverseMatrix(int[][] arr) {
        //  reverse rows
        for (int L = 0, R = arr.length - 1; L < R; L++, R--) {
            int[] temp = arr[L];
            arr[L] = arr[R];
            arr[R] = temp;
        }

        //  reverse cols
        for (int i = 0; i < arr.length; i++) {
            for (int L = 0, R = arr[i].length - 1; L < R; L++, R--) {
                int temp = arr[i][L];
                arr[i][L] = arr[i][R];
                arr[i][R] = temp;
            }
        }
        return arr;
    }
}
