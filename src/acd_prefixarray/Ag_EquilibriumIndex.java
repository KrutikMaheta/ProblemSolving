// Index which has sum of the left elements in array equals the sum of the right elements in array.

package acd_prefixarray;

import java.util.stream.IntStream;

public class Ag_EquilibriumIndex {
    public static void main(String[] args) {
        //int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        int[] arr = {1, 2, 3, 4, 3, 2, 1};
        System.out.println(findEquilibriumIdx(arr));
        findEquilibriumIdxSpaceOptimized(arr);

    }

    // TC: O(N) ; SC: O(N)
    private static int findEquilibriumIdx(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (int i = 1; i <= n; i++) {
            int ls = prefix[i - 1];
            int rs = prefix[n] - prefix[i];
            if (ls == rs) {
                return i - 1;
            }
        }

        return -1;
    }

    // TC: O(N) ; SC: O(1)
    // We actually don't need to store the prefix sum
    // We can maintain 2 variables of Leftsum and Rightsum like Aa_PickElements.java
    private static void findEquilibriumIdxSpaceOptimized(int[] arr) {
        int sum = IntStream.of(arr).sum();
        int RS = sum;
        int LS = 0;
        for (int i = 0; i < arr.length; i++) {
            if (RS - arr[i] == LS) {
                System.out.println(i);
            }
            LS += arr[i];
            RS -= arr[i];
        }
    }
}
