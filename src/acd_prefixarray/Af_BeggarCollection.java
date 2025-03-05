package acd_prefixarray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Af_BeggarCollection {
    public static void main(String[] args) {
        Map<int[], Integer> map = new HashMap<>();
        map.put(new int[]{1, 3}, 5);
        map.put(new int[]{0, 2}, 10);
        map.put(new int[]{3, 4}, 5);

        int totalBeggars = 5;
        calculateBeggarCollection(map, totalBeggars);
    }

    // O(Q) + O(N)
    private static void calculateBeggarCollection(Map<int[], Integer> map, int beggars) {
        int[] arr = new int[beggars];
        int[] prefixArray = new int[beggars];

        map.forEach((k, v) -> {
            arr[k[0]] += v;
            if (k[1] + 1 < beggars) {
                arr[k[1] + 1] -= v;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            prefixArray[i] = (i != 0) ? prefixArray[i - 1] + arr[i] : arr[i];
        }

        System.out.println(Arrays.toString(prefixArray));

    }
}
