package ai_searching;

public class Ag_AggressiveCows {

    /**
     * Binary search helper function to find the first position >= X in the array.
     * This is equivalent Ab_LowerBound
     */
    private static int lowerBound(int[] arr, int X) {
        int s = 0;
        int e = arr.length - 1;

        if (arr[e] < X) {
            return -1;
        }

        while (s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] < X) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return s;   // 's' is the first position >= X
    }

    private static boolean isPossibleSolution(int diff, int[] arr, int noOfCows) {
        int position = 0;  // First cow is placed at index 0
        noOfCows--;

        for (int i = 0; i < noOfCows; i++) {
            position = lowerBound(arr, arr[position] + diff);   // Find next valid stall
            if (position == -1) {
                return false;   // No valid placement found
            }
        }
        return true;    // All cows placed successfully
    }

    //  TC: O(C * log C * log M); c = #cows, M = max-min
    private static int maxDistanceBetweenClosestCows(int[] arr, int noOfCows) {
        int len = arr.length;
        int s = 0;
        int e = arr[len - 1] - arr[0];
        int ans = -1;

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (isPossibleSolution(m, arr, noOfCows)) {
                ans = m;    // Store the valid answer and try for a larger distance
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {4, 8, 11, 15, 18, 24};
        //int[] arr = {1, 2, 4, 8, 9};
        //int noOfCows = 3;

        //int[] arr = {1, 100, 200, 300, 400, 500};
        int noOfCows = 3;
        System.out.println(maxDistanceBetweenClosestCows(arr, noOfCows));
    }

}
