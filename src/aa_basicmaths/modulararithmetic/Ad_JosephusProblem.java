//  https://leetcode.com/problems/find-the-winner-of-the-circular-game/description/

package aa_basicmaths.modulararithmetic;

import java.util.ArrayList;
import java.util.List;

public class Ad_JosephusProblem {

    //  TC: O(N)
    //  SC: O(N)
    private static int findWinner(int n, int k) {
        // creating a list of n people
        List<Integer> person = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            person.add(i + 1);
        }

        int pos = 0;

        // In each iteration one person is eliminated until only one person is left
        while (n != 1) {
            // position of next person to be killed
            pos = (pos + k - 1) % n;
            person.remove(pos);
            n -= 1;
        }

        //  At the end only one person will survive
        return person.get(0);
    }

    public static void main(String[] args) {
        int n = 6;
        int k = 5;
        System.out.println(findWinner(n, k));
    }

}
