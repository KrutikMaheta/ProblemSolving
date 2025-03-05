package ace_slidingwindow;

public class Ac_PickElements {
    public static void main(String[] args) {
        System.out.println(pickElementsWithMaxSum(new int[]{-1, 100, 200, 4, 3, 2, 1}, 3));
    }

    private static int pickElementsWithMaxSum(int[] arr, int K) {
        int N = arr.length;
        int currSum = 0;

        // Calculate the initial sum by picking first K elements from the left
        for (int i = 0; i < K; i++) {
            currSum += arr[i];
        }

        // Set the maxSum initially as the sum of first K elements from the left
        int maxSum = currSum;

        // Now, iteratively swap elements from the left with elements from the right
        for (int i = 0; i < K; i++) {
            currSum = currSum - arr[K - 1 - i] + arr[N - 1 - i];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
