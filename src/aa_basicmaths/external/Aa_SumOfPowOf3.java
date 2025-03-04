//  https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
//  Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.

package aa_basicmaths.external;

public class Aa_SumOfPowOf3 {

    //  Exponential
    private static boolean isSumOfPowOf3UnOptimized(int n) {
        int i = 1;
        while (true) {
            String binary = Integer.toBinaryString(i);
            int power3Rep = pow3Representation(binary);
            if (power3Rep == n) {
                return true;
            } else if (power3Rep > n) {
                return false;
            }
            i++;
        }
    }

    private static int pow3Representation(String binary) {
        int num = 0;
        int n = binary.length() - 1;
        for (int i = n; i >= 0; i--) {
            int temp = binary.charAt(i) - '0';
            if (temp != 0) {
                num = num + (int) Math.pow(3, n - i);
            }
        }
        return num;
    }

    //  Base 3 representation -> (1201)3 = (1 * 3^3) + (2 * 3^2) + (0 * 3^1) + (1 * 3^0)
    //  1. If a number is a sum of distinct powers of 3, it can only use the coefficients 0 or 1 (not 2).
    //  2. This is because using a 2 in base-3 would mean you need two of the same power of 3  which violates unique powers constraint.
    //  TC: O(log N)
    private static boolean isSumOfPowOf3(int n) {
        while (n > 0) {
            // If the remainder is 2, it means we need a coefficient 2, which is not allowed
            if (n % 3 == 2) {
                return false;
            }
            // Reduce `n` by dividing it by 3
            n = n / 3;
        }

        // If no `2` was encountered, it is a valid sum of powers of 3
        return true;
    }

    public static void main(String[] args) {
        int n = 91;
        System.out.println(isSumOfPowOf3(n));

        n = 21;
        System.out.println(isSumOfPowOf3(n));

        System.out.println(isSumOfPowOf3UnOptimized(n));
    }


}
