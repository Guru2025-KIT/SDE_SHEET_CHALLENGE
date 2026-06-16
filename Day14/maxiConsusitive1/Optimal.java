package Day14.maxiConsusitive1;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        //Time Complexity: O(N), since we scan the array once.
        //Space Complexity: O(1), as only constant extra variables are used.
        
        int count=0;
        int maxCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)  count++;
            if(nums[i]==0)  count=0;

            maxCount=Math.max(maxCount,count);
        }

        return maxCount;
        
    }
}

public class Optimal {
    public static void main(String[] args) {
        // Input array
        int[] nums = {1, 1, 0, 1, 1, 1};

        // Create Solution object
        Solution obj = new Solution();

        // Get answer
        int ans = obj.findMaxConsecutiveOnes(nums);

        // Print result
        System.out.println("The maximum consecutive 1's are " + ans);
    }
}
