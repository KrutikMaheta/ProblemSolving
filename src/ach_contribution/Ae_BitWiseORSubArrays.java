package ach_contribution;

public class Ae_BitWiseORSubArrays {
    public static void main(String[] args) {
        int[] arr = {5, 14, 9, 1};
        System.out.println(sumOfBitWiseOfOfAllSubArrays(arr));
    }

    //  Approach:
    //  This solution calculates the sum of bitwise OR of all sub-arrays by iterating over each bit position (0 to 31).
    //  For each bit, it counts how many sub-arrays do not contribute to the sum because they have zeros in that bit position.
    //  The sum is then calculated by multiplying the value of the bit by the number of contributing subarrays.
    private static int sumOfBitWiseOfOfAllSubArrays(int[] nums) {
        int sum = 0, n = nums.length;
        int totalSubArrays = (n * (n + 1)) / 2; // Total possible sub-arrays.

        for (int i = 0; i < 32; i++) {
            int zeroStreak = 0, invalidSubArrays = 0, bitMask = 1 << i;

            for (int num : nums) {
                if ((num & bitMask) == 0) {
                    zeroStreak++;   // Count of consecutive zeros
                } else {
                    // Calculate the number of invalid subarrays due to the current zero streak
                    invalidSubArrays += (zeroStreak * (zeroStreak + 1)) / 2;
                    zeroStreak = 0; // Reset the zero streak
                }
            }

            // Handle any remaining zeros at the end of the array
            invalidSubArrays += (zeroStreak * (zeroStreak + 1)) / 2;

            // Add the contribution of the current bit to the total sum
            sum += (1 << i) * (totalSubArrays - invalidSubArrays);
        }

        return sum;
    }
}
