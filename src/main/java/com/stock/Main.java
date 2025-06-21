package com.stock;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        // Print input
        System.out.println("Input Prices: " + Arrays.toString(prices));
        int[] span = StockAnalyzer.calculateSpan(prices);
        System.out.println("Stock Span: " + Arrays.toString(span));


        int singleProfit = ProfitCalculator.calculateMaxProfitSingleTransaction(prices);
        int multipleProfit = ProfitCalculator.calculateMaxProfitMultipleTransactions(prices);

        System.out.println("Max Profit (Single Transaction): ₹" + singleProfit);
        System.out.println("Max Profit (Multiple Transactions): ₹" + multipleProfit);


        List<Integer> maxInWindow = SlidingWindow.maxInWindow(prices, 3);
        System.out.println("Max in sliding window of 3 days: " + maxInWindow);

    }
}
