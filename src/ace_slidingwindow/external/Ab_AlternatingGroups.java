//  https://leetcode.com/problems/alternating-groups-ii/description/
//  3208. Alternating Groups II

package ace_slidingwindow.external;

public class Ab_AlternatingGroups {

    private static int numberOfAlternatingGroups(int[] colors, int k) {
        int count = 0, n = colors.length, alternateLen = 1;

        //  We are running the loop > n-1 times to explore all the groups considering the nature of the array as circular
        //  Why i < n-1+k?
        //  1. The effective window size needs to be at least k for the substring to be valid.
        //  2. Because the array is circular, we need to extend beyond n to account for wrapping around.
        //  3. The maximum index accessed is n + k - 2, which means i % n will ensure that the circular nature is respected.
        for (int i = 1; i < n - 1 + k; i++) {
            if (colors[i % n] != colors[(i - 1) % n]) {
                alternateLen++;
                if (alternateLen >= k) {
                    count++;
                }
            } else {
                alternateLen = 1;
            }

        }

        return count;
    }

    public static void main(String[] args) {
        int[] colors = {0, 1, 0, 1, 0};
        int k = 3;
        System.out.println(numberOfAlternatingGroups(colors, k));

        int[] colors2 = {0, 1, 0, 0, 1, 0, 1};
        k = 6;
        System.out.println(numberOfAlternatingGroups(colors2, k));

        int[] colors3 = {1, 1, 0, 1};
        k = 4;
        System.out.println(numberOfAlternatingGroups(colors3, k));
    }

}
