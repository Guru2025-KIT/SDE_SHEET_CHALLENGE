package DSA_Revision.Arrays.Array1;
import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 118: Pascal's Triangle
 * Complexity Analysis:
 * - Time Complexity: O(numRows^2) due to the nested loops generating every element.
 * - Space Complexity: O(numRows^2) to store the output triangle structure.
 */
public class A_PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        // Initialize the master list to hold all rows of the triangle
        List<List<Integer>> result = new ArrayList<>();
        
        // Edge Case: Return empty list if rows requested is 0 or negative
        if (numRows <= 0) {
            return result;
        }
        
        // Outer loop: Generates each row sequentially (0-indexed)
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            
            // Inner loop: Populates elements for the current row
            for (int j = 0; j <= i; j++) {
                // Rule 1: The boundaries (first and last elements) are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Rule 2: Inner elements are the sum of the two elements directly above it
                    List<Integer> prev = result.get(i - 1);
                    int sum = prev.get(j - 1) + prev.get(j);
                    row.add(sum);
                }
            }
            
            // Append the fully constructed row to the final triangle list
            result.add(row);
        }
        
        return result;
    }

    // VS Code Runner Main Method
    public static void main(String[] args) {
        A_PascalsTriangle solver = new A_PascalsTriangle();
        
        // Test Case: Generate 5 rows of Pascal's Triangle
        int numRows = 5;
        List<List<Integer>> triangle = solver.generate(numRows);
        
        // Print the formatted output in the VS Code terminal
        System.out.println("Pascal's Triangle for " + numRows + " rows:");
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }
}
