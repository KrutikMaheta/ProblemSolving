package ai_searching;

public class Aaa_SearchInRotatedSorted {

	public static void main(String[] args) {
		//int arr[] = { 18, 21, 25, 10, 12, 15, 16, 17 };
		int arr[] = { 10, 12, 15, 16, 17 ,18, 21, 25 };
		System.out.println(searchInRotatedSorted(arr, 10));
	}

	private static int searchInRotatedSorted(int[] arr, int X) {
		int partition = findPartition(arr);
		int ri = binSearch(arr, 0, partition, X);
		if (ri != -1) {
			return ri;
		}
		return binSearch(arr, partition + 1, arr.length - 1, X);
	}

	private static int binSearch(int[] arr, int s, int e, int X) {
		while (s <= e) {
			int m = s + (e - s) / 2;
			if (arr[m] == X)
				return m;
			else if (arr[m] > X)
				e = m - 1;
			else
				s = m + 1;
		}
		return -1;
	}

	/*
	 * Look for the index where a[i] > a[i+1]
	 */
	
	private static int findPartition(int[] arr) {
		int len = arr.length - 1;
		int s = 0;
		int e = len;
		while (s <= e) {
			int mid = s + (e - s) / 2;
			if (arr[mid] > arr[mid + 1])
				return mid;
			else if (arr[mid] > arr[len])
				s = mid + 1;
			else
				e = mid - 1;
		}
		return -1;
	}

}
