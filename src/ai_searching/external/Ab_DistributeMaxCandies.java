//  https://leetcode.com/problems/maximum-candies-allocated-to-k-children/
//  2226. Maximum Candies Allocated to K Children

package ai_searching.external;

import java.util.Arrays;

public class Ab_DistributeMaxCandies {

    //  TC: O(N * log (sum/k))
    private static int maxCandies(int[] candies, long k) {
        //  total candies
        long sum = Arrays.stream(candies).sum();

        // If the total number of candies is less than k, return 0
        if (sum < k) return 0;

        //  Define the min and max possible candies can be given to child
        long l = 1, r = sum / k;
        int answer = 0;

        //  Run binary search on answer range.
        while (l <= r) {
            long m = l + (r - l) / 2;

            // Check if it's possible to allocate k sub-piles of size m
            if (isPossibleAnswer(candies, k, m)) {
                // If possible, update the answer and explore the possibility of bigger answer
                answer = (int) m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return answer;
    }

    private static boolean isPossibleAnswer(int[] candies, long k, long m) {
        long count = 0;
        for (int x : candies) {
            // Calculate how many sub-piles of size m can be formed from this pile
            count += x / m;

            // If we have enough sub-piles, return true immediately
            if (count >= k) {
                return true;
            }
        }

        // If we've checked all piles and still don't have enough sub-piles, return false
        return count >= k;
    }

    public static void main(String[] args) {
        int[] candies = {5, 8, 6};
        int k = 3;
        System.out.println(maxCandies(candies, k));

        int[] candies2 = {1000, 1000, 1000, 1000, 1000};
        k = 10;
        System.out.println(maxCandies(candies2, k));
    }

}
