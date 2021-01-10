public class 买卖股票的最佳时机 II {
    // 动态规划和贪心，这里先使用贪心(如果能使用贪心（即能证明用贪心得到最优解），则贪心是最好的解答方式)
    public int maxProfit(int[] prices) {
        int total = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                total += prices[i + 1] - prices[i];
            }
        }

        return total;

    }
}