package ag_hashing.video;

import java.util.HashMap;

public class Aa_PairWithGivenSum {

    public static void main(String[] args) {
        //int a[] = { 7, 4, 10, 2, 5, 16, 3 };
        int a[] = {4, 7, -4, 2, 2, 2, 3, -5};
        System.out.println(pairWithGivenSum(a, -3));
    }

    private static boolean pairWithGivenSum(int[] a, int k) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                return map.get(a[i]);
            }
            map.put(k - a[i], true);
        }
        return false;
    }

}
