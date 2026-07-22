package Random_Problems;

public class ransomeNote {
    
    // LeetCode Method
    public boolean canConstruct(String ransomNote, String magazine) {
        // Optimize early exit if magazine is shorter than the note
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        
        int[] letterCounts = new int[26];
        
        // Count frequencies in the magazine
        for (char c : magazine.toCharArray()) {
            letterCounts[c - 'a']++;
        }
        
        // Match and consume required letters
        for (char c : ransomNote.toCharArray()) {
            letterCounts[c - 'a']--;
            if (letterCounts[c - 'a'] < 0) {
                return false;
            }
        }
        
        return true;
    }

    // Main method to run and test locally
    public static void main(String[] args) {
        ransomeNote solver = new ransomeNote();
        
        // Test Case 1
        String note1 = "a";
        String mag1 = "b";
        System.out.println("Test 1 Result: " + solver.canConstruct(note1, mag1)); // Expected: false

        // Test Case 2
        String note2 = "aa";
        String mag2 = "ab";
        System.out.println("Test 2 Result: " + solver.canConstruct(note2, mag2)); // Expected: false

        // Test Case 3
        String note3 = "aa";
        String mag3 = "aab";
        System.out.println("Test 3 Result: " + solver.canConstruct(note3, mag3)); // Expected: true
    }
}
