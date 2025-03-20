// Pick 3 elements (a,b,c) from one from each given sorted array such that
// |max(a,b,c) - min(a,b,c)| is minimized.

package acg_3pointers;

public class Ab_PickEleWithMinDiff {
    public static void main(String[] args) {
        //int[] A = {1, 4, 5, 8, 10};
        int[] A = {20};
        int[] B = {6, 9, 15};
        int[] C = {2, 3, 7, 7};

        System.out.println(minimizedDiff(A, B, C));

    }

    private static int minimizedDiff(int[] A, int[] B, int[] C) {
        int Ai = 0, Bi = 0, Ci = 0;
        int res = Integer.MAX_VALUE;

        while (Ai < A.length && Bi < B.length && Ci < C.length) {

            // Find current minimum, maximum, and their difference
            int max = Math.max(C[Ci], Math.max(A[Ai], B[Bi]));
            int min = Math.min(C[Ci], Math.min(A[Ai], B[Bi]));

            res = Math.min(res, Math.abs(max - min));

            // Move the pointer of the array which has the smallest element
            if (min == A[Ai]) {
                Ai++;
            } else if (min == B[Bi]) {
                Bi++;
            } else {
                Ci++;
            }
        }

        return res;
    }
}
