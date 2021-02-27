package dynamicprogramming;

public class HammingWeight {
    public static int hammingWeight(int n) {
        int mask = 1;
        int bits = 0;
        for ( int i=0; i<32; i++ ) {
            if ( (n & mask) != 0 ) {
                bits++;
            }
            mask <<= 1;
        }
        mask >>= 1;
        return bits;
    }

    public static void main(String[] args) {
//        hammingWeight(  11111111111111111111111111111101 );
    }
}
