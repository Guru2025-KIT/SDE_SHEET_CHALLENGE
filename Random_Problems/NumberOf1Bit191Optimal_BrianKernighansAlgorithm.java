package Random_Problems;

public class NumberOf1Bit191Optimal_BrianKernighansAlgorithm {

    public static int hammingWeight(int n) {
        int count = 0;

        // Loop runs ONLY as many times as there are 1 bits in the number
        while (n != 0) {
            // n & (n - 1) clears the lowest (rightmost) set bit to 0
            n = n & (n - 1);
            
            // Increment count for the bit we just cleared
            count++;
        }

        return count;
    }


    public static void main(String[] args) {
    

        // Test Case 1: Binary 1011 (Decimal 11) -> Expected: 3
        int test1 = 11; 
        // Test Case 2: Binary 11111111111111111111111111111111 (Decimal -1) -> Expected: 32
        int test2 = -1; 

        System.out.println("--- Brian Kernighan's Algorithm ---");
        System.out.println("Input: " + test1 + " | Output: " +hammingWeight(test1));
        System.out.println("Input: " + test2 + " | Output: " +hammingWeight(test2));
    }
}
