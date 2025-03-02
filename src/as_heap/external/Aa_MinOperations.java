//  https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/description/

package as_heap.external;

import java.util.PriorityQueue;
public class Aa_MinOperations {

    private static int minOperations(int[] nums, int k) {
        int ops = 0;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        for (int n : nums) {
            minHeap.add((long) n);
        }

        while (minHeap.peek() < k && minHeap.size() > 1) {
            long x = minHeap.poll();
            long y = minHeap.poll();
            minHeap.add(2 * x + y);
            ops++;
        }

        return ops;
    }

    public static void main(String[] args) {
        int[] arr = {2, 11, 10, 1, 3};
        int K = 10;
        System.out.println(minOperations(arr, K));
    }


}
