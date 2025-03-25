package aa_basicmaths.gcd;

public class A_CalculateGCD {
    public static void main(String[] args) {
        System.out.println(findGCD(15, 10));
        System.out.println(findGCD2(24, 48));
        System.out.println(findGCD3(34, 55));
    }

    // TC: O(min(A,B)); O(N)
    private static int findGCD(int num1, int num2) {
        int min = Math.min(num1, num2);
        for (int i = min; i > 0; i--) {
            if (num1 % i == 0 && num2 % i == 0) {
                return i;
            }
        }
        return 1;
    }

    // TC: O(sqrt(min(A,B))) ; O(sqrt(N))
    public static int findGCD2(int num1, int num2) {
        int min = Math.min(num1, num2);
        int gcd = 1;
        for (int i = (int) Math.sqrt(min); i > 0; i--) {
            int d1 = i;
            if (num1 % d1 == 0 && num2 % d1 == 0) {
                gcd = Math.max(gcd, i);
            }

            int d2 = min / i;
            if (num1 % d2 == 0 && num2 % d2 == 0) {
                gcd = Math.max(gcd, (min / i));
            }
        }
        return gcd;
    }

    // TC: O(log(min(A,B))) ; O(logN)
    public static int findGCD3(int num1, int num2) {
        int min = Math.min(num1, num2);
        int max = Math.max(num1, num2);

        while (min > 0) {
            max = max % min;
            // Swapping numbers
            max = max ^ min;
            min = max ^ min;
            max = max ^ min;
        }
        return max;
    }
}
