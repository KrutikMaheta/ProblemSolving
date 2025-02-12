//  Given an integer count no of set bits in it.

package ab_bitmanipulation.video;

public class E_NoOfSetBits {
    public static void main(String[] args) {
        int num = 38;
        binaryRepresentation(num);
        System.out.println();
        System.out.println(countSetBits(num));
        System.out.println(countSetBitsM2(num));
    }

    private static void binaryRepresentation(int num) {
        if (num / 2 == 0) {
            System.out.print(num % 2);
            return;
        }
        binaryRepresentation(num / 2);
        System.out.print(num % 2);
    }

    // TC: O(Log N)
    // For 16 the loop will run for 4 times.
    private static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                ++count;
            }
            num = num >> 1;
            // As right shifting is equivalent to divide by 2
            //num = num / 2;
        }

        return count;
    }

    //  N       = 10010011000
    //  N-1     = 10010010000
    //  N & N-1 = 10010010000 -> This will make sure of removing set bit in every iteration.
    // For 16 the loop will run just once because 16 has just 1 set bit.
    private static int countSetBitsM2(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }
}
