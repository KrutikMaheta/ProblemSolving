package acd_prefixarray;

import java.util.HashMap;
import java.util.Map;

public class Acc_SubarrayWithXORK {

    private static int countSubArrayWithXORK(int[] arr, int k) {
        int prefixXOR = 0, count = 0;
        Map<Integer, Integer> prefixXORMap = new HashMap<>();

        prefixXORMap.put(prefixXOR, 1);

        for (int num : arr) {
            prefixXOR ^= num;
            count += prefixXORMap.getOrDefault(prefixXOR ^ k, 0);
            prefixXORMap.put(prefixXOR, prefixXORMap.getOrDefault(prefixXOR, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int K = 6;
        System.out.println(countSubArrayWithXORK(arr, K));
    }

}
