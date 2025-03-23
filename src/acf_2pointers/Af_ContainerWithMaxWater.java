package acf_2pointers;

public class Af_ContainerWithMaxWater {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(containerWithMaxWater(arr));
    }

    private static int containerWithMaxWater(int[] arr) {
        int maxWater = 0;
        int i = 0;
        int j = arr.length - 1;

        // Ensure i and j point to different lines
        while (i < j) {
            // Calculate the current container's water capacity
            int water = (j - i) * Math.min(arr[i], arr[j]);
            // Update the maximum water if current water is greater
            maxWater = Integer.max(maxWater, water);

            // Move the pointer that has the smaller height
            if (arr[i] < arr[j]) {
                i++; // Move left pointer to right, hoping to find a taller line
            } else {
                j--; // Move right pointer to left, hoping to find a taller line
            }
        }

        return maxWater;
    }
}
