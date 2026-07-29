package Daily_DSA;

public class KthSmallestPalindromePermutation { 
    // Large ceiling limit to prevent numeric overflow issues with k (stops overflow during math operations)
    private static final long INF = 2_000_000_000_000_000_000L; 

    public String smallestPalindrome(String s, int k) { 
        // Step 1: Count frequency of each character in the string
        int[] totalCounts = new int[26]; 
        for (char c : s.toCharArray()) { 
            totalCounts[c - 'a']++; 
        } 

        // Step 2: Check validity of palindrome. At most 1 character can have an odd count.
        int oddCount = 0; 
        char midChar = '#'; // Acts as a placeholder if no middle odd character exists
        for (int i = 0; i < 26; i++) { 
            if (totalCounts[i] % 2 != 0) { 
                oddCount++; 
                midChar = (char) (i + 'a'); // Save the single odd character for the absolute center
            } 
        } 

        // If more than 1 character has an odd count, a palindrome cannot be formed
        if (oddCount > 1) return ""; 

        // Step 3: Populate the requirements for just the left-half of the palindrome
        int[] halfCounts = new int[26]; 
        int halfLen = 0; 
        for (int i = 0; i < 26; i++) { 
            halfCounts[i] = totalCounts[i] / 2; // Keep exactly half of the available characters
            halfLen += halfCounts[i]; 
        } 

        // Step 4: Verify if total unique permutations are enough to satisfy the requested 'k'
        long totalPermutations = countPermutations(halfCounts, halfLen); 
        if (totalPermutations < k) return ""; // Not enough configurations to reach the k-th choice

        StringBuilder leftHalf = new StringBuilder(); 
        long currentK = k; 

        // Step 5: Construct the left half of the string character by character (Lexicographically)
        for (int pos = 0; pos < halfLen; pos++) { 
            // Try placing characters from 'a' to 'z' sequentially to ensure smallest lexicographical order
            for (int i = 0; i < 26; i++) { 
                if (halfCounts[i] > 0) { 
                    // Temporarily allocate character 'i' at this index
                    halfCounts[i]--; 
                    
                    // Count how many unique combinations can be formed with the remaining characters
                    long optionsLeft = countPermutations(halfCounts, halfLen - 1 - pos); 
                    
                    if (currentK <= optionsLeft) { 
                        // The target configuration lies inside this character's block
                        leftHalf.append((char) (i + 'a')); // Lock the choice
                        break; // Progress to the next string index position
                    } else { 
                        // The target configuration lies beyond this block. Skip it.
                        currentK -= optionsLeft; // Subtract the skipped permutations from our target k
                        halfCounts[i]++; // Revert the character choice and try the next letter
                    } 
                } 
            } 
        } 

        // Step 6: Mirror the left half to form the final balanced palindrome string
        String left = leftHalf.toString(); 
        String right = new StringBuilder(left).reverse().toString(); 
        
        // Return full construction: Left Half + Middle Odd Character (if any) + Right Half
        return left + (midChar == '#' ? "" : midChar) + right; 
    } 

    // Helper math calculation using Multinomial Coefficient Formula: N! / (n1! * n2! * ...)
    private long countPermutations(int[] counts, int totalItems) { 
        long arrangements = 1; 
        int itemsLeft = totalItems; 
        for (int count : counts) { 
            if (count > 0) { 
                // Multiply the cumulative configurations securely against numerical overflow
                arrangements = multiplyWithCap(arrangements, nCr(itemsLeft, count)); 
                itemsLeft -= count; // Reduce the bucket pool size
            } 
        } 
        return arrangements; 
    } 

    // Combination math helper (n Choose r) implemented optimally
    private long nCr(int n, int r) { 
        if (r > n) return 0; 
        if (r == 0 || r == n) return 1; 
        if (r > n - r) r = n - r; // Optimize computations using symmetry property
        long ans = 1; 
        for (int i = 1; i <= r; i++) { 
            ans = multiplyWithCap(ans, n - i + 1); 
            ans /= i; 
        } 
        return ans; 
    } 

    // Secure multiplication processing to forcefully clip growth boundaries at INF value
    private long multiplyWithCap(long a, long b) { 
        if (b == 0) return 0; 
        if (a > INF / b) return INF; // Overflow boundary triggered, cap the result safely
        return a * b; 
    } 

    // VS Code Execution entry point
    public static void main(String[] args) {
        KthSmallestPalindromePermutation solver = new KthSmallestPalindromePermutation();

        System.out.println("--- Running Palindrome Permutation Test Cases ---");
        
        // Test Case 1: Simple execution
        String s1 = "aabb"; int k1 = 1;
        System.out.println("Input: s = \"" + s1 + "\", k = " + k1);
        System.out.println("Output: \"" + solver.smallestPalindrome(s1, k1) + "\"\n"); // Expected: "abba"

        // Test Case 2: Multi-character configuration 
        String s2 = "aabb"; int k2 = 2;
        System.out.println("Input: s = \"" + s2 + "\", k = " + k2);
        System.out.println("Output: \"" + solver.smallestPalindrome(s2, k2) + "\"\n"); // Expected: "baab"

        // Test Case 3: Impossible configuration (More than 1 odd element count)
        String s3 = "abc"; int k3 = 1;
        System.out.println("Input: s = \"" + s3 + "\", k = " + k3);
        System.out.println("Output: \"" + solver.smallestPalindrome(s3, k3) + "\""); // Expected: ""
    }
}
