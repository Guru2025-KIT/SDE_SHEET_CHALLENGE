package Random_Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        
        // Example test case
        int[] nums = {-1, 0, 1, 2, -1, -4};
        
        List<List<Integer>> result = solution.threeSum(nums);
        
        // Print the output
        System.out.println("Unique triplets that sum to zero:");
        System.out.println(result);
    }
}

class Solution2 { 
    public List<List<Integer>> threeSum(int[] nums) { 
        Set<List<Integer>> ans = new HashSet<>(); 
        
        for (int i = 0; i < nums.length; i++) { 
            Set<Integer> hashSet = new HashSet<>(); 
            
            for (int j = i + 1; j < nums.length; j++) { 
                int third = -(nums[i] + nums[j]); 
                
                if (hashSet.contains(third)) { 
                    // Fixed: Wrapped in new ArrayList<> to make it mutable for Collections.sort
                    List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], third)); 
                    Collections.sort(temp); 
                    ans.add(temp); 
                } 
                hashSet.add(nums[j]); 
            } 
        } 
        return new ArrayList<>(ans); 
    } 
}
