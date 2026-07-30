package Strings;

public class RemoveAllAdjacentDuplicatesInStringInplace {

    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        int i = 0; // 'i' represents the next available slot in our virtual stack

        for (int j = 0; j < chars.length; j++) {
            // chars[j] is the current character we are inspecting
            
            if (i > 0 && chars[i - 1] == chars[j]) {
                // If stack is not empty and top of stack matches current char,
                // we "pop" by moving our stack pointer one step backward.
                i--;
            } else {
                // Otherwise, we "push" the current character to the top of our stack
                chars[i] = chars[j];
                i++;
            }
        }

        // The valid elements are stored from index 0 up to i (exclusive)
        return new String(chars, 0, i);
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInStringInplace solver = new RemoveAllAdjacentDuplicatesInStringInplace();

        // Verification Test Cases
        String test1 = "abbaca";
        System.out.println("Input: " + test1 + " -> Output: " + solver.removeDuplicates(test1)); // Output: ca

        String test2 = "azxxzy";
        System.out.println("Input: " + test2 + " -> Output: " + solver.removeDuplicates(test2)); // Output: ay
    }
}
