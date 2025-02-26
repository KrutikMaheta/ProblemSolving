//  https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
//  Solution Explanation: https://www.youtube.com/watch?v=qV6QpxpRTLo&ab_channel=Techdose

package acd_prefixarray;

public class Ad_CountSubArrayWithOddSum {

    //  O + O / O - O = E
    //  E + E / E - E = E
    //  O + E / O - E = O

    //  If we know the answer till index i, we can build the answer for i + 1. -> DP Problem
    //  We use prefix sums to count the number of odd-sum subarrays efficiently. Instead of storing the actual prefix sums,
    //  we keep track of: oddCount → The number of prefix sums that are odd.
    //  Why track odd and even prefix sums?
    //  Let's say you have a prefix sum at index i:
    //  1. If this sum is odd, then the number of valid subarrays that end at i = Number of even prefix sums before it (since odd - even = odd).
    //  2. If this sum is even, then the number of valid subarrays that end at i  = Number of odd prefix sums before it (since even - odd = odd).
    //  return the answer % (10^9 + 7)
    //  TC: O(N); SC: O(1)
    private static int noOfSubarraysWithOddSum(int[] arr) {
        int oddCount = 0, evenCount = 1, result = 0, prefixSum = 0, mod = 1000000007;
        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 == 0) {
                result = (result + oddCount) % mod;
                evenCount++;
            } else {
                result = (result + evenCount) % mod;
                oddCount++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //int[] arr = {3, 2, 4, 1, 2, 5};
        int[] arr = {2, 6, 4, 10, 8};
        System.out.println(noOfSubarraysWithOddSum(arr));
    }

}
