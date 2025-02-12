package acd_prefixarray;

import java.util.HashMap;

public class Ab_SubArrayWithSumZero {

    public static void main(String[] args) {
        //int arr[] = {7, 1, 3, -2, 4, -1, 0, -1, 18};
        //int arr[] = { 3, 2, 1, -4, -2, 16, 10 };
        int arr[] = {-1, -1, 1, 1, -1}; // For this case, consider having; HashMap<Integer, List<Integer>>
        subArrayWithSumZero(arr);
    }


    /**
     * 1. Create an prefix array for each element in the array. [Prefix array -> sum of element till that element]
     * [7,8,11,9,13,12,12,11]
     * 2. Whenever we have repetition in the prefix array; that means we found the sub array with sum = 0
     * 3. Create an prefix temp array and while creating store it in the hashmap along with the index.
     * 4. whenever repetition occurred, we can fetch the index from the hashmap and from that index + 1 to current index will
     * be the subarray with sum = 0
     * <p>
     * Note: Whenever prefix sum array has 0 that also means from 0th index to till that element subarray sum = 0
     * O(N)
     *
     * @param arr
     */
    private static void subArrayWithSumZero(int[] arr) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int[] prefixArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            prefixArray[i] = (i != 0) ? arr[i] + prefixArray[i - 1] : arr[i];
            if (prefixArray[i] == 0) {
                System.out.println("Subarray with sum 0 = [" + 0 + "," + i + "]");
            } else if (hashmap.get(prefixArray[i]) != null) {
                System.out.println("Subarray with sum 0 = [" + (hashmap.get(prefixArray[i]) + 1) + "," + i + "]");
            } else {
                hashmap.put(prefixArray[i], i);
            }
        }
    }

}
