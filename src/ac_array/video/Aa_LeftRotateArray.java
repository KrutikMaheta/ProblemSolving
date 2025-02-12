/**
 * Rotate and array by given position
 * Solution without using extra space
 */
package ac_array.video;

import java.util.Arrays;

public class Aa_LeftRotateArray {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 1, 4, 5, 6, 8, 9 };
//		leftRotateArrayUsingExtraSpace(arr, 3);
//		leftRotateArrayOneByOne(arr, 3);
		leftRotateArrayEfficient(arr, 3);
		System.out.println("Final : " + Arrays.toString(arr));
	}

	// Using Extra Space
	// O(n) & Space o(k)
	private static void leftRotateArrayUsingExtraSpace(int[] arr, int rotations) {
		int length = arr.length;
		rotations = (rotations < length) ? rotations : rotations - length;
		int temp[] = new int[rotations];

		for (int i = 0; i < rotations; i++)
			temp[i] = arr[i];

		for (int i = 0; i < length - rotations; i++)
			arr[i] = arr[i + rotations];

		int j = 0;
		for (int i = length - rotations; i < length; i++)
			arr[i] = temp[j++];

	}

	// One by one rotate
	// O(n*k) & O(1)
	private static void leftRotateArrayOneByOne(int[] arr, int rotations) {
		for (int i = 0; i < rotations; i++) {
			int temp = arr[0];
			for (int j = 0; j < arr.length - 1; j++)
				arr[j] = arr[j + 1];
			arr[arr.length - 1] = temp;
		}
	}

	// Efficient solution
	// O(n) & O(1)
	private static void leftRotateArrayEfficient(int[] arr, int rotations) {
		System.out.println("Original : " + Arrays.toString(arr));
		reverseArray(arr, 0, arr.length - 1);
		System.out.println("Trace 1 : " + Arrays.toString(arr));
		reverseArray(arr, 0, arr.length - rotations - 1);
		System.out.println("Trace 2 : " + Arrays.toString(arr));
		reverseArray(arr, arr.length - rotations, arr.length - 1);
	}

	private static void reverseArray(int[] arr, int left, int right) {
		int temp = 0;
		while (left < right) {
			temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}

}
