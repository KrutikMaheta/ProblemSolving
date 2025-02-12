package ag_hashing.video;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ag_PairWithDivisibleByK {
    public static void main(String[] args) {
        //int[] arr = {1, 3, 7, 12, 24, 36, 4, 9};
        int[] arr = {4, 12, 16, 20};
        System.out.println(countPairsWithDivByK(arr, 4));
    }

    private static int countPairsWithDivByK(int[] arr, int k) {
        arr = Arrays.stream(arr).map(element -> element % k).toArray();
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                count = count + map.get(arr[i]);
            } else if (arr[i] % k == 0 && map.containsKey(k)) {
                count = count + map.get(k);
            }
            map.computeIfAbsent(k - arr[i], key -> 0);
            map.computeIfPresent(k - arr[i], (key, val) -> val + 1);
        }

        return count;
    }
}
