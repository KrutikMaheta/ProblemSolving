package acd_prefixarray;

public class Aj_SumOfSubMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4, 6}, {5, 3, 8, 1, 2}, {4, 6, 7, 5, 5}, {2, 4, 8, 9, 4}};

        System.out.println(findSumOfSubMatrix(arr, new int[]{2, 1}, new int[]{3, 4}));
        System.out.println(findSumOfSubMatrix(arr, new int[]{1, 1}, new int[]{2, 2}));

        System.out.println(findSumOfSubMatrixOptimized(arr, new int[]{2, 1}, new int[]{3, 4}));
        System.out.println(findSumOfSubMatrixOptimized(arr, new int[]{1, 1}, new int[]{2, 2}));
    }

    private static int[][] createRowPrefixSumMatrix(int[][] arr) {
        int[][] rowPrefixSumMatrix = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                rowPrefixSumMatrix[i][j] = (j != 0) ? rowPrefixSumMatrix[i][j - 1] + arr[i][j] : arr[i][j];
            }
        }
        return rowPrefixSumMatrix;
    }

    // Approach 1:
    // Preprocess the array and create row level prefix sum --> O(N^2)
    // Later Each query can be answered in O(N) time.
    // If there are Q queries, overall TC -> O(N^2) + O(QN)
    private static int findSumOfSubMatrix(int[][] arr, int[] start, int[] end) {
        int[][] rowPrefixSumMatrix = createRowPrefixSumMatrix(arr);

        int a = start[0], b = start[1], c = end[0], d = end[1], sum = 0;

        for (int r = a; r <= c; r++) {
            sum += rowPrefixSumMatrix[r][d] - rowPrefixSumMatrix[r][b - 1];
        }

        return sum;
    }

    private static int[][] createPrefixSumMatrix(int[][] rowPrefixSumMatrix) {
        int[][] prefixSumMatrix = new int[rowPrefixSumMatrix.length][rowPrefixSumMatrix[0].length];
        for (int j = 0; j < rowPrefixSumMatrix[0].length; j++) {
            for (int i = 0; i < rowPrefixSumMatrix.length; i++) {
                prefixSumMatrix[i][j] = (i != 0) ? prefixSumMatrix[i - 1][j] + rowPrefixSumMatrix[i][j] : rowPrefixSumMatrix[i][j];
            }
        }

        return prefixSumMatrix;
    }

    // Approach 2:
    // Preprocess the array and create row level prefix and later conver the same to column level prefix sum --> O(N^2) + O(N^2)
    // Later Each query can be answered in O(1) time.
    // If there are Q queries, overall TC -> O(N^2) + O(N^2) + O(Q)
    private static int findSumOfSubMatrixOptimized(int[][] arr, int[] start, int[] end) {
        int[][] rowPrefixSumMatrix = createRowPrefixSumMatrix(arr);
        int[][] prefixSumMatrix = createPrefixSumMatrix(rowPrefixSumMatrix);

        int a = start[0], b = start[1], c = end[0], d = end[1], sum = 0;

        return prefixSumMatrix[c][d] - prefixSumMatrix[a - 1][d] - prefixSumMatrix[c][b - 1] + prefixSumMatrix[a - 1][b - 1];
    }


}
