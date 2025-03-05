// Special index is the index when removed then in the resulting array
// sum of the elements in the even index = sum of the elements in the odd index.
package acd_prefixarray;

import java.util.stream.IntStream;

public class Ah_SpecialIndex {

    //  Whenever element at index i is removed, even and odd positions of all elements at index 0 to i-1 remains intact &
    //  all elements after i will have index changed from odd to even and even to odd.
    //  Maintain to EvenPrefixSum & OddPrefixSum
    //  TC: O(N); SC: O(N)
    private static void findSpecialIndex(int[] arr) {
        int n = arr.length;
        int[] ops = new int[n];
        int[] eps = new int[n];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                eps[i] = (i != 0) ? eps[i - 2] + arr[i] : arr[i];
                ops[i] = (i != 0) ? ops[i - 1] : 0;
            } else {
                eps[i] = eps[i - 1];
                ops[i] = (i != 1) ? ops[i - 2] + arr[i] : arr[i];
            }
        }

        for (int i = 0; i < n; i++) {
            int los = (i != 0) ? ops[i - 1] : 0;
            int les = (i != 0) ? eps[i - 1] : 0;

            int ros = ops[n - 1] - ops[i];
            int res = eps[n - 1] - eps[i];

            if (los + res == les + ros) {
                System.out.println(i);
            }
        }
    }

    //  TC: O(N); SC: O(1)
    private static void findSpecialIndexSpaceOptimized(int[] arr) {
        int n = arr.length;
        int res = IntStream.range(0, n).filter(i -> i % 2 == 0).map(i -> arr[i]).sum();
        int ros = IntStream.range(0, n).filter(i -> i % 2 != 0).map(i -> arr[i]).sum();

        int los = 0, les = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                res -= arr[i];
                if (les + ros == los + res) {
                    System.out.println(i);
                }
                les += arr[i];
            } else {
                ros -= arr[i];
                if (les + ros == los + res) {
                    System.out.println(i);
                }
                los += arr[i];
            }
        }
    }


    public static void main(String[] args) {
        //int[] arr = {5, 5, 2, 5, 8};
        int[] arr = {2, 1, 6, 4};
        findSpecialIndex(arr);
        findSpecialIndexSpaceOptimized(arr);
    }

}
