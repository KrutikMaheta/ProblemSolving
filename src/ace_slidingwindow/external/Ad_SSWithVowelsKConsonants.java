//  3306. Count of Substrings Containing Every Vowel and K Consonants II
//  https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/description/
//  Video Explanation: https://www.youtube.com/watch?v=2wANakxRZNo&ab_channel=NeetCodeIO
package ace_slidingwindow.external;

import java.util.*;

public class Ad_SSWithVowelsKConsonants {

    private static long subStringWithAllVowelsKConsonants(String word, int k) {
        int consonants = 0, n = word.length();
        long count = 0;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Map<Character, Integer> vowelsCount = new HashMap<>();

        for (int l = 0, r = 0; r < n; r++) {
            char ch = word.charAt(r);
            if (vowels.contains(ch)) {
                vowelsCount.put(ch, vowelsCount.getOrDefault(ch, 0) + 1);
            } else {
                consonants++;
            }

            // Shrink window size only when consonants exceed k
            while (consonants > k) {
                char leftChar = word.charAt(l);
                if (vowels.contains(leftChar)) {
                    vowelsCount.put(leftChar, vowelsCount.get(leftChar) - 1);
                    if (vowelsCount.get(leftChar) == 0) {
                        vowelsCount.remove(leftChar);
                    }
                } else {
                    consonants--;
                }
                l++;
            }

            //  Count all valid substrings ending as r
            if (consonants == k && vowelsCount.size() == 5) {
                int tempL = l;
                int tempConsonants = consonants;
                Map<Character, Integer> tempVowelsCount = new HashMap<>(vowelsCount);

                while (tempL <= r) {
                    if (consonants == k && vowelsCount.size() == 5) {
                        count++;
                    }

                    char lChar = word.charAt(tempL);
                    if (vowels.contains(lChar)) {
                        tempVowelsCount.put(lChar, tempVowelsCount.get(lChar) - 1);
                        if (tempVowelsCount.get(lChar) == 0) {
                            tempVowelsCount.remove(lChar);
                        }
                    } else {
                        tempConsonants--;
                    }

                    if (tempConsonants < k || tempVowelsCount.size() < 5) {
                        break;
                    }

                    tempL++;
                }
            }
        }

        return count;
    }

    //  Approach: Sliding window dynamic size + 2 pointer
    //  1. It uses the principle of inclusion-exclusion.
    //  2. To find the exact count, it subtracts the count of substrings with at least k + 1 consonants from the count of substrings with at least k consonants.
    //  3. This effectively isolates substrings with exactly k consonants.
    //  TC: O(N); SC: O(1)
    private static long subStringWithAllVowelsExactlyKConsonants(String word, int k) {
        return subStringWithAllVowelsAtLeastKConsonants(word, k) - subStringWithAllVowelsAtLeastKConsonants(word, k + 1);
    }

    //  This function calculates the number of substrings that contain all vowels and at least k consonants.
    //  It uses a sliding window approach with dynamic size window.
    //  When the condition is met, n - r is added to the result. This is because all substrings ending at r and starting from l or any position after l are valid.
    // The while loop that shrinks the left side of the window, does so until either there are less than 5 distinct vowels, or there are less than k consonants.
    private static long subStringWithAllVowelsAtLeastKConsonants(String word, int k) {
        int consonants = 0, n = word.length();
        long result = 0;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Map<Character, Integer> vowelsCount = new HashMap<>();

        for (int l = 0, r = 0; r < n; r++) {
            char ch = word.charAt(r);
            if (vowels.contains(ch)) {
                vowelsCount.put(ch, vowelsCount.getOrDefault(ch, 0) + 1);
            } else {
                consonants++;
            }

            // Shrink the left boundary of the window while the conditions are met:
            while (vowelsCount.size() == 5 && consonants >= k) {
                // If all vowels are present and the consonant count is at least k,
                // then all substrings ending at 'r' and starting from 'l' or any position after 'l' are valid.
                // Therefore, add (n - r) to the result.
                result += n - r;

                // Shrink the window from the left:
                char leftChar = word.charAt(l);
                if (vowels.contains(leftChar)) {
                    vowelsCount.put(leftChar, vowelsCount.get(leftChar) - 1);
                    if (vowelsCount.get(leftChar) == 0) {
                        vowelsCount.remove(leftChar);
                    }
                } else {
                    consonants--;
                }

                // Move the left boundary of the window.
                l++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String word = "iqeaouqi";
        int k = 2;
        System.out.println(subStringWithAllVowelsKConsonants(word, k));
        System.out.println(subStringWithAllVowelsExactlyKConsonants(word, k));

        word = "ieaouqqieaouqq";
        k = 2;
        System.out.println(subStringWithAllVowelsKConsonants(word, k));
        System.out.println(subStringWithAllVowelsExactlyKConsonants(word, k));

        word = "aeioqq";
        k = 1;
        System.out.println(subStringWithAllVowelsKConsonants(word, k));
        System.out.println(subStringWithAllVowelsExactlyKConsonants(word, k));
    }


}
