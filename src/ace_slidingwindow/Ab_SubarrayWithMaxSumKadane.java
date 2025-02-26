package ace_slidingwindow;

public class Ab_SubarrayWithMaxSumKadane {
    //  Kadane's Algorithm
    //  TC: O(N)
    //  SC: O(1)
    private static int maxSumOfSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            maxSum = Integer.max(currSum, maxSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSumOfSubArray(arr));
    }

}
