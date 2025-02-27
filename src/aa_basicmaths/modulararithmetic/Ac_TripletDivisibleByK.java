package aa_basicmaths.modulararithmetic;

import static ag_hashing.external.Aa_TripletDivisibleByK.countOfTripletsDivByK;

public class Ac_TripletDivisibleByK {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, 12, 18};
        int K = 6;
        System.out.println(countOfTripletsDivByK(arr, K));
    }

}
