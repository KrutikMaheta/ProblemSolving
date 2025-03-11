//  2379. Minimum Recolors to Get K Consecutive Black Blocks
//  https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/

package ace_slidingwindow.external;

public class Aa_MinOpsForConsecutiveBox {

    public static int minimumRecolors(String blocks, int k) {
        int n = blocks.length(), minRecolors, whiteCount = 0;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }
        minRecolors = whiteCount;

        for (int i = k; i < n; i++) {
            if (blocks.charAt(i) == 'W') whiteCount++;
            if (blocks.charAt(i - k) == 'W') whiteCount--;

            minRecolors = Math.min(minRecolors, whiteCount);
        }

        return minRecolors;
    }

    public static void main(String[] args) {
        String str = "WBBWWBBWBW";
        int K = 7;
        System.out.println(minimumRecolors(str, K));
        str = "WBWBBBW";
        K = 2;
        System.out.println(minimumRecolors(str, K));
    }

}
