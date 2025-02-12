package ag_hashing.video;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Ae_LongestConsequativeSeq {

    public static void main(String[] args) {
        int arr[] = {3, 21, 33, 58, 34, 6, 32, 9, 30, 18, 31};
        System.out.println(longestConsequativeSeq(arr));
    }

    private static int longestConsequativeSeq(int[] arr) {
        int maxLen = 0;
        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr).forEach(element -> set.add(element));

        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i] - 1)) {
                //  this could be start of series
                int count = 0;
                while (set.contains(arr[i] + count)) {
                    count++;
                }
                maxLen = Integer.max(maxLen, count);
            }
        }

        return maxLen;
    }

}
