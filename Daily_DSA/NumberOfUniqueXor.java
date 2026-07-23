package Daily_DSA;
public class NumberOfUniqueXor {
    public static void main(String[] args) {
        // Mock array to establish context
        int[] nums = {1, 2, 3, 4, 5}; 
        
        // Step 1: Initialize Length
        // n = nums.length = 5
        int n = nums.length;
        
        // Step 2: Check Base Case
        // Condition if (n < 3) evaluates to 5 < 3, which is false.
        // The code continues execution.
        if (n < 3) {
            return; 
        }
        
        // Step 3: Calculate Leading Zeros
        // In Java, an int is 32 bits. The binary representation of 5 is:
        // 00000000 00000000 00000000 00000101
        // Integer.numberOfLeadingZeros(5) counts the zeros from the left.
        // Number of leading zeros = 29.
        int leadingZeros = Integer.numberOfLeadingZeros(n);
        
        // Step 4: Calculate Total Bits
        // bits = 32 - 29 = 3
        int bits = 32 - leadingZeros;
        
        // Step 5: Compute Bitwise Shift
        // 1 << bits becomes 1 << 3.
        // Binary 1 (0001) shifted left by 3 positions becomes 1000.
        // Result = 8 in decimal.
        int result = 1 << bits;
        
        // Output the result to verify the steps
        System.out.println("Result: " + result);
    }
}
