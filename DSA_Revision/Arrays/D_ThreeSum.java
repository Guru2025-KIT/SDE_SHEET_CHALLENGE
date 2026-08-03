package DSA_Revision.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D_ThreeSum {
    public static void main(String[] args) {
        D_ThreeSum solver = new D_ThreeSum();

        // Test Case 1: Standard case with duplicates -> Expected: [[-1, -1, 2], [-1, 0, 1]]
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test 1 Result: " + solver.ThreeSum(nums1));

        // Test Case 2: All zeros -> Expected: [[0, 0, 0]]
        int[] nums2 = {0, 0, 0, 0};
        System.out.println("Test 2 Result: " + solver.ThreeSum(nums2));
    }

    public List<List<Integer>> ThreeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        
        // 1. Sort the array to use two pointers and easily skip duplicate elements
        Arrays.sort(nums);
        
        // 2. Fix the first element of the triplet
        for (int i = 0; i < n - 2; i++) {
            
            // Optimization: If current number is > 0, remaining numbers are also > 0. 
            // Their sum can never equal 0.
            if (nums[i] > 0) {
                break;
            }
            
            // Skip duplicate values for the first element to prevent duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // 3. Two-pointer approach for the remaining two elements
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Found a unique valid triplet
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicate values for the left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicate values for the right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    // Move both pointers inward
                    left++;
                    right--;
                    
                } else if (sum < 0) {
                    // Sum is too small, move to a larger number
                    left++;
                } else {
                    // Sum is too large, move to a smaller number
                    right--;
                }
            }
        }
        
        return ans;
    }
}

