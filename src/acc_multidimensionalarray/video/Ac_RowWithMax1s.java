/**
 * Given a matrix of 0 & 1
 * All rows are sorted
 * Find the row that has the maximum no of 1s
 */

package acc_multidimensionalarray.video;

public class Ac_RowWithMax1s {

    public static void main(String[] args) {
        //int a[][] = { { 0, 0, 1, 1 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 }, { 0, 1, 1, 1 } };
        int a[][] = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}};
        System.out.println(findTheRowIndWithMax1s(a, 4, 4));
        System.out.println(findTheRowIndWithMax1sOptimized(a, 4, 4));
    }

	/*/
	 * Step1: Get the index of first (or leftmost) 1 in the first row.
	 * Step2: Do following for every row after the first row 
		�IF the element on left of previous leftmost 1 is 0, ignore this row. 
		�ELSE Move left until a 0 is found. Update the leftmost index to this index and max_row_index 
		to be the current row.
	 * 	The time complexity is O(m+n) because we can possibly go as far left as we came ahead in the 
	 * 	first step.
	 */

    private static int findTheRowIndWithMax1sOptimized(int[][] a, int r, int c) {
        int j = c - 1;
        int max_row_index = -1;
        for (int i = 0; i < r; i++) {
            while (j >= 0 && a[i][j] == 1) {
                max_row_index = i;
                j--;
            }

        }
        return max_row_index;
    }

    // Iterate column major way and as soon as any 1 is found, return the row index
    // o(n*m)
    private static int findTheRowIndWithMax1s(int[][] a, int r, int c) {
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (a[j][i] == 1)
                    return j;
            }
        }
        return -1;
    }

}
