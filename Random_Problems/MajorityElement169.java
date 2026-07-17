package Random_Problems;

public class MajorityElement169 {

    public int MajorityElement(int[] nums) {
        // Boyer-Moore Voting Algorithm
        // TC = O(n)
        // SC = O(1)
        int candidate = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            // Step 1: If count drops to 0, pick the current number as the new candidate
            if (count == 0) {
                candidate = nums[i];
            }

            // Step 2: If the current number matches the candidate, increment count.
            // Otherwise, decrement count (cancelling out a pair).
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    // Main method to run and test the code directly in VS Code
    public static void main(String[] args) {
        MajorityElement169 solver = new MajorityElement169();

        // Test Case 1
        int[] nums1 = {3, 2, 3};
        System.out.println("Test 1 Input: [3, 2, 3]");
        System.out.println("Expected: 3 | Output: " + solver.MajorityElement(nums1));
        System.out.println();

        // Test Case 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Test 2 Input: [2, 2, 1, 1, 1, 2, 2]");
        System.out.println("Expected: 2 | Output: " + solver.MajorityElement(nums2));
    }
}
