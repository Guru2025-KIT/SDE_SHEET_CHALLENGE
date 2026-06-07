package Day7.longestConsecutive;

import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length==0){
            return 0;
        }

    //Optimal Solution but array needs to be sorted.
        Arrays.sort(nums);
        int lastSmaller=Integer.MIN_VALUE;
        int longest=1;
        int count=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]-1==lastSmaller){
                count+=1;
                lastSmaller=nums[i];
            }else if(nums[i]!=lastSmaller){
                count=1;
                lastSmaller=nums[i];
            }
            longest=Math.max(longest,count);
        }
        return longest;
    }
}

public class longestConsecutiveOptimal {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println("Array: " + Arrays.toString(nums));

        int result = solution.longestConsecutive(nums);

        System.out.println("Longest Consecutive Sequence Length: " + result);
    }
}
