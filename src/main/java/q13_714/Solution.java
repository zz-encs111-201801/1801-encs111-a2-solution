package q13_714;

/*
 *  https://leetcode.com/contest/leetcode-weekly-contest-55/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 *  Hint: Greedy
 *
 *  请将代码提交到上面的网址进行测试
 */

public class Solution {

    private int fee;
    private int profit = 0;

    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }

        this.fee = fee;

        currentPrice = prices[0];
        reset();

        for (int i = 0; i < prices.length; i++) {
            currentPrice = prices[i];

            if (seekingMode == seekingBuy) {
                if (currentPrice > bestSellPrice) {
                    higherSell();
                }
                if (bestSellPrice - bestBuyPrice > fee) {
                    decideBuy();
                }
                if (currentPrice < bestBuyPrice) {
                    reset();
                }
            } else if (seekingMode == seekingSell) {
                if (currentPrice > bestSellPrice) {
                    higherSell();
                }
                if (bestSellPrice - currentPrice > fee) {
                    decideSell();
                    reset();
                }
            }
        }

        if (seekingMode == seekingSell) {
            decideSell();
        }
        return profit;
    }


    private final int seekingBuy = 1;
    private final int seekingSell = 2;
    private int seekingMode = seekingBuy;

    private int currentPrice;
    private int bestBuyPrice;
    private int bestSellPrice;
    private int actualBuyPrice;
    private int actualSellPrice;

    private void reset() {
        bestBuyPrice = currentPrice;
        bestSellPrice = currentPrice;
    }

    private void higherSell() {
        bestSellPrice = currentPrice;
    }

    private void decideBuy() {
        actualBuyPrice = bestBuyPrice;
        seekingMode = seekingSell;
    }

    private void decideSell() {
        actualSellPrice = bestSellPrice;
        seekingMode = seekingBuy;
        profit += (actualSellPrice - actualBuyPrice - fee);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 3, 7, 5, 10, 3};
        System.out.println(solution.maxProfit(arr, 3));
    }


}
