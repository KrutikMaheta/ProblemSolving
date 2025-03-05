package ace_slidingwindow;

public class Ad_SubArrWithLeastAvg {
    public static void main(String[] args) {
        int K = 3;
        int[] arr = {3, 7, 90, 20, 10, 50, 40};
        //int[] arr = {8, 9, 1, 2, 3, 4, 5};
        findSubArrayWithLeastAvg(arr, K);
        findSubArrayWithLeastAvgSW(arr, K);
    }

    // Sliding Window Approach ; SC: O(1) ; TC: O(N)
    private static void findSubArrayWithLeastAvgSW(int[] arr, int k) {
        int sum = 0;
        int minSum;
        int rightIdx = -1;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        minSum = sum;

        for (int i = k; i < arr.length; i++) {
            sum = sum + arr[i] - arr[i - k];
            if (minSum > sum) {
                minSum = sum;
                rightIdx = i;
            }
        }
        System.out.println("[" + (rightIdx - k + 1) + "," + rightIdx + "]");
    }

    // Using PrefixSum -> SC: O(N); TC: O(N)
    private static void findSubArrayWithLeastAvg(int[] arr, int k) {
        int len = arr.length;
        int[] prefixSum = new int[len];

        for (int i = 0; i < len; i++) {
            prefixSum[i] = (i != 0) ? prefixSum[i - 1] + arr[i] : arr[i];
        }

        int minAvg = Integer.MAX_VALUE;
        int newAvg;
        int minAvgIdx = -1;
        for (int i = k - 1; i < len; i++) {
            if (i - k > 0) {
                newAvg = (prefixSum[i] - prefixSum[i - k]) / k;
            } else {
                newAvg = prefixSum[i] / k;
            }

            if (minAvg > newAvg) {
                minAvg = newAvg;
                minAvgIdx = i;
            }
        }
        System.out.println(minAvgIdx - k + 1 + "," + minAvgIdx);

    }
}
