package aa_basicmaths;

import java.util.stream.IntStream;

public class F_FindMissingRepeating {
    public static void main(String[] args) {
        findMissingRepeating(new int[]{4, 3, 6, 2, 1, 1});
    }

    private static void findMissingRepeating(int[] arr) {
        int n = arr.length;

        // Note : Use long in order to avoid the overflow in case of large numbers

        // Calculate the expected sum and sum of squares for numbers from 1 to n
        long expectedSum = (n * (n + 1)) / 2;
        long expectedSumSq = (n * (n + 1) * (2 * n + 1)) / 6;

        // Calculate actual sum and sum of squares from the array
        long actualSum = IntStream.of(arr).sum();
        long actualSumSq = IntStream.of(arr).map(num -> num * num).sum();

        // Differences between expected and actual sums
        long sumDiff = expectedSum - actualSum; // missing - repeating
        long sumSqDiff = expectedSumSq - actualSumSq; // missing^2 - repeating^2

        // Solve the equations to find the missing and repeating numbers
        long missingPlusRepeating = sumSqDiff / sumDiff;

        long missing = (missingPlusRepeating + sumDiff) / 2;
        long repeating = missingPlusRepeating - missing;

        System.out.println("Missing number: " + missing);
        System.out.println("Repeating number: " + repeating);
    }
}
