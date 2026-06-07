package Day7;

/* 
-------- Algorithm -------------
1.Create a HashMap to store (number, index).
2.Traverse the array.
3.For each element:
    Find the complement (target - current).
    If complement exists in map, return indices.
    Otherwise store current element in map.
4.Return empty array if no pair exists.

Complexity Analysis
Time Complexity	    O(n)    Note: HashMap operations (put, get, containsKey) take O(1) on average
Space Complexity	O(n)
*/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        // Time Complexity: O(n)
        // Space Complexity: O(n)
        for (int i = 0; i < nums.length; i++) {

            int current = nums[i];
            int required = target - current;

            //Search whether it exists in map
            if (map.containsKey(required)) {
                return new int[] { map.get(required), i };
            }
            //If not add that element into map
            map.put(current, i);
        }

        return new int[] {};
    }
}

public class TwoSum_Optimal {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = solution.twoSum(nums, target);

        System.out.println("Indices: " + Arrays.toString(result));
    }
}
