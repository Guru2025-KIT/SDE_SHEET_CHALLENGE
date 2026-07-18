package Daily_DSA;
import java.util.Arrays;

// Your original Solution class
class Solution {
    private int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int findGCD(int[] nums) {
        int smallest = nums[0];
        int largest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (smallest > nums[i]) {
                smallest = nums[i];
            }
            if (largest < nums[i]) {
                largest = nums[i];
            }
        }
        return GCD(smallest, largest);
    }
}

// Wrapper Main class to execute the code
public class GCDArray1979 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case: Array containing various integers
        int[] nums = {2, 5, 6, 9, 10};

        // Execute the method
        int result = solution.findGCD(nums);

        // Print the results to the terminal
        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("Smallest Number: " + getMin(nums));
        System.out.println("Largest Number: " + getMax(nums));
        System.out.println("GCD of Smallest and Largest: " + result);
    }

    // Helper methods just to display min/max in the final print statements
    private static int getMin(int[] arr) {
        return Arrays.stream(arr).min().getAsInt();
    }
    private static int getMax(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }
}
