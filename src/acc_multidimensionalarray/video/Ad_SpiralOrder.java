package acc_multidimensionalarray.video;

public class Ad_SpiralOrder {

    public static void main(String[] args) {
        //int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int a[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        spiralTraversal(a, a.length, a[0].length);
    }

    private static void spiralTraversal(int[][] a, int n, int m) {
        int L = 0, T = 0;
        int R = m - 1;
        int B = n - 1;

        while (L <= R && T <= B) {
            for (int i = L; i <= R; i++) {
                System.out.print(a[T][i] + " ");
            }
            T++;

            for (int i = T; i <= B; i++) {
                System.out.print(a[i][R] + " ");
            }
            R--;

            if (T <= B) {
                for (int i = R; i >= L; i--) {
                    System.out.print(a[B][i] + " ");
                }
                B--;
            }

            if (L <= R) {
                for (int i = B; i >= T; i--) {
                    System.out.print(a[i][L] + " ");
                }
                L++;
            }
        }
    }

}
