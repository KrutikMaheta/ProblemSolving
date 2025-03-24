//  https://leetcode.com/problems/koko-eating-bananas/
package ai_searching.external;

import java.util.Arrays;

public class Ad_KokoEatingBananas {

    //  TC: N * log(max-min)
    //  SC : O(1)
    private static int minSpeed(int[] arr, int hours) {
        //  The minimum possible eating speed k is 1, should not be the minimum pile size
        //  For example, if all piles are large but the available time h is very high,
        //  Koko might still need to eat at k=1.
        //int l = Arrays.stream(arr).min().getAsInt();
        int l = 1;
        int r = Arrays.stream(arr).max().getAsInt();
        int ans = r;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (isPossibleAnswer(m, arr, hours)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }

    //  k -> speed
    private static boolean isPossibleAnswer(int k, int[] arr, int hours) {
        int totalHours = 0;

        for (int p : arr) {
            //  No need of this while loop
            /* while (p > 0) {
                p -= k;
                totalHours++;
            }*/
            // instead we can calculate inline.
            totalHours += p / k;
            if (p % k != 0) {
                totalHours++;
            }

            if (totalHours > hours) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 11};
        int hours = 8;
        System.out.println(minSpeed(arr, hours));

        int[] arr1 = {30, 11, 23, 4, 20};
        hours = 5;
        System.out.println(minSpeed(arr1, hours));
    }

}