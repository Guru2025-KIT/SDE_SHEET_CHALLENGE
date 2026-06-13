package Day13.ThreeSum;

import java.util.*;

// This is your original solution class
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // TC = O(N^3 * log(no. of unique triplets))
        // SC = O(2 * no. of the unique triplets)

        // Store unique triplets
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // Store sorted triplet to avoid duplicates
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(temp);
                        st.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(st);
    }
}

// This is the runner class with the main method to print the output
public class BruteForce {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: Standard case with mixed numbers
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test 1 Result: " + solution.threeSum(nums1));
        // Expected Output: [[-1, -1, 2], [-1, 0, 1]] (order may vary)

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
