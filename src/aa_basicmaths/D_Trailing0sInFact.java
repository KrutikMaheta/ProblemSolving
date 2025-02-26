package aa_basicmaths;

public class D_Trailing0sInFact {
    public static void main(String[] args) {
        System.out.println(trailing0sInFact(30));
    }

    //  Observation:
    //   The key observation is that trailing zeros are produced by factors of 10, and a factor of 10 is made up of 2 × 5.
    //   Since there are always more factors of 2 than factors of 5 in factorials,
    //   we just need to count how many times 5 appears as a factor in numbers from 1 to n.
    //  TC: O(Log5 N)
    private static int trailing0sInFact(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 5;  // Count multiples of 5, 25, 125, etc.
            count += n;
        }
        return count;
    }
}
