//  https://leetcode.com/problems/single-number-iii/

package ab_bitmanipulation.video;

public class C_NumberInPairExceptTwo {

    public static void main(String[] args) {
        int arr[] = {9, 1, 1, 2, 3, 5, 3, 2, 7, 8, 8, 9};
        numberInPairExceptTwo(arr);
    }

    private static void numberInPairExceptTwo(int[] arr) {
        int XOR = 0;

        //	First find the XORs of all the numbers
        //	The final result will be XOR of asked 2 numbers
        for (int i = 0; i < arr.length; i++) {
            XOR ^= arr[i];
        }

        //	Find out the first SET bit in the XORed number
        int k = 0;
        while (true) {
            if ((XOR & (1 << k)) != 0) {
                break;
            }
            k++;
        }

        int num1 = 0;
        int num2 = 0;

        //	Separate out the numbers based on the kth bit
        //	kth bit will always be different in both the required numbers.
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & (1 << k)) != 0) {
                num1 ^= arr[i];
            } else {
                num2 ^= arr[i];
            }
        }

        System.out.println(num1 + "," + num2);
    }

}
