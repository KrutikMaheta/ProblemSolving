package acf_2pointers.external;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Ac_MinimumMeetingRoomRequired {

    //  Incorrect code
    //  The code uses a simple greedy approach, checking only the immediately preceding meeting.
    //  This approach fails to consider the overall overlap of multiple meetings
    //  The code doesn't track the number of currently active meetings
    private static int minConfRequiredGreedy(int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int count = 1;
        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] < meetings[i - 1][1]) {
                count++;
            }
        }
        return count;
    }


    /**
     * Follows the same approach as {@link Ab_HotelBookingPossible}
     */
    //  TC: O(N LogN)
    //  SC: O(N)
    private static int minConfRequired(int[][] meetings) {
        int roomsRequired = 0;
        int maxRooms = 0;
        int n = meetings.length;
        int[] start = new int[n];
        int[] end = new int[n];

        int i = 0;
        for (int[] meeting : meetings) {
            start[i] = meeting[0];
            end[i++] = meeting[1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int p = 0, q = 0;

        while (p < n && q < n) {
            if (start[p] < end[q]) {
                roomsRequired++;
                p++;
            } else {
                roomsRequired--;
                q++;
            }
            maxRooms = Math.max(maxRooms, roomsRequired);
        }

        return maxRooms;
    }


    //  TC: O(N * log N)
    //  SC: O(N)
    public static int minConfRequiredHeap(int[][] meetings) {

        // Step 1: Sort meetings by start time
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        // Step 2: Min-Heap to track meeting end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int roomsRequired = 0;

        // Step 3: Process each meeting
        for (int[] meeting : meetings) {
            // Remove all meetings that ended before the current one starts
            while (!minHeap.isEmpty() && minHeap.peek() <= meeting[0]) {
                minHeap.poll();
            }

            // Add the current meeting's end time to the heap
            minHeap.add(meeting[1]);

            // Update the maximum number of rooms used
            roomsRequired = Math.max(roomsRequired, minHeap.size());
        }
        return roomsRequired;
    }


    public static void main(String[] args) {
        //int[][] meetings = {{0, 30}, {5, 10}, {15, 20}, {10, 15}};
        int[][] meetings = {{1, 5}, {8, 12}, {2, 7}, {9, 11}};  //  greedy fails for this
        //int[][] meetings = {{6, 10}, {10, 12}, {0, 7}};
        System.out.println(minConfRequiredGreedy(meetings));
        System.out.println(minConfRequired(meetings));
        System.out.println(minConfRequiredHeap(meetings));

    }


}
