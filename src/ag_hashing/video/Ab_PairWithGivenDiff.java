/**
 * 1) Initialize count as 0.
 * 2) Insert all distinct elements of arr[] in a hash map.  While inserting,
 * ignore an element if already present in the hash map.
 * 3) Do following for each element arr[i].
 * a) Look for arr[i] + k in the hash map, if found then increment count.
 * b) Look for arr[i] - k in the hash map, if found then increment count.
 * c) Remove arr[i] from hash table.
 */

package ag_hashing.video;

import java.util.HashSet;

public class Ab_PairWithGivenDiff {

    public static void main(String[] args) {
        int a[] = {10, 12, 10, -10, 0};
        System.out.println(countPairWithGivenDiff(a, -10));
    }

    public static int countPairWithGivenDiff(int[] arr, int k) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        k = Math.abs(k);
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i + k)) {
                System.out.println("Pair found: (" + i + ", " + (i + k) + ")");
                count++;
            }
            if (set.contains(i - k)) {
                System.out.println("Pair found: (" + i + ", " + (i - k) + ")");
                count++;
            }
            set.add(i);
        }
        return count;
    }

}