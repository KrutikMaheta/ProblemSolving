package acd_prefixarray;

import java.util.HashMap;

public class Ad_LargestSubArrWithEq0s1s {

    public static void main(String[] args) {
        int arr[] = {1, 0, 1, 1, 1, 0, 0};
        //int arr[] = { 0, 0, 1, 1, 0 };
        largestSubArrWithEq0s1s(arr);
    }

    private static void largestSubArrWithEq0s1s(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                arr[i] = -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] prefixArr = new int[arr.length];
        int maxLenSA = Integer.MIN_VALUE;
        int si = 0;
        int ei = -1;

        for (int i = 0; i < arr.length; i++) {
            prefixArr[i] = (i != 0) ? prefixArr[i - 1] + arr[i] : arr[i];

            if (prefixArr[i] == 0) {
                si = 0;
                ei = i;
                maxLenSA = Integer.max(maxLenSA, i);
            } else if (map.containsKey(prefixArr[i])) {
                if ((ei - si) < i - map.get(prefixArr[i])) {
                    si = map.get(prefixArr[i]) + 1;
                    ei = i;
                }
            } else {
                map.put(prefixArr[i], i);
            }
        }
        System.out.println(si + ":" + ei);
    }

}
