package Random_Problems;


public class AlternatingBinaryBits {
    
    // LeetCode Method: Bitwise O(1) Solution
    public boolean hasAlternatingBits(int n) {
        // Step 1: Shift and XOR. If bits alternate, xor will be all 1s.
        int xor = n ^ (n >> 1);
        
        // Step 2: Check if xor + 1 clears all bits.
        return (xor & (xor + 1)) == 0;
    }

    // Main method to run and test locally in VS Code
    public static void main(String[] args) {
        AlternatingBinaryBits solver = new AlternatingBinaryBits();
        
        // Test Case 1: 5 -> Binary: 101
        int test1 = 5;
        System.out.println("Test 1 (5): " + solver.hasAlternatingBits(test1)); // Expected: true

        // Test Case 2: 7 -> Binary: 111
        int test2 = 7;
        System.out.println("Test 2 (7): " + solver.hasAlternatingBits(test2)); // Expected: false

        // Test Case 3: 10 -> Binary: 1010
        int test3 = 10;
        System.out.println("Test 3 (10): " + solver.hasAlternatingBits(test3)); // Expected: true

        // Test Case 4: 11 -> Binary: 1011
        int test4 = 11;
        System.out.println("Test 4 (11): " + solver.hasAlternatingBits(test4)); // Expected: false
    }
}
