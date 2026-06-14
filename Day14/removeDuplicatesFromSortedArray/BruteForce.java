package Day14.removeDuplicatesFromSortedArray;

import java.util.HashSet;


class Solution {
    public int removeDuplicates(int[] nums) {
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        HashSet<Integer> hash = new HashSet<>();
        int count = 0;
        for (int i : nums) {
            if (!hash.contains(i)) {
                hash.add(i);
                nums[count] = i;
                count++;
            }
        }
        return count;
    }
}

public class BruteForce {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard sorted array with duplicates
        int[] nums1 = {1, 1, 2};
        System.out.println("Test Case 1:");
        System.out.println("Original array: [1, 1, 2]");
        int k1 = solution.removeDuplicates(nums1);
        printResult(nums1, k1);

        // Test Case 2: Unsorted array with multiple duplicates
        int[] nums2 = {4, 5, 4, 1, 2, 1, 2, 3};
        System.out.println("\nTest Case 2 (Works for unsorted too):");
        System.out.println("Original array: [4, 5, 4, 1, 2, 1, 2, 3]");
        int k2 = solution.removeDuplicates(nums2);
        printResult(nums2, k2);
    }

    // Helper method to print the modified array up to unique count
    private static void printResult(int[] nums, int k) {
        System.out.println("Unique count: " + k);
        System.out.print("Modified array items: [");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]);
            if (i < k - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

