//  Sum of hamming distance of all the pairs.
//  The Hamming distance between two integers is the number of bit positions where the corresponding bits are different.
package ach_contribution;

public class Ad_SumOfHammingDistance {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        System.out.println(sumOfHammingDistances(arr));
    }

    //  TC: O(N)
    private static int sumOfHammingDistances(int[] arr) {
        int sum = 0;

        // Iterate through each bit position (0 to 31)
        for (int i = 0; i < 32; i++) {
            int noOf1s = 0; // Count of numbers with a '1' at the current bit position
            int noOf0s = 0; // Count of numbers with a '0' at the current bit position

            for (int j = 0; j < arr.length; j++) {
                // Check if the i-th bit of arr[j] is set (1)
                if ((arr[j] & (1 << i)) > 0) {
                    noOf1s++;
                } else {
                    noOf0s++;
                }
            }

            // Calculate the contribution of the current bit position to the total Hamming distance
            // 2 * noOf1s * noOf0s: Represents the number of pairs with different bits at the i-th position
            sum += 2 * noOf1s * noOf0s;
        }

        return sum;
    }
}
