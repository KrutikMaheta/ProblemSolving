//  https://leetcode.com/problems/meeting-rooms/description/
package ah_sorting.external;

import java.util.Arrays;
import java.util.Comparator;

public class Ab_CanAttendAllMeetings {

    private static boolean possibleToAttendAllM2(int[][] meetings) {
        // Sort meetings based on start time
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        // Check for overlapping meetings
        for (int i = 1; i < meetings.length; i++) {
            //  If current meeting's start time < last meeting's end time -> conflict
            if (meetings[i][0] < meetings[i - 1][1]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        //int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        int[][] meetings = {{6, 10}, {10, 12}, {0, 7}};
        System.out.println(possibleToAttendAllM2(meetings));
    }


}
