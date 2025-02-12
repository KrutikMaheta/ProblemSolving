package ab_bitmanipulation.video;

public class B_NumberInPairExceptOne {

	public static void main(String[] args) {
		int a[] = { 1, 2, 1, 2, 3, 4, 4 };
		System.out.println(numberInPairExceptOne(a));
	}

	private static int numberInPairExceptOne(int[] a) {
		int res = 0;
		for (int i = 0; i < a.length; i++) {
			res ^= a[i];
		}
		return res;
	}

}
