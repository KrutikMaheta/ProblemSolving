//  Leetcode 2964
//  counting number of triplets divisible by k
//  (a + b + c) % d == (a % d + b % d + c % d) % d;

package ag_hashing.external;

import java.util.HashMap;
import java.util.Map;

public class Aa_TripletDivisibleByK {


    //  Algo:
    //  1. Create a hash map remainderCount to store the frequency of each remainder when elements of nums are divided by d.
    //  2. Use two nested loops to iterate through pairs of indices j and k where j<k.
    //  For each pair (j,k), calculate the sum of nums[j] and nums[k], then determine the required remainder that,
    //  when added to this sum, makes it divisible by d.
    //  Check if this required remainder exists in remainderCount. If it does, add the frequency of this remainder to the count of valid triplets.
    //  After processing each pair (j,k), update remainderCount with the remainder of nums[j] modulo d.
    //  TC: O(N^2)
    //  SC: O(N)
    public static int countOfTripletsDivByK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int requiredRemainder = (k - (arr[i] + arr[j]) % k) % k;
                count += map.getOrDefault(requiredRemainder, 0);
            }
            map.put(arr[i] % k, map.getOrDefault(arr[i] % k, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, 12, 18};
        int K = 6;
        System.out.println(countOfTripletsDivByK(arr, K));
    }

}
