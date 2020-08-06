package medium;

class _371_getSum {
    /*
     * Write a function that add two numbers A and B. You should not use + or any
     * arithmetic operators.
     * 
     * Example Given a=1 and b=2 return 3
     * 
     * source: https://www.lintcode.com/problem/a-b-problem/description
     * 
     * 
     * 
     * bitshifting (1. find carries, 2. do the addition using ^, 3. make b hold
     * left_shifted carry) bit operator:
     * 
     * & -> 'AND' 1 1 => 1, 0 1 => 0, 0 0 => 0 to discover carry overs e.g 11 11 +
     * ---- 11 ^ -> 'XOR' 1 1 => 0, 0 1 => 1, 1 0 => 1, 0 0 => 0 to simulate the
     * addition
     * 
     * << -> left shift
     * 
     */
    public static void main(String[] args) {
        System.out.println(aplusb(13, 13));

    }

    public static int aplusb(int a, int b) {
        return (b == 0) ? a : aplusb(a ^ b, (a & b) << 1);
        // while (b != 0) {
        // int carry = a & b; // find carries positions
        // a ^= b; // actual addition without carries
        // // make b = value where carry-over needed to be done in next iteration
        // b = carry << 1;
        // }
        // return a;

    }
}