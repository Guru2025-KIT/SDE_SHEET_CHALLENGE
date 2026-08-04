package Daily_DSA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindMissingElements {
    public List<Integer> findMissingElements(int[] nums) {
        // Edge case: if array is empty, return empty list
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        
        // Step 1: Track existing elements and locate global min/max bounds
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if (min > nums[i]) {
                min = nums[i];
            }
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        
        List<Integer> arr = new ArrayList<>();
        
        // Step 2: Identify missing numbers within the bounds sequentially
        // This loop automatically guarantees that the list is already sorted!
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                arr.add(i);
            }
        }
        
        return arr;
    }

    // Main method to instantly execute your code locally inside VS Code
    public static void main(String[] args) {
        FindMissingElements solver = new FindMissingElements();

        // Test Case 1: Simple array with a few missing values
        int[] nums1 = {3, 10, 5, 6};
        List<Integer> result1 = solver.findMissingElements(nums1);
        System.out.println("Test Case 1 Output: " + result1 + " (Expected: [4, 7, 8, 9])");

        // Test Case 2: Array with duplicates
        int[] nums2 = {1, 1, 5, 5, 2};
        List<Integer> result2 = solver.findMissingElements(nums2);
        System.out.println("Test Case 2 Output: " + result2 + " (Expected: [3, 4])");

        // Test Case 3: No missing values
        int[] nums3 = {1, 2, 3, 4};
        List<Integer> result3 = solver.findMissingElements(nums3);
        System.out.println("Test Case 3 Output: " + result3 + " (Expected: [])");
    }
}
