package aa_basicmaths;

// If the given number is not a perfect square, its factors always appears in pairs
// but if the number is perfect square, except its square root all other factors appear in pairs.
// So if there is no factor in the range of 2 to sqrt(N) then there won't be any factor from sqrt(N) + 1 to N

// 24 -> 1,2,3,4,6,8,12,24
// 16 -> 1,2,4,8,16
public class A_PrimeNumber {

    public static void main(String[] args) {
        System.out.println(isPrime(27));
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
