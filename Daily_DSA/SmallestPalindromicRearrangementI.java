package Daily_DSA;
import java.util.Arrays;

public class SmallestPalindromicRearrangementI {

    //solution class logic
    public static class Solution {
        public String smallestPalindrome(String s) {
            if (s.length() <= 1) {
                return s;
            }
            
            int n = s.length();
            String firstHalf = "";
            for (int i = 0; i < n / 2; i++) {
                firstHalf += s.charAt(i);
            }
            
            char[] pre = firstHalf.toCharArray();
            Arrays.sort(pre); // Sort to ensure lexicographically smallest order
            
            String sortedFirstHalf = new String(pre);
            String finalResult = sortedFirstHalf;
            
            if (n % 2 == 0) {
                finalResult += new StringBuilder(sortedFirstHalf).reverse().toString();
            } else {
                char mid = s.charAt(n / 2); // Correct middle index
                finalResult = sortedFirstHalf + mid + new StringBuilder(sortedFirstHalf).reverse().toString();
            }
            
            return finalResult;
        }
    }

    // Main method to run and debug the code inside VS Code
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1: Odd length palindrome
        String input1 = "babab";
        String output1 = solver.smallestPalindrome(input1);
        System.out.println("Input:  " + input1);
        System.out.println("Output: " + output1); // Expected: abbba
        System.out.println("--------------------");

        // Test Case 2: Even length palindrome
        String input2 = "baab";
        String output2 = solver.smallestPalindrome(input2);
        System.out.println("Input:  " + input2);
        System.out.println("Output: " + output2); // Expected: abba
    }
}
