package Day7;

import java.util.Arrays;
/*
-------- Prerequisite -------------
This approach works only when the array is sorted.
If the array is unsorted, it must be sorted first.

----------- Algorithm ---------
1.Initialize two pointers:
    left = 0
    right = n - 1
2.While left < right:
    Calculate the sum.
    If sum equals target → return indices.
    If sum is greater than target → decrement right.
    If sum is smaller than target → increment left.
3.If no pair is found, return [-1, -1].
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {

        int min = 0;
        int max = nums.length - 1;
        Arrays.sort(nums);

        while (min < max) {

            int sum = nums[min] + nums[max];

            if (sum == target) {
                return new int[] {min, max};
            } else if (sum > target) {
                max--;
            } else {
                min++;
            }
        }

        return new int[] {-1, -1};
    }
}

public class TwoSum_TwoPointers {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = {2, 7, 11, 15}; // Sorted Array
        int target = 9;

        int[] result = solution.twoSum(nums, target);

        System.out.println("Indices: " + Arrays.toString(result));
    }
}
