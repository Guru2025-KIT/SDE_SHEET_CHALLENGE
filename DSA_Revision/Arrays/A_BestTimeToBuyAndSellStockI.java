package DSA_Revision.Arrays;

import java.util.Arrays;

public class A_BestTimeToBuyAndSellStockI {
    public int maxProfit(int[] prices) {
        // For this We need to track Only Two Elements MinPrice and MaxProfit
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

    // Main method to run the program inside VS Code
    public static void main(String[] args) {
        A_BestTimeToBuyAndSellStockI solver = new A_BestTimeToBuyAndSellStockI();

        // Test case 1: Standard case with valleys and peaks
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test Case 1 - Input: " + Arrays.toString(prices1));
        System.out.println("Output (Max Profit): " + solver.maxProfit(prices1)); // Expected: 5 (Buy at 1, Sell at 6)

        // Test case 2: Prices only go down (No profit possible)
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("\nTest Case 2 - Input: " + Arrays.toString(prices2));
        System.out.println("Output (Max Profit): " + solver.maxProfit(prices2)); // Expected: 0
    }
}
