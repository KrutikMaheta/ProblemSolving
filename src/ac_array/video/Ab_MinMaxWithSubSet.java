package ac_array.video;

import java.util.Arrays;

public class Ab_MinMaxWithSubSet {

	public static void main(String[] args) {
		int arr[] = { 3, 2, 5 };
		minMaxDiffWithSubset(arr);
	}

	private static void minMaxDiffWithSubset(int[] arr) {
		Arrays.sort(arr);
		int contriAsMax = 0;
		int contriAsMin = 0;
		for (int i = 0; i < arr.length; i++) {
			contriAsMin += arr[i] * (Math.pow(2, (arr.length-1) - i));
			contriAsMax += arr[i] * (Math.pow(2, i));
		}
		System.out.println(contriAsMax - contriAsMin);
		
	}

}
