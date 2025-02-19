/**
 * Get the lexicographically largest string by doing at most 1 swap.
 */

package aj_string;

public class Ac_LexicographicallySort {

	public static void main(String[] args) {
		String s = "zyabxcax";
		System.out.println("Original String : " + s);
		System.out.println("Lexi sorted by at most 1 swap : " + lexicographicallySortedBy1Swap(s));
	}

	/*
	 * 1. Sort the string in descending by count sort. O(N)
	 * 2. Find the mismatch in the original and sorted string. O(N) 
	 * 3. Find the last occurrence of mismatched character
	 * from the sorted string in orig string and swap with the current index. O(1)
	 * 
	 * TC: O(N) & SC: O(N)
	 * 
	 * If we want to make the space O(1), then we can iterate the count array in reverse order and follow the similar approach.
	 * We dont need to create the string out of the count array.
	 * 
	 */

	private static String lexicographicallySortedBy1Swap(String orgStr) {
		String sortedStr = sortByCountSort(orgStr);
		System.out.println("Sorted String : " + sortedStr);
		for (int i = 0; i < orgStr.length(); i++) {
			if (orgStr.charAt(i) != sortedStr.charAt(i)) {
				return swap(orgStr.toCharArray(), i, lastOccurOf(sortedStr.charAt(i), orgStr));
			}
		}
		return orgStr;
	}

	private static String sortByCountSort(String orgStr) {
		int[] chCount = new int[26];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < orgStr.length(); i++) {
			chCount[orgStr.charAt(i) - 'a']++;
		}

		for (int i = 26 - 1; i >= 0; i--) {
			for (int j = 0; j < chCount[i]; j++)
				sb.append((char) ('a' + i));
		}
		return sb.toString();
	}
	
	private static int lastOccurOf(char ch, String str) {
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == ch)
				return i;
		}
		return -1;
	}
	
	private static String swap(char[] chArr, int a, int b) {
		char temp = chArr[a];
		chArr[a] = chArr[b];
		chArr[b] = temp;
		return new String(chArr);
	}

}
