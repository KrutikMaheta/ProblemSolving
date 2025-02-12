package ab_bitmanipulation.video;

public class A_BitOps {
    public static void main(String[] args) {
        System.out.println("** Check Bit **");

        System.out.println(checkBit(10, 2));
        System.out.println(checkBit(7, 2));
        System.out.println(checkBit(32, 5));

        System.out.println("** Set Bit **");
        System.out.println(setBit(32, 1));

        System.out.println("** Toggle Bit **");
        System.out.println(toggleBit(32, 5));

        System.out.println("** Clearing Bit **");
        System.out.println(clearBit(7, 1));

    }

    private static int clearBit(int num, int bit) {
        binaryRepresentation(num);
        System.out.print("-> Clear bit : " + bit + " --> ");
        System.out.println("debug: " + ~(1 << bit));
        num = num & (~(1 << bit));
        binaryRepresentation(num);
        System.out.println();
        return num;
    }

    private static int toggleBit(int num, int bit) {
        binaryRepresentation(num);
        System.out.print("-> Toggle bit : " + bit + " --> ");
        num = num ^ (1 << bit);
        binaryRepresentation(num);
        System.out.println();
        return num;
    }

    private static int setBit(int num, int bit) {
        binaryRepresentation(num);
        System.out.print("-> Setting bit : " + bit + " --> ");
        num = num | (1 << bit);
        binaryRepresentation(num);
        System.out.println();
        return num;
    }

    private static boolean checkBit(int num, int bit) {
        binaryRepresentation(num);
        System.out.print(" -> Check bit : " + bit + " -> ");
        return (num & (1 << bit)) != 0;
    }

    private static void binaryRepresentation(int num) {
        if (num == 0) {
            return;
        }
        binaryRepresentation(num / 2);
        System.out.print(num % 2);
    }

}
