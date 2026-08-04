package Random_Problems;
public class MaximizePairStrengthUsingGCD {
    public long maxPairStrength(int[] nums) {
        long maxStrength = 0;
        int n = nums.length;
        
        // Two nested loops to compare all possible unique pairs (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long gcdValue = gcd(nums[i], nums[j]);
                
                // Explicit long cast avoids 32-bit integer multiplication overflow
                long strength = ((long) nums[i] * nums[j]) / (gcdValue * gcdValue);
                
                if (strength > maxStrength) {
                    maxStrength = strength;
                }
            }
        }
        return maxStrength;
    }

    // Fast Modulo-based Euclidean GCD Algorithm
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Main entry point for local execution inside VS Code
    public static void main(String[] args) {
        MaximizePairStrengthUsingGCD solver = new MaximizePairStrengthUsingGCD();

        // Test Case 1
        int[] nums1 = {7, 18, 12};
        long result1 = solver.maxPairStrength(nums1);
        System.out.println("Test Case 1 Output: " + result1 + " (Expected: 126)");

        // Test Case 2
        int[] nums2 = {10, 4, 19};
        long result2 = solver.maxPairStrength(nums2);
        System.out.println("Test Case 2 Output: " + result2 + " (Expected: 190)");
    }
}
