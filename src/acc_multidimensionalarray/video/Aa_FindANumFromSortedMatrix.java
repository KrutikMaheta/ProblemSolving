/**
 * Given a matrix will have sorted columns and sorted rows
 * Find the given number from the same.
 */

package acc_multidimensionalarray.video;

public class Aa_FindANumFromSortedMatrix {

	public static void main(String[] args) {
		int a[][] = { { 5, 10, 15, 20 }, { 6, 12, 20, 23 }, { 7, 14, 21, 30 }, { 17, 26, 33, 48 } };
		System.out.println(findANumFromSortedMatrix(a, 4, 4, 33 ));
	}

	// Start from the a[0][m-1] element and decide the direction
	// During each direction decision we are omitting either one column or row
	// Time Complexity : O(m+n)
	private static boolean findANumFromSortedMatrix(int[][] a, int n, int m, int num) {
		int r = 0;
		int c = m - 1;
		while (r <= n - 1 && c >= 0) {
			if (a[r][c] == num)
				return true;
			else if (a[r][c] > num)
				c--;
			else
				r++;
		}
		return false;
	}

}
