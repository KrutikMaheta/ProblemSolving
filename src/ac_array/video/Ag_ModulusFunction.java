package ac_array.video;

public class Ag_ModulusFunction {
    public static void main(String[] args) {
        int[] arr = {7, 1, 2, 3, 4, 0, 2, 6};
        System.out.println(maxSumOfModFunction2(arr));
    }

    //  Break the mod function and maintain 2 arrays. One with a[i] + i and another with a[i] - i
    //  Find the max and min from both the arrays. get max-min from both and return the max difference out of both.
    private static int maxSumOfModFunction(int[] arr) {
        int len = arr.length;
        int[] valPlusIdxArr = new int[len];
        int[] valMinusIdxArr = new int[len];

        for (int i = 0; i < len; i++) {
            valPlusIdxArr[i] = arr[i] + i;
            valMinusIdxArr[i] = arr[i] - i;
        }

        int maxFromValPlusIdxArr = Integer.MIN_VALUE;
        int minFromValPlusIdxArr = Integer.MAX_VALUE;
        int maxFromValMinusIdxArr = Integer.MIN_VALUE;
        int minFromValMinusIdxArr = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            if (maxFromValPlusIdxArr < valPlusIdxArr[i]) {
                maxFromValPlusIdxArr = valPlusIdxArr[i];
            }
            if (minFromValPlusIdxArr > valPlusIdxArr[i]) {
                minFromValPlusIdxArr = valPlusIdxArr[i];
            }

            if (maxFromValMinusIdxArr < valMinusIdxArr[i]) {
                maxFromValMinusIdxArr = valMinusIdxArr[i];
            }
            if (minFromValMinusIdxArr > valMinusIdxArr[i]) {
                minFromValMinusIdxArr = valMinusIdxArr[i];
            }
        }

        if (maxFromValPlusIdxArr - minFromValPlusIdxArr > maxFromValMinusIdxArr - minFromValMinusIdxArr) {
            return maxFromValPlusIdxArr - minFromValPlusIdxArr;
        } else {
            return maxFromValMinusIdxArr - minFromValMinusIdxArr;
        }
    }
    
    // Without extra space
    private static int maxSumOfModFunction2(int[] arr) {
        int len = arr.length;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            if (arr[i] + i > max1) {
                max1 = arr[i] + i;
            }
            if (arr[i] + i < min1) {
                min1 = arr[i] + i;
            }
            if (arr[i] - i > max2) {
                max2 = arr[i] - i;
            }
            if (arr[i] - i < min2) {
                min2 = arr[i] - i;
            }
        }

        if (max1 - min1 > max2 - min2) {
            return max1 - min1;
        } else {
            return max2 - min2;
        }
    }
}
