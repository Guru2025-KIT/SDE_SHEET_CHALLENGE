package Day7.longestConsecutive;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length==0)  return 0;
        //Better approach using set
        int longest=1;
        Set<Integer> set=new HashSet<>();

        //store each array to set to remove duplicates.
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        //Now searching for longestConsecutive.
        for(int it:set){
            if(!set.contains(it-1)){
                int count=1;
                int x=it;

                while(set.contains(x+1)){
                    count++;
                    x+=1;
                }
                longest=Math.max(longest,count);
            }
        }
        
        return longest;
        
    }
}

public class longestConsecutiveBetter {
     public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println("Array: " + Arrays.toString(nums));

        int result = solution.longestConsecutive(nums);

        System.out.println("Longest Consecutive Sequence Length: " + result);
    }
}
