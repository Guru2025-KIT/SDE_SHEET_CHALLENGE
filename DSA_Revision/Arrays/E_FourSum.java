package DSA_Revision.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// VS Code compatible class named exactly after the problem
public class E_FourSum { 
    public List<List<Integer>> foursum(int[] nums, int target) { 
        List<List<Integer>> result = new ArrayList<>(); 
        
        if (nums.length == 0 || nums.length < 4) { 
            return result; 
        } 
        
        Arrays.sort(nums); 
        int n = nums.length; 
        
        // Fix the First Element 
        for (int i = 0; i < n - 3; i++) { 
            // Skip duplicates for first number 
            if (i > 0 && nums[i] == nums[i - 1]) continue; 
            
            // Fix Second Number 
            for (int j = i + 1; j < n - 2; j++) { 
                // Skip Duplicates for second number 
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; 
                
                // Set up 2 pointer approach on remaining 2 elements 
                int left = j + 1; 
                int right = n - 1; 
                
                while (left < right) { 
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right]; 
                    
                    if (sum == target) { 
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right])); 
                        
                        // Skip duplicates for 3rd element 
                        while (left < right && nums[left] == nums[left + 1]) left++; 
                        // Skip duplicates for 4th Element 
                        while (left < right && nums[right] == nums[right - 1]) right--; 
                        
                        right--; 
                        left++; 
                    } else if (sum > target) { 
                        right--; 
                    } else { 
                        left++; 
                    } 
                } 
            } 
        } 
        return result; 
    } 

    // Optional main method for quick local execution/testing in VS Code
    public static void main(String[] args) {
        E_FourSum solver = new E_FourSum();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(solver.foursum(nums, target));
    }
}
