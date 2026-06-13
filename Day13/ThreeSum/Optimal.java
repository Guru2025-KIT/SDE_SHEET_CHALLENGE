package Day13.ThreeSum;

import java.util.*;

// This is your updated O(N^2) solution class
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // TC=O(N2 * log(no. of unique triplets))
        // SC=O(2 * no. of the unique triplets)

        // Store unique triplets
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int third = -(nums[i] + nums[j]);

                if (hashSet.contains(third)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(temp);
                    ans.add(temp);
                }

                hashSet.add(nums[j]);
            }
        }

        return new ArrayList<>(ans);
    }
}

// This is the runner class with the main method to print the output
public class Optimal {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: Standard case with mixed numbers
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test 1 Result: " + solution.threeSum(nums1));
        // Expected Output: [[-1, 0, 1], [-1, -1, 2]]

        // Test 2: All zeros
        int[] nums2 = {0, 0, 0, 0};
        System.out.println("Test 2 Result: " + solution.threeSum(nums2));
        // Expected Output: [[0, 0, 0]]

        // Test 3: No valid triplets exist
        int[] nums3 = {1, 2, 3, 4};
        System.out.println("Test 3 Result: " + solution.threeSum(nums3));
        // Expected Output: []

        // Test 4: Less than three elements
        int[] nums4 = {0, 1};
        System.out.println("Test 4 Result: " + solution.threeSum(nums4));
        // Expected Output: []
    }
}

