package aa_basicmaths.modulararithmetic;

import java.util.Arrays;

public class Aa_ReplaceWithIdx {
    public static void main(String[] args) {
        int[] arr = {3, 2, 0, 1};
        System.out.println("Before: " + Arrays.toString(arr));
        replaceWithIdx(arr);
        System.out.println("After: " + Arrays.toString(arr));
    }

    //  Approach: This approach modifies the array in-place without using extra space, leveraging the mathematical encoding technique.
    //  Encoding:
    //  Since arr[i] needs to be updated to arr[arr[i]], we must preserve the old value while storing the new value.
    //  We do this by encoding two values in one integer using the formula:
    //  arr[i]=arr[i]+(arr[arr[i]]%n)∗ n
    //  Here,
    //  -> arr[i] % n retrieves the original value (before modification).
    //  -> arr[arr[i]] % n gives us the new value we need to set.
    //  -> Multiplying by n ensures the new value can be extracted later.
    //  Decoding:
    //  Since each element now stores both the old and new values, we extract the new value by: arr[i]=arr[i]/n
    //  TC: O(N); SC: O(1)
    private static void replaceWithIdx(int[] arr) {
        int n = arr.length;

        // Step 1: Encode both old and new values in the same array
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] + (arr[arr[i]] % n) * n;
        }

        System.out.println("Intermediate: " + Arrays.toString(arr));

        // Step 2: Extract the new values
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / n;
        }

    }
}
