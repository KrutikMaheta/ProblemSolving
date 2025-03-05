package ac_array.video;

public class Ah_MajorityElement {
    public static void main(String[] args) {
        int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4}; // Array with Majority Element
        //int[] arr = {3, 3, 4, 2, 4}; // Array without Majority Element
        System.out.println(findMajorityElement(arr));
    }

    private static int findMajorityElement(int[] arr) {
        // Step 1: Find a candidate for majority element
        int candidate = findCandidate(arr);

        // Step 2: Verify the candidate
        if (isMajority(arr, candidate)) {
            return candidate;
        } else {
            throw new IllegalArgumentException("No majority element found");
        }
    }

    //  Boyer-Moore Voting Algorithm
    //  TC: O(N) & SC: O(1)
    private static int findCandidate(int[] arr) {
        int candidate = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                candidate = arr[i];
            }
            count += (arr[i] == candidate) ? 1 : -1;
        }

        return candidate;
    }

    // Step 2: Verify that the candidate is actually the majority element
    private static boolean isMajority(int[] nums, int candidate) {
        int count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count > nums.length / 2;
    }
}
