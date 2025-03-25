package aa_basicmaths.gcd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D_AddDiffOfArrElements {
    public static void main(String[] args) {
        //int[] arr = {18, 9, 21};
        int[] arr = {6, 10, 15};
        addDiffOfArrayElements(arr);
    }

    //  Based on Euclead Algo, Whenever we add (a-b) in the array, GCD is the one property which will not change as,
    //  GCD(A,B) = GCD(A-B,B)
    //  We can take the GCD of all the elements in the array and start generating the sequence till we reach max number in the array.
    private static void addDiffOfArrayElements(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int max = Arrays.stream(arr).max().getAsInt();

        //  TC of GCD calculation: nlog(maxValue)
        int gcd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            gcd = A_CalculateGCD.findGCD3(gcd, arr[i]);
        }

        //  TC of sequence generation: O(max/gcd)
        int element = gcd;
        int i = 1;
        while (element < max) {
            element = gcd * i++;
            list.add(element);
        }

        System.out.println(list);
    }
}