package DSA_Revision.Arrays;

import java.util.Arrays;

public class B_BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        // Track the current buying baseline
        int minPrice = Integer.MAX_VALUE;
        // Accumulate total profits across multiple transactions
        int totalProfit = 0;

        for (int price : prices) {
            // Step 1: Update the baseline if a cheaper buying day is found
            minPrice = Math.min(minPrice, price);
            
            // Step 2: Check if selling today yields a positive profit
            int currentProfit = price - minPrice;
            
            if (currentProfit > 0) {
                // Accumulate the profit
                totalProfit += currentProfit; 
                // CRITICAL: Reset baseline to today's price to look for next gains
                minPrice = price; 
            }
        }

        return totalProfit;
    }

    // Main method to run the program inside VS Code
    public static void main(String[] args) {
        B_BestTimeToBuyAndSellStockII solver = new B_BestTimeToBuyAndSellStockII();
        
        // Test case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test Case 1 - Input: " + Arrays.toString(prices1));
        System.out.println("Output: " + solver.maxProfit(prices1)); // Expected: 7
        
        // Test case 2
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("\nTest Case 2 - Input: " + Arrays.toString(prices2));
        System.out.println("Output: " + solver.maxProfit(prices2)); // Expected: 4
    }
}
