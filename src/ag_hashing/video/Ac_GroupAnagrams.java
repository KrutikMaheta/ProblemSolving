/*
 * Consider the sorted version of the string as key to hashmap
 * And take list of string as value for the hashmap.
 *
 */

package ag_hashing.video;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ac_GroupAnagrams {

    public static void main(String[] args) {
        String arr[] = {"nlmo", "abc", "prq", "pqr", "lmno", "cba", "xyz"};
        groupAnagrams(arr);
    }

    /**
     * Lets consider the longest string of length S then for sorting it takes O(S)
     * This we are doing for each N elements => N*O(S)
     *
     * @param arr
     */
    private static void groupAnagrams(String[] arr) {
        HashMap<String, ArrayList<String>> hashmap = new HashMap<>();
        String hashString;
        for (int i = 0; i < arr.length; i++) {
            hashString = sortTheString(arr[i]);
            hashmap.computeIfAbsent(hashString, k -> new ArrayList<>()).add(arr[i]);
        }

        for (Map.Entry<String, ArrayList<String>> entry : hashmap.entrySet()) {
            System.out.println(entry.getValue());
        }

    }

    // This is count sort algorithm (considering all the string chars are in either
    // small or caps)
    // This takes O(N) for sorting
    private static String sortTheString(String string) {
        int letters[] = new int[26];
        for (char x : string.toCharArray()) {
			letters[x - 'a']++;
		}
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < letters[i]; j++) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }

}
