package ai_searching;


public class Ab_SquareRoot {
    public static void main(String[] args) {
        int num = 10;
        System.out.println("Square root of : " + num + " -> " + calculateSquareRoot(num));
        num = 2147395600;
        System.out.println("Square root of : " + num + " -> " + calculateSquareRoot(num));
    }

    // Time Complexity -> Log(N)
    private static int calculateSquareRoot(int num) {
        if (num < 2) return num; // Handle 0 and 1 as special cases

        int l = 1, r = num, result = 0;

        while (l <= r) {
            int m = l + (r - l) / 2;    // Prevents integer overflow
            long square = (long) m * m; // Use long to prevent overflow

            if (square == num) {
                return m;   // Perfect square root found
            } else if (square < num) {
                result = m; // Store possible answer
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        // Floor value of sqrt(num)
        return result;
    }
}
