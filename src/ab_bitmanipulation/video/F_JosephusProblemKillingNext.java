//  The Josephus Problem is a famous theoretical problem related to a group of people standing in a circle and
//  eliminating every k-th person until only one remains.
//  In this case, we assume k = 2, meaning each person kills the one standing next to them.

package ab_bitmanipulation.video;

import aa_basicmaths.modulararithmetic.Ad_JosephusProblem;

public class F_JosephusProblemKillingNext {

    //

    /**
     * For K = 2, the solution is, Josephus(n)=2×(n−L)+1 -> Where L is the value obtained after removing the most significant bit (MSB) from n.
     * For generic K, {@link Ad_JosephusProblem}
     */
    private static int josephus(int n) {
        // Find the largest power of 2 ≤ n
        int highestPowerOf2 = highestPowerOf2(n);
        System.out.println(highestPowerOf2);
        return ((n - highestPowerOf2) << 1) + 1; // Josephus formula for k=2
    }

    // Custom function to find highest power of 2 ≤ n
    //  TC: O(Log N)
    private static int highestPowerOf2(int n) {
        if (n == 0) {
            return 0;
        }
        int MSB = 1;
        while (MSB <= n) {
            MSB = MSB << 1; // Shift left until it surpasses num
        }

        return MSB >> 1;    // Shift back once to get correct power of 2
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println("The winner's position is: " + josephus(n));
    }

}
