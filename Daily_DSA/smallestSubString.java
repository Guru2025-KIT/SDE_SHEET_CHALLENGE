package Daily_DSA;

import java.util.Stack;

public class smallestSubString {
    public String smallestSubsequence(String s) {
        // Track the last seen index of each character
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // Track whether a character is currently inside our stack
        boolean[] inStack = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';

            // Skip the character if it is already included in our result stack
            if (inStack[idx]) {
                continue;
            }

            // Maintain monotonic increasing order in the stack
            // Pop the top character if it is lexicographically larger than the current character
            // AND if it appears again later in the string
            while (!stack.isEmpty() && stack.peek() > ch && lastIndex[stack.peek() - 'a'] > i) {
                char removed = stack.pop();
                inStack[removed - 'a'] = false; // Mark as no longer in stack
            }

            // Push current character and mark it as visited
            stack.push(ch);
            inStack[idx] = true;
        }

        // Build the final string from the stack
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }

    // Main method to run and test your code inside VS Code
    public static void main(String[] args) {
        smallestSubString solver = new smallestSubString();

        // Test Case 1: Standard input
        String result1 = solver.smallestSubsequence("bcabc");
        System.out.println("Test 1 (\"bcabc\"): " + result1); // Expected: "abc"

        // Test Case 2: Out of order input
        String result2 = solver.smallestSubsequence("cbacdcbc");
        System.out.println("Test 2 (\"cbacdcbc\"): " + result2); // Expected: "acdb"
    }
}
