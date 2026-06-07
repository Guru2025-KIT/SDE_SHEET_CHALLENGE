package Day7;

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] result=new int[2];
        //Time Complexity O(n2)
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length && i!=j;j++){
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
        
    }
}
public class TwoSum_BruteForce {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = {1, 7, 11, 2};
        int target = 9;

        int[] result = solution.twoSum(nums, target);

        System.out.println("Indices: " + Arrays.toString(result));
    }
}
