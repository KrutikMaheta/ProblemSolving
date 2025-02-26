package ace_slidingwindow;

public class Ab_SubarrayWithMaxSumKadane {
    //  Kadane's Algorithm
    //  TC: O(N)
    //  SC: O(1)
    private static int maxSumOfSubArray(int[] arr) {
        int maxSum = arr[0]; // Initialize with first element
        int currSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currSum = Math.max(arr[i], currSum + arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        //int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr = {-7, -3, -6, -2};
        System.out.println(maxSumOfSubArray(arr));
    }

}
