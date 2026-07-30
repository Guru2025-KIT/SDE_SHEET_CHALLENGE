package Strings;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    // Your original Stack-based solution
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else if (stack.peek() == c) {
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    // Main method to run and validate the code inside VS Code
    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString solver = new RemoveAllAdjacentDuplicatesInString();

        // Test Case 1
        String test1 = "abbaca";
        String expected1 = "ca";
        String result1 = solver.removeDuplicates(test1);
        System.out.println("Test Case 1: " + test1);
        System.out.println("Expected   : " + expected1);
        System.out.println("Result     : " + result1);
        System.out.println("Passed     : " + result1.equals(expected1));
        System.out.println("------------------------------------");

        // Test Case 2
        String test2 = "azxxzy";
        String expected2 = "ay";
        String result2 = solver.removeDuplicates(test2);
        System.out.println("Test Case 2: " + test2);
        System.out.println("Expected   : " + expected2);
        System.out.println("Result     : " + result2);
        System.out.println("Passed     : " + result2.equals(expected2));
    }
}
