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
     */
    public static void main(String[] args) {
        int a = 9, b = 11;
        System.out.println("expected: 20");
        int ans = solution.getsum(a, b);
        System.out.printf("output: %d\n", ans);

    }

}

class solution {

    /*
     * thoughts:
     * this question is about bit manipulation and simulate a hardware adder, using
     * half adder logic.
     *
     * AND & gate:
     * x y x&y
     * 0 0 0
     * 0 1 0
     * 1 0 0
     * 1 1 1
     * 
     * XOR ^ gate:
     * x y x^y
     * 0 0 0
     * 0 1 1
     * 1 0 1
     * 1 1 0
     *
     * 1. caculate the sum of x, y using xor ^
     * 2. find if there is carry using and &, if yes, shift left by 1
     * 3. xor ^ step 1 and 2
     * 4. if there is carry, add shift left by 1 and xor ^ it back
     * 4. repeat until there is no carry
     * 
     * stop condition: carry = 0
     * 
     * while loop version
     * 
     * int getsum(int x, int y){
     * while (y != 0){
     * int carry = x & y << 1;
     * x = x & y;
     * y = carry;
     * }
     * }
     * 
     * while loop not very intuitive to me, try recursion
     * 
     * int getsum(int x, int y)
     * {
     * if(y==0) return x;
     * getsum(x^y, (x&y) <<1);
     * }
     * or 1 liner
     * 
     * y==0? x: getsum(x^y, (x&y) <<1) ;
     * 
     * 
     */
    public static int getsum(int a, int b) {
        return b == 0 ? a : getsum(a ^ b, (a & b) << 1);
    }
}