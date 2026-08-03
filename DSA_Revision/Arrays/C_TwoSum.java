package DSA_Revision.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class C_TwoSum {
    public static void main(String[] args) {
        C_TwoSum solver = new C_TwoSum();

        // Test Case 1: Unsorted array -> Expected output: [1, 2] (Indices of 2 and 4)
        int[] nums1 = {3, 2, 4};
        int target1 = 6;
        System.out.println("Test 1 Result: " + Arrays.toString(solver.twoSum(nums1, target1)));

        // Test Case 2: Standard LeetCode example -> Expected output: [0, 1]
        int[] nums2 = {2, 7, 11, 15};
        int target2 = 9;
        System.out.println("Test 2 Result: " + Arrays.toString(solver.twoSum(nums2, target2)));
    }

    public int[] twoSum(int[] nums, int target) {
        // Two Pointer Approach will not work here because to apply it array must be sorted 
        // but if I sort array Original Indices will be lost.
        // So Using Map is the best Approach!
        
        // Map to store: Key = Number value, Value = Index of that number
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int required = target - current;
            
            // Check if the number we need is already seen
            if (map.containsKey(required)) {
                return new int[]{map.get(required), i};
            }
            
            // If not found, save the current number and index for later lookup
            map.put(current, i);
        }
        
        return new int[]{-1, -1};
    }
}
