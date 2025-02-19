/**
 * Is it possible to make a string palindrome just by changing exactly one character?
 *
 * Solution: Start comparing the staring characters from start and end and count the mismatches.
 * if count > 1 -> False
 * if count == 1 -> true
 * if count == 0
 * 		if evenLength -> False
 * 		if oddLength -> True
 */
package aj_string;

public class Ab_PalindromCheck {

	public static void main(String[] args) {
		//String s = "NAAN";
		String s = "ABCBA";
		System.out.println(isPalimBy1CharChange(s));
	}

	private static boolean isPalimBy1CharChange(String s) {
		char[] chArr = s.toCharArray();
		int len = chArr.length;
		int count = 0;
		for (int i = 0; i <= len / 2; i++) {
			if (chArr[i] != chArr[len - 1 - i]) {
				count++;
			}
			if (count > 1) {
				return false;
			}
		}
		System.out.println("Mismatches : " + count);
		if (count == 1) {
			return true;
		} else if (len % 2 != 0) {
			return true;
		}
		return false;
	}

}
