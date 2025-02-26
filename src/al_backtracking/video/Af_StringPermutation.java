/**
 * Write a program to find out all the permutations possible with the given string.
 */
package al_backtracking.video;

public class Af_StringPermutation {

    public static void main(String[] args) {
        String str = "ABC";
        stringPerms(str);
    }

    private static void stringPerms(String str) {
        stringPermsUtil(str, 0);
    }

    private static void stringPermsUtil(String str, int idx) {
        if (idx == str.length()) {
            System.out.println(str);
            return;
        }
        for (int i = idx; i < str.length(); i++) {
            str = swap(str, i, idx);
            stringPermsUtil(str, idx + 1);
            str = swap(str, i, idx);
        }
    }

    private static String swap(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }

}
