package ag_hashing.video;

import java.util.HashMap;
import java.util.Map;

public class Ae_PairDivisibleByK {
    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 12, 24, 36, 4, 9};
        System.out.println(countPairsWithDivByK(arr, 4));
        arr = new int[]{4, 12, 16, 20};
        System.out.println(countPairsWithDivByK(arr, 4));
        arr = new int[]{1, 3, 7, 9};
        System.out.println(countPairsWithDivByK(arr, 4));
    }

    //  TC: O(N)
    //  SC: O(K); The HashMap stores at most K unique remainders.
    public static int countPairsWithDivByK(int[] nums, int k) {
        int count = 0;
        // Map to store frequency of remainders
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            int mod = num % k;

            // Find complement for valid sum
            // If mod == 0, This means the number is already divisible by k, and
            // it can only form valid pairs with other numbers that also have a remainder of 0.
            int complement = mod == 0 ? 0 : k - mod;


            // If complement exists in the map, it forms a valid pair
            count += freqMap.getOrDefault(complement, 0);

            // Store frequency of current remainder
            freqMap.put(mod, freqMap.getOrDefault(mod, 0) + 1);
        }

        return count;
    }
}
