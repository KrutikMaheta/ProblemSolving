package acd_prefixarray;

import java.util.HashMap;
import java.util.Map;

public class Acc_SubarrayXORK {

    private static int countSubArrayWithXORK(int[] arr, int k) {
        int[] prefixXOR = new int[arr.length + 1];
        int count = 0;
        prefixXOR[0] = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixXOR[i + 1] = prefixXOR[i] ^ arr[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i ^ k)) {
                count += map.get(i ^ k);
            }
            map.merge(i, 1, (o, n) -> o + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int K = 6;
        System.out.println(countSubArrayWithXORK(arr, K));
    }

}
