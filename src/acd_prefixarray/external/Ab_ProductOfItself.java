package acd_prefixarray.external;

import java.util.Arrays;

public class Ab_ProductOfItself {

    //  TC: O(N)
    //  SC: O(N)
    private static int[] productOfItself(int[] arr) {
        int n = arr.length;
        int[] prefixProd = new int[n];
        int[] suffixProd = new int[n];

        Arrays.fill(prefixProd, 1);
        Arrays.fill(suffixProd, 1);

        int curProd = arr[0];
        for (int i = 1; i < n; i++) {
            prefixProd[i] = curProd;
            curProd *= arr[i];
        }

        curProd = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixProd[i] = curProd;
            curProd *= arr[i];
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = prefixProd[i] * suffixProd[i];
        }

        return result;
    }

    //  TC: O(N)
    //  SC: O(1)
    private static int[] productOfItselfSpaceOptimized(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Compute prefix products and store them in result array
        result[0] = 1;  // No elements to the left of index 0
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Compute suffix products on-the-fly and multiply with prefix products
        int suffixProd = 1;  // No elements to the right of last index
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffixProd;
            suffixProd *= nums[i];
        }

        return result;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productOfItself(arr)));
        System.out.println(Arrays.toString(productOfItselfSpaceOptimized(arr)));

        int[] arr1 = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productOfItself(arr1)));
        System.out.println(Arrays.toString(productOfItselfSpaceOptimized(arr1)));

    }


}
