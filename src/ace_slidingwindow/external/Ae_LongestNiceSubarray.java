package ace_slidingwindow.external;

public class Ae_LongestNiceSubarray {

    //  Approach:
    //  The code uses a sliding window approach to find the longest "nice" subarray.
    //  The currentXor variable tracks the bitwise XOR of the elements in the current window.
    //  If adding a new element to the window causes a bitwise AND conflict (meaning two numbers in the window share a set bit),
    //  the window is shrunk from the left until the conflict is resolved.
    //  The maximum length of the window is tracked and returned.
    //  TC: O(N); SC: O(1)
    //  1. The right pointer iterates through the array once.
    //  2. The left pointer might iterate through the array multiple times, but in total, it will move at most n times.
    public static int longestNiceSubarray(int[] nums) {
        int maxLen = 0, currXOR = 0;

        for (int left = 0, right = 0; right < nums.length; right++) {
            // Check for bitwise AND conflict: if any two numbers in the window have a bit set in the same position
            while ((currXOR & nums[right]) != 0) {
                currXOR ^= nums[left];  // Keep removing the contribution of the leftmost element until conflict is resolved.
                left++; // Shrink the window from the left
            }

            // Update current XOR and max length
            currXOR ^= nums[right];
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 8, 48, 10};
        System.out.println(longestNiceSubarray(arr));
        int[] arr1 = new int[]{84139415, 693324769, 614626365, 497710833, 615598711, 264, 65552, 50331652, 1, 1048576, 16384, 544, 270532608, 151813349, 221976871, 678178917, 845710321, 751376227, 331656525, 739558112, 267703680};
        System.out.println(longestNiceSubarray(arr1));
    }
}
