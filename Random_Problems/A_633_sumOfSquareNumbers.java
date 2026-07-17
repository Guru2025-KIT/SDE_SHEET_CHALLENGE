package Random_Problems;

class Solution {
    
    public boolean judgeSquareSum(int c) {
        // Use long to prevent integer overflow when squaring large numbers
        long left = 0;
        
        // Start the right pointer at the square root of c
        long right = (long) Math.sqrt(c);
        
        // Use <= because a number can be added to itself (e.g., c = 2 is 1^2 + 1^2)
        while (left <= right) {
            // Calculate the sum of squares for the current pointers
            long currentSum = left * left + right * right;
            
            // Found a valid pair
            if (currentSum == c) {
                return true; 
            } 
            // If the sum is too small, increase the smaller value
            else if (currentSum < c) {
                left++;
            } 
            // If the sum is too big, decrease the larger value
            else {
                right--;
            }
        }
        
        // No matching pair found after searching the entire range
        return false;
    }

public class sumOfSquareNumbers {
    
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test cases
        int[] testCases = {2, 4, 5, 3};

        System.out.println("--- Running Test Cases ---");
        for (int c : testCases) {
            boolean result = solver.judgeSquareSum(c);
            System.out.println("Input c = " + c + " | Output: " + result);
        }
    }
}
}