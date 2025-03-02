package as_heap.external;

import static acf_2pointers.external.Ac_MinimumConferenceRoomRequired.minConfRequiredHeap;

public class Ab_MinimumConferenceRoomRequired {

    public static void main(String[] args) {
        //int[][] meetings = {{0, 30}, {5, 10}, {15, 20}, {10, 15}};
        int[][] meetings = {{1, 5}, {8, 12}, {2, 7}, {9, 11}};  //  greedy fails for this
        //int[][] meetings = {{6, 10}, {10, 12}, {0, 7}};
        System.out.println(minConfRequiredHeap(meetings));
    }

}
