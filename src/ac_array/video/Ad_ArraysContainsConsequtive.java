/**
 * Find the minimum from array.
 * Traverse the array and look for (arr[i] - min) < Array_length
 */

package ac_array.video;

public class Ad_ArraysContainsConsequtive {

    public static void main(String[] args) {
        /*int arr[] = { -1, -2, -3, 0, 1, 2, 3 };*/
        int arr[] = {7, 8, 4, 5, 3, 1, 2, 6, -1, -2, -3, 0};
        System.out.println(arraysContainsConsequtive(arr));
    }

    private static boolean arraysContainsConsequtive(int[] arr) {
        int min = Integer.MAX_VALUE;
        int arrSize = arr.length;
        for (int i = 0; i < arrSize; i++)
            min = Integer.min(min, arr[i]);

        for (int i = 0; i < arrSize; i++) {
            if ((arr[i] - min) > arrSize - 1)
                return false;
        }
        return true;
    }

}
