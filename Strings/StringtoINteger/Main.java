package Strings.StringtoINteger;

public class Main {

    // Your optimized LeetCode Solution class logic
    public static class Solution {
        public int myAtoi(String s) {
            // Removes leading and trailing spaces
            s = s.trim();

            // Handle empty string edge case safely
            if (s.isEmpty()) {
                return 0;
            }
            
            int sign = 1; // By default positive
            int i = 0;
            
            // Check for first bit to be - or +
            if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                sign = (s.charAt(i) == '-') ? -1 : 1;
                i++;
            }

            int num = 0;

            // Loop while we are within bounds and current character is a digit
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                int digit = s.charAt(i) - '0';
                
                // Check for 32-bit integer overflow before updating num
                if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                
                num = (num * 10) + digit;
                i++;
            }
            
            // Operator precedence fix: sign * num evaluated first, then cast to int
            return (int) (sign * num);
        }
    }

    // Main execution point to run and test your code
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Array of various tricky test scenarios
        String[] testInputs = {
            "42",                    // Basic positive integer
            "   -42",                // Leading spaces and negative sign
            "1337c0d3",              // Reading stops at non-digit character 'c'
            "0-1",                   // Reading stops at '-' because it is not the first character
            "words and 987",         // Stops immediately; first character after trim isn't a digit/sign
            "-91283472332",          // Underflow: exceeds Integer.MIN_VALUE boundary
            "2147483648",            // Overflow: exceeds Integer.MAX_VALUE boundary
            "   ",                   // Empty string check (prevents out of bounds exception)
            "+"                      // Only sign provided
        };

        System.out.println("--- LeetCode 8: String to Integer (atoi) Test Results ---");
        for (String input : testInputs) {
            int result = solver.myAtoi(input);
            // Replaces actual whitespace with visual placeholders for clearer printing
            String visibleInput = input.replace(" ", "[space]"); 
            System.out.printf("Input: \"%s\" -> Output: %d\n", visibleInput, result);
        }
    }
}
