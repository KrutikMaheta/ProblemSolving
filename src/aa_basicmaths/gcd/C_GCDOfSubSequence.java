// For the given array if any of the sub-sequence has GCD as 1, return true else return false.

package aa_basicmaths.gcd;

public class C_GCDOfSubSequence {
    public static void main(String[] args) {
        int[] arr = {10, 6, 16, 24, 48};
        System.out.println(gcdOfSubSequence(arr));

        int[] arr1 = {10, 6, 15, 24, 48};
        System.out.println(gcdOfSubSequence(arr1));
    }

    // The code doesn't explicitly check all subsequences, but leverages the fact that if the GCD of the entire array is 1,
    // then a subsequence of gcd 1 exists.
    // GCD(A,B,C) >= GCD(A,B,C,D)
    // TC: O(NlogN)
    private static int gcdOfSubSequence(int[] arr) {
        int gcd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            gcd = A_CalculateGCD.findGCD3(gcd, arr[i]);
        }
        return gcd == 1 ? 1 : 0;
    }
}
