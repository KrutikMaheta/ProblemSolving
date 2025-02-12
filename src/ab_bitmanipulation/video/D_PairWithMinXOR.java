package ab_bitmanipulation.video;

import java.util.Arrays;

import ag_hashing.video.Pair;

public class D_PairWithMinXOR {

    public static void main(String[] args) {
        // int arr[] = { 8, 6, 1, 10, 12, 16, 17 };
        int arr[] = {1, 4, 5, 2, 3};
        System.out.println(pairWithMinXOR(arr));
    }

    private static Pair pairWithMinXOR(int[] arr) {
        Arrays.sort(arr);
        int min_xor = Integer.MAX_VALUE;
        int temp_xor;
        Pair pair = new Pair();

        for (int i = 0; i < arr.length - 1; i++) {
            temp_xor = arr[i] ^ arr[i + 1];
            if (min_xor > temp_xor) {
                min_xor = temp_xor;
                pair.setI(arr[i]);
                pair.setJ(arr[i + 1]);
            }
        }
        return pair;
    }

}
