package Strings.RomanToInteger;

import java.util.*;

class Solution {
    public int romanToInt(String s) {
        int res = 0;
        
        // Create a map of Roman numerals to integers
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        // Loop through the string, except the last character
        for (int i = 0; i < s.length() - 1; i++) {
            // Subtract if current value is less than next value
            if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                res -= roman.get(s.charAt(i));
            } else {
                // Otherwise, add the value
                res += roman.get(s.charAt(i));
            }
        }

        // Add the value of the last character
        return res + roman.get(s.charAt(s.length() - 1));
    }
}

public class Optimal {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "MCMXCIV"; 
        int result = sol.romanToInt(s);
        System.out.println("Integer value: " + result);
    }
}
