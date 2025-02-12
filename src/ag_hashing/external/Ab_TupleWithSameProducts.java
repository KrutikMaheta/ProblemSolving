//  https://leetcode.com/problems/tuple-with-same-product/description/

package ag_hashing.external;

import java.util.HashMap;
import java.util.Map;

public class Ab_TupleWithSameProducts {

    //  1. Each pair (i, j) contributes to the productCount map.
    //  2. We iterate over unique products and compute the result in constant time per product.
    //  If a product appears count times, we can form count * (count - 1) / 2 ways to choose two distinct pairs.
    //  product with count = 1 is useless for us, we can ignore the same.
    //  Each valid tuple has 8 permutations (swapping order of pairs and numbers).
    //  TC: O(N^2)
    public static int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }

        for (Integer product : map.keySet()) {
            int count = map.get(product);
            if (count > 1) {
                result += ((count * (count - 1)) / 2) * 8;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 6};
        System.out.println((tupleSameProduct(nums)));
    }
}
