//	Iterations:
/**
 * 12, 11, 13, 5, 6
 * 11, 12, 13, 5, 6
 * 11, 12, 13, 5, 6
 * 5, 11, 12, 13, 6
 * 5, 6, 11, 12, 13
 */

package ah_sorting.methods;

import java.util.Arrays;

public class Aa_InsertionSort {

    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 2, 1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //  We can assume virtual boundary between sorted and unsorted arrays.
    //  From the unsorted part, we pick the element -> search its right place -> move all greater elements to right.
    //  Every time we pick the element, find its right place by comparison , makes the space and insert the same.
    //	Time Complexity: O(n*2)
    //	Auxiliary Space: O(1)
    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int hole = i;
            int value = arr[i];
            while (hole > 0 && arr[hole - 1] > value) {
                arr[hole] = arr[hole - 1];
                hole--;
            }
            arr[hole] = value;
            System.out.println("Iteration : " + Arrays.toString(arr));
        }
    }

}
