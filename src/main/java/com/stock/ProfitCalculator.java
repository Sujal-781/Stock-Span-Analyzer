package com.stock;

public class ProfitCalculator {
    public static int calculateMaxProfitSingleTransaction(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

    public static int calculateMaxProfitMultipleTransactions(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1]; // Buy at i-1, sell at i
            }
        }
        return profit;
    }
}
