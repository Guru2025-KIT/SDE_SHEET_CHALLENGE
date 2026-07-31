package Daily_DSA;

import java.util.Arrays;

/**
 * ALGORITHM EXPLANATION:
 * 
 * 1. COUNT FREQUENCIES
 *    We count how many times each lowercase letter appears in the word.
 *    We store these counts in a fixed-size array of size 26.
 * 
 * 2. SORT TO PRIORITISE
 *    We sort the frequency array. This automatically moves the most 
 *    frequent characters to the very end of the array (highest indices).
 * 
 * 3. GREEDY ASSIGNMENT (THE KEYPAD LAYER LOGIC)
 *    We have 8 optimal keys available (keys 2 to 9) on our phone keypad.
 *    We iterate backwards from the highest frequency to the lowest:
 * 
 *    - The 1st group of 8 unique characters are placed on Layer 1. 
 *      They require exactly 1 push per character.
 *    - The 2nd group of 8 unique characters are placed on Layer 2. 
 *      They require exactly 2 pushes per character.
 *    - The 3rd group of 8 unique characters are placed on Layer 3. 
 *      They require exactly 3 pushes per character.
 *    - Any remaining characters go to Layer 4 and require 4 pushes.
 * 
 * 4. CALCULATE AND RETURN
 *    For each character, we multiply its total frequency by its required 
 *    pushes, add it to our running total, and return the final sum.
 */
public class minimumPushes { 
    public int minimumPushesResult(String word) { 
        int n = word.length(); 
        int[] frequency = new int[26]; 

        // Step 1: Count how many times each letter appears
        for (char c : word.toCharArray()) { 
            frequency[c - 'a']++; 
        } 

        // Step 2: Sort frequencies in ascending order 
        // (Most frequent characters move to the right side)
        Arrays.sort(frequency); 

        int distinctCharCount = 0; 
        int totalPushes = 0; 

        // Step 3: Process characters starting from the most frequent (index 25)
        for (int i = 25; i >= 0; i--) { 
            // If the character doesn't exist in the word, we can stop early
            if (frequency[i] == 0) { 
                break; 
            } 

            // Calculate the required pushes (Layer) based on how many characters we already placed.
            // Every 8 unique characters, the division result increases by 1.
            int pressForChar = (distinctCharCount / 8) + 1; 

            // Total pushes for this specific letter = (how often it appears) * (pushes per press)
            totalPushes += frequency[i] * pressForChar; 

            // Increment our unique character counter to map the next letter
            distinctCharCount++; 
        } 

        // Step 4: Return the absolute minimum pushes needed
        return totalPushes; 
    } 

    // The main method allows you to run and test the code inside VS Code
    public static void main(String[] args) {
        // Create an instance of our class
        minimumPushes solver = new minimumPushes();

        // Test Case 1
        String testWord1 = "abcde";
        System.out.println("Input: " + testWord1);
        System.out.println("Minimum Pushes: " + solver.minimumPushesResult(testWord1)); // Expected Output: 5
        System.out.println("----------------------------------------");

        // Test Case 2
        String testWord2 = "aabbccddeeffgghhiiiiii";
        System.out.println("Input: " + testWord2);
        System.out.println("Minimum Pushes: " + solver.minimumPushesResult(testWord2)); // Expected Output: 24
        System.out.println("----------------------------------------");

        // Test Case 3
        String testWord3 = "xyzxyzxyzxyz";
        System.out.println("Input: " + testWord3);
        System.out.println("Minimum Pushes: " + solver.minimumPushesResult(testWord3)); // Expected Output: 12
    }
}
