// https://leetcode.com/problems/letter-tile-possibilities/description/
package al_backtracking.external;

import al_backtracking.video.Ae_PossiblePermutationsDuplicates;

import java.util.Arrays;

public class Ad_CountTilePossibilities {
    public static int numTilePossibilities(String tiles) {
        boolean used[] = new boolean[tiles.length()];
        char[] arr = tiles.toCharArray();
        //  For efficiently handling duplicates
        Arrays.sort(arr);
        return numTilePossibilitiesUtil(new String(arr), used);
    }

    /**
     * Same logic as {@link Ae_PossiblePermutationsDuplicates#possiblePermutationsSwapping(int[], int)}
     */
    private static int numTilePossibilitiesUtil(String tiles, boolean[] used) {
        int count = 0;
        for (int i = 0; i < tiles.length(); i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && tiles.charAt(i) == tiles.charAt(i - 1) && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            count += 1 + numTilePossibilitiesUtil(tiles, used);
            used[i] = false;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAABBC")); //  188
        System.out.println(numTilePossibilities("AAB")); //  8
    }
}
