package al_backtracking.video;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aa_BinarySequenceGeneration {

    static int POWER = 3;

    public static void main(String[] args) {
        int arr[] = new int[POWER];
        printPossibleCombinations(arr, 0);
        System.out.println(printPossibleCombinations2(POWER));
        generateBinarySequences(POWER);
    }


    // BOTTOM-UP approach
    //  Why?
    //  We start from an empty array and build it from left to right.
    //  We only print the sequence when we reach the base condition (index == POWER),
    //  meaning we construct the result incrementally before reaching the final state.
    //  SC: O(N); Here number of active function calls will be depth/height of the structure; which is N.
    //  TC: O(2^N); Every step spawns 2 possibilities.
    private static void printPossibleCombinations(int[] arr, int index) {
        // Base case: if index reaches the length of the sequence
        if (index == POWER) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        arr[index] = 0;     // Assign 0 at the current index
        printPossibleCombinations(arr, index + 1);  // Recursive call for the next index
        arr[index] = 1;     // Assign 1 at the current index
        printPossibleCombinations(arr, index + 1);  // Recursive call for the next index
    }

    //  TOP-DOWN Approach
    //  Why?
    //  We start with the final result in mind (generating all sequences of length n).
    //  We break it down into smaller sub-problems, solving for n-1, n-2, ..., until n=1.
    //  Then, we combine the smaller solutions to get the final answer.
    //  TC: O(2ⁿ)
    //  SC: O(2ⁿ) -> The recursion depth is O(N); The list size grows to O(2ⁿ)
    private static List<String> printPossibleCombinations2(int num) {
        List<String> list = new ArrayList<>();

        // Base case: When num == 1, return ["0", "1"]
        if (num == 1) {
            list.add("0");
            list.add("1");
            return list;
        }
        List<String> tempList = printPossibleCombinations2(num - 1);
        for (int i = 0; i < tempList.size(); i++) {
            list.add("0" + tempList.get(i));        // Append '0' to each element
        }
        for (int i = 0; i < tempList.size(); i++) {
            list.add("1" + tempList.get(i));        // Append '1' to each element
        }
        return list;
    }

    //  Iterative Approach
    //  TC: O(2^N)
    //  SC: O(1)
    private static void generateBinarySequences(int n) {
        int total = 1 << n;  // Equivalent to 2^n (bitwise left shift)

        for (int i = 0; i < total; i++) {
            // Convert integer i to binary and format it to n bits
            String binary = String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
            System.out.println(binary);
        }
    }

}
