//  2594. Minimum Time to Repair Cars
//  https://leetcode.com/problems/minimum-time-to-repair-cars/description/

package ai_searching.external;

import java.util.Arrays;

public class Ac_MinTimeToRepairCars {

    //  Time: O(n log(max_time)) where n = number of mechanics
    //  Space: O(1) (no additional data structures used)
    private static long minTimeToRepairCars(int[] ranks, int cars) {
        int minRank = Arrays.stream(ranks).min().getAsInt();
        int maxRank = Arrays.stream(ranks).max().getAsInt();

        // Minimum possible time
        long left = minRank;
        // Maximum possible time
        long right = (long) maxRank * cars * cars;  // Cast to long to prevent overflow
        long ans = right;

        while (left <= right) {
            long m = left + (right - left) / 2;
            if (isPossibleToRepairInTime(ranks, cars, m)) {
                ans = m;
                right = m - 1;
            } else {
                left = m + 1;
            }
        }

        return ans;
    }

    private static boolean isPossibleToRepairInTime(int[] ranks, int cars, long time) {
        for (int rank : ranks) {
            // Use long to prevent overflow
            long carsRepaired = (long) Math.sqrt(time / rank);
            cars -= carsRepaired;
            if (cars <= 0) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] ranks = {4, 2, 3, 1};
        int cars = 10;
        System.out.println(minTimeToRepairCars(ranks, cars));

        int[] ranks2 = {5, 1, 8};
        cars = 6;
        System.out.println(minTimeToRepairCars(ranks2, cars));

    }

}
