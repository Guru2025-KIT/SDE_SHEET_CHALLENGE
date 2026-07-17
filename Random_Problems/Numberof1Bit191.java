package Random_Problems;

// Save this file exactly as NumberOf1Bit191.java in VS Code
public class Numberof1Bit191 {

    public int hammingWeight(int n) {
        int count = 0;

        // Loop runs until all bits are shifted out and n becomes 0
        while (n != 0) {
            // Check if the last bit is a 1 using bitwise AND
            if ((n & 1) == 1) {
                count++;
            }
            // Use logical (unsigned) right shift to fill leftmost bits with 0.
            // This prevents infinite loops when processing negative numbers.
            n >>>= 1;
        }

        return count;
    }

    // Main method to run and test the code directly in VS Code
    public static void main(String[] args) {
        Numberof1Bit191 solver = new Numberof1Bit191();

        // Test Case 1: Binary 1011 (Decimal 11) -> Expected: 3
        int test1 = 11; 
        // Test Case 2: Binary 10000000000000000000000000000000 (Negative number sign bit) -> Expected: 1
        int test2 = -2147483648; 

        System.out.println("--- Bit-Shifting Approach ---");
        System.out.println("Input: " + test1 + " | Output: " + solver.hammingWeight(test1));
        System.out.println("Input: " + test2 + " | Output: " + solver.hammingWeight(test2));
    }
}

