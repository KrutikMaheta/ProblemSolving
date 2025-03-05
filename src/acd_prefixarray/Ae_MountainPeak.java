package acd_prefixarray;

import java.util.Arrays;

public class Ae_MountainPeak {
    public static void main(String[] args) {
        findLeftRightPeaks(new int[]{4, 7, 2, 4, 9, 10, 1, 4, 7, 3});
    }

    private static void findLeftRightPeaks(int[] num) {

        int[] leftMaxPrefixArray = new int[num.length];
        int[] rightMaxPrefixArray = new int[num.length];

        int max = 0;
        for (int i = 0; i < num.length; i++) {
            leftMaxPrefixArray[i] = max;
            if (num[i] > max) {
                max = num[i];
            }
        }

        System.out.println(Arrays.toString(leftMaxPrefixArray));
        max = 0;
        for (int j = num.length - 1; j >= 0; j--) {
            rightMaxPrefixArray[j] = max;
            if (num[j] > max) {
                max = num[j];
            }
        }
        System.out.println(Arrays.toString(rightMaxPrefixArray));
    }
}
