package Daily_DSA;

import java.util.HashSet;
import java.util.Set;

public class NumberOfUniqueXORUsingSet{

    // Calculates the unique XOR triplets count
    public int uniqueXorTriplets(int[] nums) {
        Set<Integer> pairs = new HashSet<>();
        Set<Integer> answer = new HashSet<>();
        int n = nums.length;

        // Step 1: Collect all unique XOR values from distinct pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // Use i + 1 to check distinct indices
                pairs.add(nums[i] ^ nums[j]);
            }
        }

        // Step 2: Combine pairs with a third element to find triplet XORs
        for (int pair : pairs) {
            for (int num : nums) {
                answer.add(pair ^ num);
            }
        }

        return answer.size();
    }

    // Main method to run and test within VS Code
    public static void main(String[] args) {
        NumberOfUniqueXORUsingSet solver = new NumberOfUniqueXORUsingSet();

        // Sample Test Case
        int[] nums = {1, 3, 5, 8};
        
        System.out.println("Input Array: [1, 3, 5, 8]");
        int result = solver.uniqueXorTriplets(nums);
        System.out.println("Number of unique XOR triplet values: " + result);
    }
}

