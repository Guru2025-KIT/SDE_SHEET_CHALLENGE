package Daily_DSA;
public class maximumProductOf2ElementsInArray {
    public static void main(String[] args) {
        SolutionClass solution = new SolutionClass();
        
        // Test case from your example
        int[] nums = {3, 4, 5, 2};
        
        int result = solution.maxProduct(nums);
        
        // Expected Output: 12
        System.out.println("Output: " + result); 
    }
}

class SolutionClass { 
    public int maxProduct(int[] nums) { 
        // We track the highest and second-highest values directly without indices
        int largest = 0; 
        int smaller = 0; 
        
        for (int i = 0; i < nums.length; i++) { 
            if (nums[i] > largest) { 
                // Move old largest to smaller before updating largest
                smaller = largest; 
                largest = nums[i]; 
            } else if (nums[i] > smaller) { 
                smaller = nums[i]; 
            } 
        } 
        return (largest - 1) * (smaller - 1); 
    } 
}
