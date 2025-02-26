//  https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/

package al_backtracking.external;

public class Ab_LexicographicallyHappyString {

    //  counter to keep track of no of strings generated
    private static int count;

    //  Stores the kth lexicographically smallest happy string
    private static String result;

    //  Generates all happy strings of length `n` in lexicographical order and prints the k-th one.
    //  TC: O(3^n) in the worst case, as we explore all valid happy strings.
    private static void collectHappyString(int n, int k) {
        char[] arr = new char[n];   //  Array for building current happy string
        count = 0;
        result = "";
        System.out.println("All Happy Strings: ");

        //  start backtracking from first character
        collectHappyStringUtil(n, k, arr, 0);
        System.out.println("Result: " + result);
    }

    private static void collectHappyStringUtil(int n, int k, char[] arr, int idx) {

        // Base Case: If we have generated a full happy string of length `n`
        if (idx == n) {
            count++;    // Increment count of happy strings generated

            // If this is the k-th happy string, store it in `result`
            if (count == k) {
                result = new String(arr);
            }
            System.out.println(count + ":" + new String(arr));
            return;
        }

        // Try placing 'a', 'b', or 'c' at the current index
        for (char c : new char[]{'a', 'b', 'c'}) {

            // Ensure no adjacent characters are the same (happy string condition)
            if (idx == 0 || arr[idx - 1] != c) {
                arr[idx] = c;   // Place character at current index
                collectHappyStringUtil(n, k, arr, idx + 1);  // Recur for next index
            }

            // Stop early if the k-th string is found
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
