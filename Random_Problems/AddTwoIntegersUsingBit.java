package Random_Problems;
public class AddTwoIntegersUsingBit {

    public static int getSum(int a, int b) {
        while (b != 0) {
            // 1. Calculate carry bits and shift them left by 1 position
            int carry = (a & b) << 1; 
            
            // 2. Sum bits without carrying using XOR
            a = a ^ b; 
            
            // 3. Move the carry to b to add it in the next loop
            b = carry; 
        }
        return a;
    }

    // Main method to run and test your code inside VS Code
    public static void main(String[] args) {

        // Test Case 1: Positive numbers (1 + 2 = 3)
        int result1 = getSum(1, 2);
        System.out.println("Test 1 (1 + 2): " + result1);

        // Test Case 2: Handling zero (0 + 5 = 5)
        int result2 = getSum(0, 5);
        System.out.println("Test 2 (0 + 5): " + result2);

        // Test Case 3: Negative numbers (-2 + 3 = 1)
        int result3 =getSum(-2, 3);
        System.out.println("Test 3 (-2 + 3): " + result3);
    }
}
