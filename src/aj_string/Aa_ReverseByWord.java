package aj_string;

import java.util.ArrayList;
import java.util.List;

public class Aa_ReverseByWord {

    public static void main(String[] args) {
        String s = "This is india score";
        reverseByWord(s);
        reverseByWordOptimized(s);
    }

    // TC: O(N); SC: O(N)
    // Split the words and get the string array of words; reverse the array
    private static void reverseByWord(String s) {
        List<String> words = split(s);
        StringBuilder sb = new StringBuilder();
        for (int i = words.size() - 1; i >= 0; i--) {
            sb.append(words.get(i) + " ");
        }
        System.out.println(sb);
    }

    private static List<String> split(String s) {
        char[] chArr = s.toCharArray();
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : chArr) {
            if (c == ' ') {
                words.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        words.add(sb.toString());
        return words;
    }

    // Approach 2: Reverse the entire string; later reverse individual words
    // TC: O(N); SC: O(1)

    private static void reverseByWordOptimized(String s) {
        char[] reversed = reverse(s);

        int wordStart = 0;
        for (int i = 0; i < reversed.length; i++) {
            if (reversed[i] == ' ') {
                reversed = reverseByPos(reversed, wordStart, i - 1);
                wordStart = i + 1;
            }
        }
        reversed = reverseByPos(reversed, wordStart, reversed.length - 1);
        System.out.println(new String(reversed));
    }

    private static char[] reverseByPos(char[] chArr, int wordStart, int wordEnd) {
        int endIndex = wordStart + wordEnd;
        for (int i = wordStart; i <= endIndex / 2; i++)
            chArr = swap(chArr, i, endIndex - i);
        return chArr;
    }

    private static char[] reverse(String s) {
        char[] chArr = s.toCharArray();
        for (int i = 0; i <= chArr.length / 2; i++) {
            chArr = swap(chArr, i, chArr.length - 1 - i);
        }
        return chArr;
    }

    private static char[] swap(char[] chArr, int a, int b) {
        char temp = chArr[a];
        chArr[a] = chArr[b];
        chArr[b] = temp;
        return chArr;
    }

}
