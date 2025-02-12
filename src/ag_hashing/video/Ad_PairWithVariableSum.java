/**
 * Given an array find the elements such that a[i]+a[j] = a[p]+a[q] ; i#b#p#q
 */

package ag_hashing.video;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ad_PairWithVariableSum {

    public static void main(String[] args) {
        //int arr[] = { 3, 4, 7, 1, 2, 9, 8 };
         int arr[] = { 3, 7, 7, 1, 2, 2 };
        //int arr[] = {2, 2, 2, 2};
        pairWithVariableSum(arr);
    }

    // O(N^2)
    private static void pairWithVariableSum(int[] arr) {
        HashMap<Integer, List<Pair>> hashmap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int pairSum = arr[i] + arr[j];
                if (hashmap.containsKey(pairSum)) {
                    for (Pair pair : hashmap.get(pairSum)) {
                        if (!pair.equals(new Pair(i, j))) {
                            System.out.println("[" + i + "," + j + "]" + pair);
                        }
                    }
                }
                hashmap.computeIfAbsent(pairSum, k -> new ArrayList<>()).add(new Pair(i, j));
            }
        }
    }

}
