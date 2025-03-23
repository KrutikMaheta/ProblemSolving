// 137. Single Number II
// https://leetcode.com/problems/single-number-ii/description/
package ach_contribution;

public class Ac_NumberAppearingThrice {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 3, 2, 1, 2, 5, 3, 1};
        System.out.println(findNumberAppearingThrice(arr));

        int[] arr1 = {-2, -2, 1, 1, 4, 1, 4, 4, -4, -2};
        System.out.println(findNumberAppearingThrice(arr1));
    }


    //  Approach:
    //  This approach ensures that the single number appearing once is isolated from numbers appearing three times,
    //  leveraging the fact that all bits in numbers appearing three times will cancel out when counting modulo 3.
    private static int findNumberAppearingThrice(int[] arr) {
        int answer = 0;
        for (int i = 0; i < 32; i++) {
            int noOfSetBits = 0;
            int mask = 1 << i;
            for (int j = 0; j < arr.length; j++) {
                //  We can't use >0 condition as it fails to detect set bits in negative numbers
                //if ((arr[j] & mask) > 0) {
                if ((arr[j] & mask) != 0) {
                    noOfSetBits++;
                }
            }
            answer = answer | ((noOfSetBits % 3) << i);
        }
        return answer;
    }
}
