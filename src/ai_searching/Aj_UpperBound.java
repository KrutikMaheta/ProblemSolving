package ai_searching;

public class Aj_UpperBound {

    public static void main(String[] args) {
        int[] arr = {4, 7, 7, 7, 8, 9, 9, 9, 10, 10, 10, 11, 15, 18, 24};
        System.out.println(func(arr, 24));
    }

    private static int func(int[] arr, int X) {
        int s = 0;
        int e = arr.length - 1;
        int min_index = Integer.MAX_VALUE;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] > X) {
                e = m - 1;
                min_index = Integer.min(min_index, m);
            } else
                s = m + 1;
        }
        if (min_index == Integer.MAX_VALUE)
            return arr.length - 1;
        if (arr[min_index - 1] == X)
            return min_index - 1;
        return min_index;
    }

}
