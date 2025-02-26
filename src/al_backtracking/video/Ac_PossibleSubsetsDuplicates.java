package al_backtracking.video;

import java.util.*;

public class Ac_PossibleSubsetsDuplicates {

    static List<List<Integer>> resultSubset = new ArrayList<>();
    static List<Integer> valList = new ArrayList<>();   // Stores unique values from the input array
    static List<Integer> freqList = new ArrayList<>();  // Stores the frequency of each unique value

    public static void main(String[] args) {
        Integer[] givenArr = {5, 5, 7};
        Map<Integer, Integer> freq = new HashMap<>();

        // Compute frequency of each unique element
        Arrays.stream(givenArr).forEach(element -> freq.merge(element, 1, (o, n) -> o + 1));

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            valList.add(entry.getKey());
            freqList.add(entry.getValue());
        }
        int[] arr = new int[freq.size()];
        possibleSubsetsDuplicates(arr, 0);
        System.out.println(resultSubset);
    }

    //  TC: O(2^N)
    private static void possibleSubsetsDuplicates(int[] arr, int index) {
        // Base case: If we have processed all unique elements
        if (index == arr.length) {
            List<Integer> tempList = new ArrayList<>();

            // Construct the subset based on chosen frequencies
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i]; j++) {
                    tempList.add(valList.get(i));
                }
            }
            resultSubset.add(tempList);
            return;
        }

        // Recursively choose from 0 to freqList[index] occurrences of the current element
        for (int i = 0; i <= freqList.get(index); i++) {
            arr[index] = i;
            possibleSubsetsDuplicates(arr, index + 1);
        }
    }
}
