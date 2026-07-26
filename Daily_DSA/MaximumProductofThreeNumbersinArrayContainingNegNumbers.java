package Daily_DSA;

public class MaximumProductofThreeNumbersinArrayContainingNegNumbers {
    
    public int maximumProduct(int[] nums) {
        // Initialize maximums to the lowest possible value to handle negative numbers
        int max1 = Integer.MIN_VALUE; // Absolute largest
        int max2 = Integer.MIN_VALUE; // Second largest
        int max3 = Integer.MIN_VALUE; // Third largest

        // Initialize minimums to the highest possible value
        int min1 = Integer.MAX_VALUE; // Absolute smallest (most negative)
        int min2 = Integer.MAX_VALUE; // Second smallest

        for (int n : nums) {
            // Block 1: Track the 3 largest values
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            /*
             * CRITICAL FIX: Why we use an independent 'if' here instead of an 'else if':
             * In arrays with all negative numbers (e.g., [-1, -2, -3]) or small sizes,
             * the exact same number must populate BOTH the max trackers and min trackers.
             * Using 'else if' would skip this block if the number already updated a max.
             */
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }

        /*
         * There are only two mathematical scenarios that can yield the maximum product:
         * Scenario 1: The three largest numbers (e.g., all positives like 4 * 5 * 6)
         * Scenario 2: Two massive negatives and the largest positive (e.g., -10 * -10 * 5)
         */
        int product1 = max1 * max2 * max3;
        int product2 = min1 * min2 * max1;

        // Return the absolute highest value between both scenarios
        return Math.max(product1, product2);
    }

    // Main method to run and test the code inside VS Code
    public static void main(String[] args) {
        MaximumProductofThreeNumbersinArrayContainingNegNumbers solver = new MaximumProductofThreeNumbersinArrayContainingNegNumbers();

        // Test Case 1: All negative numbers (The failing edge case)
        int[] test1 = {-1, -2, -3};
        System.out.println("Test 1 Input: [-1, -2, -3]");
        System.out.println("Expected: -6 | Output: " + solver.maximumProduct(test1));
        System.out.println("------------------------------------");

        // Test Case 2: Mixed positive and negative numbers
        int[] test2 = {-10, -10, 5, 2};
        System.out.println("Test 2 Input: [-10, -10, 5, 2]");
        System.out.println("Expected: 500 | Output: " + solver.maximumProduct(test2));
        System.out.println("------------------------------------");

        // Test Case 3: All positive numbers
        int[] test3 = {1, 2, 3, 4};
        System.out.println("Test 3 Input: [1, 2, 3, 4]");
        System.out.println("Expected: 24 | Output: " + solver.maximumProduct(test3));
    }
}
