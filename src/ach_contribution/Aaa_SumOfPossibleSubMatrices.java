//  Calculates the sum of all possible submatrices within a given 2D array.
package ach_contribution;

public class Aaa_SumOfPossibleSubMatrices {
    public static void main(String[] args) {
        //int[][] arr = {{1, 1}, {1, 1}};
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(sumOfPossibleSubMatrices(arr));
    }

    //  If the current element is (x,y)
    //  No of ways in which TL can be picked is : (x+1) * (y+1)
    //  No of ways in which BR can be picked is : (n-x) * (m-y)
    private static int sumOfPossibleSubMatrices(int[][] arr) {
        int sum = 0;
        int n = arr.length;
        int m = arr[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += ((i + 1) * (j + 1)) * ((n - i) * (m - j)) * arr[i][j];
            }
        }

        return sum;
    }

}
