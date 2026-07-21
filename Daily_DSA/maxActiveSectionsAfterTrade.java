package Daily_DSA;

import java.util.ArrayList;
import java.util.List;

public class maxActiveSectionsAfterTrade {
    public int maxActiveSectionsAfteTrade(String s) {
        int totalOnes = 0;
        int n = s.length();
        
        // Calculate the total ones
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
        }
        
        // Create list to hold the zeroSegments
        List<Integer> zeroSegments = new ArrayList<>();
        int i = 0;
        while (i < n) {
            // If zero occurs then it is starting of zero frame so count further zeros
            if (s.charAt(i) == '0') {
                int zeroCount = 0;
                while (i < n && s.charAt(i) == '0') {
                    zeroCount++;
                    i++;
                }
                // After counting zeros add this number to list
                zeroSegments.add(zeroCount);
            } else {
                i++;
            }
        }
        
        // If zero count is less than 2 we do not need to replace any 0 with 1
        if (zeroSegments.size() < 2) {
            return totalOnes;
        }
        
        int mergeGainZeros = 0;
        // Now using indexing add previous zeroGroup count and latest zero group count
        for (int j = 1; j < zeroSegments.size(); j++) {
            int currentGain = zeroSegments.get(j - 1) + zeroSegments.get(j);
            mergeGainZeros = Math.max(mergeGainZeros, currentGain);
        }
        
        return totalOnes + mergeGainZeros;
    }

    // Main method to run and test in VS Code
    public static void main(String[] args) {
        maxActiveSectionsAfterTrade solver = new maxActiveSectionsAfterTrade();

        // Array of test cases
        String[] testCases = {
            "01", 
            "0100", 
            "1000100", 
            "01010"
        };

        // Expected outputs based on LeetCode examples
        int[] expected = {1, 4, 7, 4};

        System.out.println("--- Running Test Cases ---");
        for (int k = 0; k < testCases.length; k++) {
            int result = solver.maxActiveSectionsAfteTrade(testCases[k]);
            System.out.println("Input: \"" + testCases[k] + "\"");
            System.out.println("Output: " + result + " | Expected: " + expected[k]);
            System.out.println(result == expected[k] ? "✅ PASSED" : "❌ FAILED");
            System.out.println("--------------------------");
        }
    }
}
