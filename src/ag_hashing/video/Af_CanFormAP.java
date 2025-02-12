/**
 * 1. Find the minimum
 * 2. Find the 2nd Min
 * 3. Find the difference
 * 4. Hash all the array elements
 * 5. Traverse and check if map contains (min + (i * diff)))
 */
package ag_hashing.video;

import java.util.HashMap;
import java.util.HashSet;

public class Af_CanFormAP {

    public static void main(String[] args) {
        int arr[] = {3, 5, 1, 9, 7, 13, 11};
        System.out.println(canFormAP(arr));
    }

    private static boolean canFormAP(int[] arr) {
        int min = findMin(arr);
        int secondMin = findSecondMin(arr, min);
        int diff = secondMin - min;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(min + (i * diff))) {
                return false;
            }
        }
        return true;
    }

    private static int findSecondMin(int[] arr, int min) {
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) {
                continue;
            }
            min2 = Integer.min(min2, arr[i]);
        }

        return min2;
    }

    private static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Integer.min(min, arr[i]);
        }
        return min;
    }

}
