package ach_contribution;

public class Aa_SumOfPossibleSubArrays {

    //  Approach:
    //  The element arr[i] appears in (i + 1) * (n - i) subarrays.
    //  Therefore, the total sum is calculated by summing arr[i] * (i + 1) * (n - i) for all i.
    //  TC: O(N)
    private static int sumOfAllSubArrays(int[] arr) {
        int sum = 0, n = arr.length;

        for (int i = 0; i < n; i++) {
            sum += ((i + 1) * (n - i) * arr[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(sumOfAllSubArrays(arr));
    }

}
