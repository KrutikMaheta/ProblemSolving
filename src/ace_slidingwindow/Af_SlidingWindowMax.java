package ace_slidingwindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Af_SlidingWindowMax {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int K = 3;
        int[] result = findSlidingWindowMax(arr, K);
        System.out.println(Arrays.toString(result));
    }

    public static int[] findSlidingWindowMax(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = arr.length;
        int[] result = new int[arr.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements from deque that are out of this window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements from deque that are smaller than the current element
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            // Add current element's index to the deque
            deque.offerLast(i);

            // The first element in deque is the largest for this window
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }

        return result;
    }
}
