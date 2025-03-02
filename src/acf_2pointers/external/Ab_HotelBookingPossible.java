package acf_2pointers.external;

import java.util.Arrays;

public class Ab_HotelBookingPossible {
    public static void main(String[] args) {
        int[] in = {1, 1, 1, 2, 3};     // Check-in times of guests
        int[] out = {4, 2, 6, 3, 5};    // Check-out times of guests
        int rooms = 3;
        System.out.println(isHotelBookingPossible(in, out, rooms));
    }

    //  Determines whether it is possible to accommodate all bookings given limited hotel rooms.
    //  TC: O(N * LogN)
    private static boolean isHotelBookingPossible(int[] in, int[] out, int rooms) {
        // Sort the check-in and check-out times to process bookings in order
        Arrays.sort(in);
        Arrays.sort(out);

        int i = 0;  //  check-in pointer
        int j = 0;  //  check-out pointer
        int guests = 0; // no of guests currently staying in hotel

        while (i < in.length && j < out.length) {
            if (in[i] < out[j]) {
                // check-in
                ++guests;
                i++;
            } else {
                // check-out
                --guests;
                j++;
            }
            // If at any point the guests exceed available rooms, return false
            if (guests > rooms) {
                return false;
            }
        }
        return true;
    }


}
