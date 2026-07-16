package Daily_DSA;

import java.util.Arrays;

public class gcdMa {

    /**
     * Computes the Greatest Common Divisor (GCD) of two numbers 
     * using the iterative Euclidean algorithm.
     */
    private static long gcd(long a, long b) {
        // Continue looping until the remainder (b) becomes 0
        while (b != 0) {
            long temp = b;   // Temporarily store the current remainder
            b = a % b;       // Find the new remainder using modulo
            a = temp;        // Move the old remainder to 'a'
        }
        return Math.abs(a);  // Return absolute value to ensure positive GCD
    }

    /**
     * Main logic to calculate the special GCD sum from an array.
     */
    public long gcdSum(int[] nums) {
        int mx = -1;
        int n = nums.length;
        long result = 0;
        long[] prefixGcd = new long[n];

        // Step 1: Calculate running maximum and find prefix GCDs
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);       // Track highest element seen so far
            prefixGcd[i] = gcd(nums[i], mx);  // Find GCD of current number and max
        }

        // Step 2: Sort the resulting GCD array in ascending order
        Arrays.sort(prefixGcd);

        // Step 3: Pair elements from opposite ends and calculate their GCD
        for (int i = 0; i < n / 2; i++) {
            // Pair the smallest element (i) with the largest element (n - i - 1)
            result += gcd(prefixGcd[i], prefixGcd[n - i - 1]);
        }

        return result; // Return total accumulated sum
    }

    /**
     * Entry point to run and test the program in VS Code.
     */
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Sample test array
        int[] testInput = {12, 24, 6, 18};

        // Execute the method
        long finalResult = solver.gcdSum(testInput);

        // Display results in the VS Code terminal
        System.out.println("Input Array: " + Arrays.toString(testInput));
        System.out.println("Calculated GCD Sum: " + finalResult);
    }
}
