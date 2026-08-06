package Daily_DSA;
/**
 * LeetCode 3345: Smallest Divisible Digit Product I
 * Complexity Analysis:
 * - Time Complexity: O(1) because a number with a digit product divisible by t 
 *   is guaranteed to be found within at most 10 consecutive iterations.
 * - Space Complexity: O(1) auxiliary space.
 */
public class SmallestDivisibleDigitProductI {

    // Helper method to calculate the product of digits of a given number
    private int checkNum(int n, int t) {
        int num = n;
        int product = 1;
        while (num > 0) {
            int digit = num % 10;
            product *= digit;
            num /= 10;
        }
        return product;
    }

    // Main solution logic matching your approach
    public int smallestNumber(int n, int t) {
        int result = 0;
        
        // If the product of digits of n is already divisible by t, return n directly
        if (checkNum(n, t) % t == 0) {
            return n;
        } else {
            // Otherwise, increment n and test the subsequent numbers sequentially
            for (int i = 1; i <= 10; i++) {
                if (checkNum(n + i, t) % t == 0) {
                    result = n + i;
                    return n + i;
                }
            }
        }
        return result;
    }

    // VS Code Runner Main Method
    public static void main(String[] args) {
        SmallestDivisibleDigitProductI solver = new SmallestDivisibleDigitProductI();

        // Test Case 1
        int n1 = 10, t1 = 2;
        System.out.println("Input: n = " + n1 + ", t = " + t1);
        System.out.println("Output: " + solver.smallestNumber(n1, t1)); // Expected: 10
        
        System.out.println();

        // Test Case 2
        int n2 = 15, t2 = 3;
        System.out.println("Input: n = " + n2 + ", t = " + t2);
        System.out.println("Output: " + solver.smallestNumber(n2, t2)); // Expected: 16
    }
}
