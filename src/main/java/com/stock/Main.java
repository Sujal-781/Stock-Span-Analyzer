package com.stock;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("📊 Welcome to Stock Analyzer");
        System.out.print("Enter number of days: ");
        int n = scanner.nextInt();
        int[] prices = new int[n];

        System.out.println("Enter stock prices for each day:");
        for (int i = 0; i < n; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            prices[i] = scanner.nextInt();
        }

        while (true) {
            System.out.println("\n🔸 Choose an option:");
            System.out.println("1. Analyze Stock Span");
            System.out.println("2. Calculate Max Profit");
            System.out.println("3. Max in Sliding Window");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    int[] span = StockAnalyzer.calculateSpan(prices);
                    System.out.println("📈 Stock Span: " + Arrays.toString(span));
                    break;

                case 2:
                    int singleProfit = ProfitCalculator.calculateMaxProfitSingleTransaction(prices);
                    int multipleProfit = ProfitCalculator.calculateMaxProfitMultipleTransactions(prices);
                    System.out.println("💰 Max Profit (Single Transaction): ₹" + singleProfit);
                    System.out.println("💹 Max Profit (Multiple Transactions): ₹" + multipleProfit);
                    break;

                case 3:
                    System.out.print("Enter window size (e.g., 3): ");
                    int k = scanner.nextInt();
                    List<Integer> maxInWindow = SlidingWindow.maxInWindow(prices, k);
                    System.out.println("📊 Max in sliding window of " + k + " days: " + maxInWindow);
                    break;

                case 4:
                    System.out.println("👋 Exiting. Thank you for using Stock Analyzer!");
                    return;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
