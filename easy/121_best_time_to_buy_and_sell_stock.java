package easy;

class _121_best_time_to_buy_and_sell_stock {
    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println("expected: 5");
        int ans = solution.maxProfit(prices);
        System.out.printf("output: %d\n", ans);
    }
}

class solution {
    /*
     * brute force:
     * find max by iterating all combination which is O(n^2)
     * code:
     * public int maxProfit(int[] prices) {
     * int max = 0;
     * for (int i = 0; i< prices.length; i++)
     * {
     * for (int j = i+1; j < prices.length; j++)
     * {
     * int profit = prices[j]-prices[i];
     * if(max < profit ) max = profit;
     * }
     * }
     * return max;
     * }
     * 
     * one pass solution:
     * because the question is asking for max value from left to right, meaning min'
     * index will always be smaller
     * therefore, keep track of the min and the max relative to min
     * 
     * 
     */
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int num : prices) {
            if (num < min)
                min = num;
            int tmp = num - min;
            if (tmp > max)
                max = tmp;
        }
        return max;
    }
}
