package Day7.longestConsecutive;

import java.util.Arrays;

class Solution {
    public static boolean LinearSearch(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return true;
            }
        }
        return false;
    }

    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int longest=1;
        for(int i=0;i<nums.length;i++){
            int x=nums[i];
            int count=1;
            while(LinearSearch(nums,x+1)){
                x+=1;
                count++;
            }
            longest=Math.max(longest,count);

        }
        return longest;
    }
}

public class BruteForce {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println("Array: " + Arrays.toString(nums));

        int result = solution.longestConsecutive(nums);

        System.out.println("Longest Consecutive Sequence Length: " + result);
    }
}
