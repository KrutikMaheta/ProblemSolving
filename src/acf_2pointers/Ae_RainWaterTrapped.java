package acf_2pointers;

public class Ae_RainWaterTrapped {
    public static void main(String[] args) {
        //int[] arr = {1, 3, 2, 6, 4, 5, 3, 4, 5};
        int[] arr = {2, 4, 2, 6, 4, 2, 5, 3, 7};
        System.out.println(rainWaterTrapped(arr));
    }

    private static int rainWaterTrapped(int[] arr) {
        int waterTrapped = 0;
        int maxHeight = Integer.MIN_VALUE;
        int maxHeightIdx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxHeight) {
                maxHeight = arr[i];
                maxHeightIdx = i;
            }
        }

        int leftMax = Integer.MIN_VALUE;
        for (int i = 0; i < maxHeightIdx; i++) {
            if (arr[i] > leftMax) {
                leftMax = arr[i];
            } else {
                waterTrapped += (leftMax - arr[i]);
            }
        }

        int rightMax = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i > maxHeightIdx; i--) {
            if (arr[i] > rightMax) {
                rightMax = arr[i];
            } else {
                waterTrapped += (rightMax - arr[i]);
            }
        }


        return waterTrapped;
    }
}
