package Strings.FindFirstOccurence;
class Solution {
    public static int strStr(String haystack, String needle) {
        
        return haystack.indexOf(needle);
        
    }
}

public class main {
    public static void main(String[] args) {

        // Define text and pattern
        String text = "ababcababcabc";
        String pattern = "abc";

        
        int matches=Solution.strStr(text,pattern);
        // Print the result
        System.out.println("Pattern found at indices: " + matches);
    }
}
