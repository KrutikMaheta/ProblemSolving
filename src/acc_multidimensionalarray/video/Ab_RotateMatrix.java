package acc_multidimensionalarray.video;

public class Ab_RotateMatrix {

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		printMatrix(a, a.length, a[0].length);
		rotateMatrixBy90Clockwise(a, a.length, a[0].length);
		printMatrix(a, a.length, a[0].length);
	}

	private static void printMatrix(int[][] a, int r, int c) {
		System.out.println();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}

	private static void rotateMatrixBy90Clockwise(int[][] a, int r, int c) {
		transpose(a, r, c);
		reverseRows(a, r, c);
	}

	private static void transpose(int[][] a, int r, int c) {
		int temp;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < i; j++) {
				temp = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = temp;
			}
		}
	}

	private static void reverseRows(int[][] a, int r, int c) {
		for (int i = 0; i < r; i++)
			reverseArray(a[i]);
	}

	private static void reverseArray(int[] arr) {
		int temp;
		for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

}
