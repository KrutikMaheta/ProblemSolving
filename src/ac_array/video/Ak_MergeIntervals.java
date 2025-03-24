package ac_array.video;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ak_MergeIntervals {
    //  N -> N Log N
    private static int[][] mergeItervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals; // Handle empty or single-interval cases
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int[] lastMergedInterval = result.getLast();

            if (currentInterval[0] <= lastMergedInterval[1]) {
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], currentInterval[1]);
            } else {
                result.add(currentInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }


    private static void print(int[][] result) {
        for (int[] cur : result) {
            System.out.println(Arrays.toString(cur));
        }
    }

    public static void main(String[] args) {
        int[][] result;
        int[][] intervals = {{8, 10}, {1, 3}, {2, 6}, {15, 18}};
        print(intervals);
        result = mergeItervals(intervals);
        print(result);
        System.out.println();
        System.out.println();

        int[][] intervals2 = {{1, 4}, {4, 5}};
        print(intervals2);
        result = mergeItervals(intervals2);
        print(result);
        System.out.println();
        System.out.println();

        int[][] intervals3 = {{1, 4}, {0, 2}, {3, 5}};
        print(intervals3);
        result = mergeItervals(intervals3);
        print(result);
        System.out.println();
        System.out.println();

        int[][] intervals4 = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        print(intervals4);
        result = mergeItervals(intervals4);
        print(result);
        System.out.println();
        System.out.println();
    }


}
