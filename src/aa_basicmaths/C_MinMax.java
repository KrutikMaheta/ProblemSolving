//  You are given an Array A of size N.
//  Find for how many elements, there is a strictly smaller element and a strictly greater element.
//  Example Input:
//    A = [1, 2, 3]
//Example Output:
//    1
//Explanation:
//    only 2 have a strictly smaller and strictly greater element, 1 and 3 respectively.


package aa_basicmaths;

import java.util.Arrays;

public class C_MinMax {
    public static void main(String[] args) {
        int arr[] = {2, 2, 3, 1, 3, 2};
        //int arr[] = {1,2,3};
        System.out.println(findCount(arr));
    }

    private static int findCount(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[0] && A[i] < A[A.length - 1]) {
                ++count;
            }
        }
        return count;
    }
}
