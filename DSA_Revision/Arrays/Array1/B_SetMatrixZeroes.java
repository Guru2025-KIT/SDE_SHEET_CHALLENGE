package DSA_Revision.Arrays.Array1;

import java.util.Arrays;

/**
 * LeetCode 73: Set Matrix Zeroes
 * Complexity Analysis:
 * - Time Complexity: O(m * n) where m is rows and n is columns.
 * - Space Complexity: O(1) auxiliary space as we reuse the first row and column.
 */
public class B_SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean firstRowZero = false;
        boolean firstColZero = false;
        
        // Step 1: Check if there is any 0 element in the First Row
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        
        // Step 2: Check if there is any 0 element in the First Column
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        
        // Step 3: Use the 1st row and 1st column as flag markers for the inner matrix
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark the row header
                    matrix[0][j] = 0; // Mark the column header
                }
            }
        }
        
        // Step 4: Update the inner matrix cells to zero based on the border markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Step 5: Update the first row if the flag is true
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        
        // Step 6: Update the first column if the flag is true
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // VS Code Runner Main Method
    public static void main(String[] args) {
        B_SetMatrixZeroes solver = new B_SetMatrixZeroes();
        
        // Test Case Matrix (3x4)
        int[][] matrix = {
            {1, 1, 1, 1},
            {1, 0, 1, 1},
            {1, 1, 1, 1}
        };
        
        System.out.println("Original Matrix:");
        printMatrix(matrix);
        
        // Execute the algorithm
        solver.setZeroes(matrix);
        
        System.out.println("\nMatrix After setZeroes:");
        printMatrix(matrix);
    }
    
    // Helper method to print the matrix cleanly in the terminal
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
