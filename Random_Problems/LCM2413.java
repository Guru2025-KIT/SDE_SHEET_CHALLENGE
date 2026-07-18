package Random_Problems;

// Your LeetCode 2413 Solution Class
class Solution {
    public int smallestEvenMultiple(int n) {
        // LCM 
        // If number is even, then the LCM of number n and 2 is n itself.
        // If it is odd, then LCM is 2 * n.
        if (n % 2 == 0) {
            return n;
        } else {
            return 2 * n;
        }
    }
}

// Wrapper Main class to execute the code
public class LCM2413 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Odd Number (Expected output: 5 * 2 = 10)
        int test1 = 5;
        System.out.println("Input: " + test1 + " -> Smallest Even Multiple: " + solution.smallestEvenMultiple(test1));

        // Test Case 2: Even Number (Expected output: 6)
        int test2 = 6;
        System.out.println("Input: " + test2 + " -> Smallest Even Multiple: " + solution.smallestEvenMultiple(test2));
    }
}
