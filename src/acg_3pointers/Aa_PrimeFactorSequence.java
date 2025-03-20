// Given 3 prime numbers generate the sequence in sorted order which has these prime numbers only as factors without using heap

package acg_3pointers;

import java.util.ArrayList;
import java.util.List;

public class Aa_PrimeFactorSequence {
    public static void main(String[] args) {
        int p1 = 5, p2 = 3, p3 = 2;

        System.out.println(generatePrimeFactorSeq(p1, p2, p3, 20));
    }

    private static List<Integer> generatePrimeFactorSeq(int p1, int p2, int p3, int len) {
        List<Integer> result = new ArrayList<>();
        int pt1 = 0, pt2 = 0, pt3 = 0; // Pointers for the three primes
        int p1m = p1, p2m = p2, p3m = p3; // First candidate multiple of p1,p2,p3

        result.add(1); // Start with 1

        for (int i = 0; i < len; i++) {
            // Find the smallest among the next multiples
            int next = Math.min(p1m, Math.min(p2m, p3m));
            result.add(next);

            // Update the respective pointer(s)
            if (next == p1m) {
                pt1++;
                p1m = result.get(pt1) * p1;
            }
            if (next == p2m) {
                pt2++;
                p2m = result.get(pt2) * p2;
            }
            if (next == p3m) {
                pt3++;
                p3m = result.get(pt3) * p3;
            }
        }

        return result;


    }
}
