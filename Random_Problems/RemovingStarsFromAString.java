package Random_Problems;

import java.util.Stack;

public class RemovingStarsFromAString {

    // Your solution class logic with your comments included
    public static class Solution {
        public String removeStars(String s) {
            /* 
             * Build the Stack: Loop through the string, pushing normal letters 
             * onto the stack and popping them off whenever you hit a star (*). 
             * 
             * Rebuild the String: Empty the stack into a StringBuilder, 
             * then reverse it to get your final characters back in the correct order.
             */
            Stack<Character> stack = new Stack<>();
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '*') {
                    if (!stack.isEmpty()) { // Added safety check to prevent crashes
                        stack.pop();
                    }
                } else {
                    stack.push(s.charAt(i));
                }
            }
            
            StringBuilder result = new StringBuilder();
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }
            
            return result.reverse().toString();
        }
    }

    // Main method to run and debug the code inside VS Code
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1
        String input1 = "leet**cod*e";
        String output1 = solver.removeStars(input1);
        System.out.println("Input:  " + input1);
        System.out.println("Output: " + output1); // Expected: lecoe
        System.out.println("--------------------");

        // Test Case 2
        String input2 = "erase*****";
        String output2 = solver.removeStars(input2);
        System.out.println("Input:  " + input2);
        System.out.println("Output: " + output2); // Expected: "" (Empty string)
    }
}
