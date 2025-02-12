// Google Interview: Given an array of integers A, count all (i, j) pairs that makes Ai - Aj = j - i
//  e.g. 3 2 1 2 3
//  (0,1), (0,2), (1,4)
package ag_hashing.external;

import java.util.HashMap;
import java.util.Map;

public class Ad_CountPairs {
    public static void main(String[] args) {
        //int[] arr = {3, 2, 1, 2, 3};
        int[] arr = {3, 2, 1, 0};
        System.out.println(countPairs(arr));
    }

    private static int countPairs(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = i + arr[i];
            if (map.containsKey(sum)) {
                count += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
