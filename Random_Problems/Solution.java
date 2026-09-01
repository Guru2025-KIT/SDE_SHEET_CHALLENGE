import java.util.Arrays;

public class Solution {
    // Time Complexity: O(N), since we scan the array once.
    // Space Complexity: O(1), as only constant extra variables are used.
    public int findMaxConsecutiveOnes(int[] nums) { 
        int count = 0; 
        int maxCount = 0; 
        
        for (int i = 0; i < nums.length; i++) { 
            if (nums[i] == 1) {
                count++; 
            }
            if (nums[i] == 0) {
                count = 0; 
            }
            maxCount = Math.max(maxCount, count); 
        } 
        return maxCount; 
    } 

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Mixed 1s and 0s
        int[] nums1 = {1, 1, 0, 1, 1, 1};
        int result1 = solution.findMaxConsecutiveOnes(nums1);
        System.out.println("Array: " + Arrays.toString(nums1));
        System.out.println("Max consecutive ones: " + result1); // Expected: 3
        System.out.println();

        // Test Case 2: No 1s present
        int[] nums2 = {0, 0, 0, 0};
        int result2 = solution.findMaxConsecutiveOnes(nums2);
        System.out.println("Array: " + Arrays.toString(nums2));
        System.out.println("Max consecutive ones: " + result2); // Expected: 0
    }
}
