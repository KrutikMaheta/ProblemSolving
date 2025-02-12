package acd_prefixarray;

public class Aa_SumOfSubArray {

	public static void main(String[] args) {
		int a[] = { 1, 2, 1, 3, 4 };
		System.out.println(sumOfSubArray(a, 1, 3));
		System.out.println(sumOfSubArray(a, 3, 3));
		System.out.println(sumOfSubArray(a, 0, 2));
	}

	private static int sumOfSubArray(int[] a, int L, int R) {
		int temp[] = createPrefixSumArray(a);
		return L > 0 ? temp[R] - temp[L - 1] : temp[R];
	}

	private static int[] createPrefixSumArray(int[] a) {
		int[] prefixSumArray = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			prefixSumArray[i] = (i != 0) ? (a[i] + prefixSumArray[i - 1]) : a[i];
		}
		return prefixSumArray;
	}

}
