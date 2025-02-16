package al_backtracking;

import java.util.*;

public class Ac_PossibleSubsetsDuplicates {

    static List<List<Integer>> resultSubset = new ArrayList<>();
    static List<Integer> valList = new ArrayList<>();
    static List<Integer> freqList = new ArrayList<>();

    public static void main(String[] args) {
        Integer givenArr[] = {5, 5, 7};
        Map<Integer, Integer> freq = new HashMap<>();

        Arrays.stream(givenArr).forEach(element -> freq.merge(element, 1, (o, n) -> o + 1));

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            valList.add(entry.getKey());
            freqList.add(entry.getValue());
        }
        int[] arr = new int[freq.size()];
        possibleSubsetsDuplicates(arr, 0);
        System.out.println(resultSubset);
    }

    private static void possibleSubsetsDuplicates(int[] arr, int index) {
        if (index == arr.length) {
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i]; j++) {
                    tempList.add(valList.get(i));
                }
            }
            resultSubset.add(tempList);
            return;
        }
        for (int i = 0; i <= freqList.get(index); i++) {
            arr[index] = i;
            possibleSubsetsDuplicates(arr, index + 1);
        }
    }
}
