//  GCD of factorials of array elements.
package aa_basicmaths.gcd;

import java.util.Arrays;

public class B_GCDOfFactorial {

    private static int gcdOfFactorial(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();

        // factorial of 0 or 1 is 1.
        if (min <= 1) {
            return 1;
        }

        int minFactorial = factorial(min);

        // All factorials greater than or equal to min! are divisible by min!
        // So the GCD of the factorials is min!
        return minFactorial;
    }

    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6};
        System.out.println(gcdOfFactorial(arr));
    }


}
