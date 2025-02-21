//  https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/

package al_backtracking.external;

public class Ab_LexicographicallyHappyString {

    private static int count;
    private static String result;

    //  O(3^n) in the worst case, as we explore all valid happy strings.
    private static void collectHappyString(int n, int k) {
        char[] arr = new char[n];
        count = 0;
        result = "";
        System.out.println("All Happy Strings: ");
        collectHappyStringUtil(n, k, arr, 0);
        System.out.println("Result: " + result);
    }

    private static void collectHappyStringUtil(int n, int k, char[] arr, int idx) {
        if (idx == n) {
            count++;
            if (count == k) {
                result = new String(arr);
            }
            System.out.println(count + ":" + new String(arr));
            return;
        }

        for (char c : new char[]{'a', 'b', 'c'}) {
            if (idx == 0 || arr[idx - 1] != c) {
                arr[idx] = c;
                collectHappyStringUtil(n, k, arr, idx + 1);
            }
            /*if (!result.isEmpty()) {
                return;
            }*/
        }

    }

    public static void main(String[] args) {
        int n = 3, k = 9;
        //int n = 1, k = 4;
        collectHappyString(n, k);
    }

}
