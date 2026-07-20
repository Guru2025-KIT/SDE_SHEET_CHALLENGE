package Daily_DSA;
import java.util.ArrayList;
import java.util.List;

// Main wrapper class matching the file name for VS Code execution
public class Shift2DGreed {
    public static void main(String[] args) {
        // 1. Define a sample 2D grid test case
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int k = 1; // Number of shifts

        // 2. Instantiate the LeetCode Solution class
        Solution solver = new Solution();
        List<List<Integer>> shiftedGrid = solver.shiftGrid(grid, k);

        // 3. Print the input and output for verification
        System.out.println("Original Grid shifted by k = " + k + ":");
        System.out.println(shiftedGrid);
    }
}

// LeetCode Solution Class
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length; 
        int totalElements = m * n;
        
        k = k % totalElements;
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            result.add(new ArrayList<>(n));
            for (int j = 0; j < n; j++) {
                result.get(i).add(0);
            }
        }
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int original1DIndex = r * n + c;
                int new1DIndex = (original1DIndex + k) % totalElements;
                
                int newRow = new1DIndex / n;
                int newCol = new1DIndex % n;
                
                result.get(newRow).set(newCol, grid[r][c]);
            }
        }
        return result;
    }
}
