package Strings.LongestPalindromeinstring;

public class Optimal {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd length palindrome (center is at i)
            int len1 = expandAroundCenter(s, i, i);
            // Case 2: Even length palindrome (center is between i and i+1)
            int len2 = expandAroundCenter(s, i, i + 1);
            
            int maxLen = Math.max(len1, len2);
            
            // If a longer palindrome is found, update the boundaries
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Returns the length of the palindrome found
        return right - left - 1;
    }

    // Main method to run and test your code inside VS Code
    public static void main(String[] args) {
        Optimal solver = new Optimal();

        // Test Case 1: Standard odd/even mix
        String test1 = "babad";
        System.out.println("Input: " + test1);
        System.out.println("Output: " + solver.longestPalindrome(test1)); // Expected: "bab" or "aba"
        System.out.println("------------------------------------");

        // Test Case 2: Even length palindrome
        String test2 = "cbbd";
        System.out.println("Input: " + test2);
        System.out.println("Output: " + solver.longestPalindrome(test2)); // Expected: "bb"
        System.out.println("------------------------------------");

        // Test Case 3: Edge case - single character
        String test3 = "a";
        System.out.println("Input: " + test3);
        System.out.println("Output: " + solver.longestPalindrome(test3)); // Expected: "a"
    }
}
