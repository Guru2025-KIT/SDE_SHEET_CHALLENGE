package Day14.removeDuplicatesFromSortedArray;

class Solution {
    public int removeDuplicates(int[] nums) {
     
        //TC=O(n)   SC=O(1)
        if(nums.length==0)  return 0;
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i]=nums[j];
            }
            
        }
        return i+1;
        
    }
}

public class Optimal {
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

