// Find the longest increasing subsequence of a given array of integers, A.
// In other words, find a subsequence of array in which the subsequence's elements are in strictly increasing order,
// and in which the subsequence is as long as possible.
// In this case, return the length of the longest increasing subsequence.

package au_dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ah_LongestIncreasingSubsequence {

    //  TC: O(N^2), SC: O(N)
    private static int longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] len = new int[n];
        int[] previous = new int[n];

        // Initialize LIS length and previous pointers
        for (int i = 0; i < n; i++) {
            len[i] = 1;
            previous[i] = -1;
        }

        // Compute LIS using dynamic programming
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;
                    previous[i] = j;
                }
            }
        }

        // Find the index of the maximum length LIS
        int maxLenIdx = 0;
        for (int i = 0; i < n; i++) {
            if (len[maxLenIdx] < len[i]) {
                maxLenIdx = i;
            }
        }

        // Reconstruct the LIS
        List<Integer> resultList = new ArrayList<>();
        for (int i = maxLenIdx; i != -1; i = previous[i]) {
            resultList.add(arr[i]);
        }
        Collections.reverse(resultList);

        System.out.println("LIS: " + resultList);
        return len[maxLenIdx];
    }


    //  TC: O(N logN); SC: O(N)
    //  This approach helps in finding length only
    //  Algorithm:
    //  1. We maintain a list called tail that stores the smallest possible tail of all increasing subsequences found so far.
    //  2. For each element in the input array, we use binary search to find the position in tail where this element can replace
    //  an existing value or extend the subsequence.
    //  3. If the element can replace an existing value in tail, it means we are updating the subsequence with a smaller tail value,
    //  which allows for potentially longer subsequences later.
    //  4. If the element is greater than all values in tail, it extends the longest increasing subsequence.
    //  Note: We can't use tail array to get the LIS. Try: {3, 10, 2, 1, 20}
    private static int lengthOfLongestIncreasingSubsequence(int[] arr) {
        int n = arr.length;

        int[] tail = new int[n];
        int length = 1;          // Initially, the length of the LIS is 1 (just the first element)

        tail[0] = arr[0];        // The first element is the starting tail

        for (int i = 1; i < n; i++) {
            if (arr[i] > tail[length - 1]) {
                // If the current element is greater than the last element in the tail array, extend the LIS
                tail[length] = arr[i];
                length++;
            } else {
                // Otherwise, find the position where arr[i] would fit in the tail array
                int idx = binarySearch(tail, 0, length - 1, arr[i]);
                tail[idx] = arr[i]; // Replace the element at the found index with arr[i]
            }
        }

        System.out.println(Arrays.toString(tail));

        return length;
    }

    // Find the smallest element greater than or equal to key
    private static int binarySearch(int[] tail, int left, int right, int key) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (tail[mid] == key) {
                return mid; // If the key is found, return its index
            } else if (tail[mid] < key) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return left; // Return the position where the key should be inserted
    }

    public static void main(String[] args) {
        //int[] arr = {1, 3, 2, 3, 1, 5, 2};
        //int[] arr = {1, 1, 1, 2, 2, 2, 1, 1, 1};
        //int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int[] arr = {3, 10, 2, 1, 20};  //  tail will not give proper sequence for this input.
        //System.out.println("Length of LIS: " + longestIncreasingSubsequence(arr));
        System.out.println("Length of LIS optimized: " + lengthOfLongestIncreasingSubsequence(arr));
    }

}
