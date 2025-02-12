/**
 * The entire array will be sorted except the last element.
 * Put that element in the correct index.
 */

package ac_array.video;

import java.util.Arrays;

public class Ac_SortTheArray {

	public static void main(String[] args) {
		int a[] = { 2, 3, 6, 8, 14, 15, 20, 1 };
		sortTheUnsortedLastElement(a);
		System.out.println(Arrays.toString(a));
	}

	private static void sortTheUnsortedLastElement(int[] a) {
		int length = a.length;
		int lastElement = a[length - 1];

		int pos = findTheIndex(a, lastElement);

		for (int j = length - 1; j > pos; j--) {
			a[j] = a[j - 1];
		}
		a[pos] = lastElement;
	}

	private static int findTheIndex(int[] a, int element) {
		int pos = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > element) {
				pos = i;
				break;
			}
		}
		return pos;
	}

}
