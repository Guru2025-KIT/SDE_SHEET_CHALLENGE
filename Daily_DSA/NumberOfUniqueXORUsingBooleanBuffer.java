package Daily_DSA;

public class NumberOfUniqueXORUsingBooleanBuffer {

    public int uniqueXorTriplets(int[] nums) {
        // Space sized to 2048 because max value is 1500 (next power of 2 is 2048)
        boolean[] s1 = new boolean[2048]; // Tracks 1-element selection combinations
        boolean[] s2 = new boolean[2048]; // Tracks 2-element selection combinations
        boolean[] s3 = new boolean[2048]; // Tracks 3-element selection combinations

        for (int num : nums) {
            // Snapshot copies to prevent immediate feedback loops within the same element
            boolean[] next_s3 = s3.clone();
            boolean[] next_s2 = s2.clone();
            boolean[] next_s1 = s1.clone();

            // --- Update 3-Element Combos (s3) ---
            // Branch A: 2 elements from previous indices + 1 from current
            for (int i = 0; i < 2048; i++) {
                if (s2[i]) {
                    next_s3[i ^ num] = true;
                }
            }
            // Branch B: 1 element from previous indices + 2 from current (num ^ num = 0)
            for (int i = 0; i < 2048; i++) {
                if (s1[i]) {
                    next_s3[i] = true; // i ^ 0 = i
                }
            }
            // Branch C: 0 elements from previous indices + 3 from current (num ^ num ^ num = num)
            next_s3[num] = true;

            // --- Update 2-Element Combos (s2) ---
            // Branch A: 1 element from previous indices + 1 from current
            for (int i = 0; i < 2048; i++) {
                if (s1[i]) {
                    next_s2[i ^ num] = true;
                }
            }
            // Branch B: 0 elements from previous indices + 2 from current (num ^ num = 0)
            next_s2[0] = true;

            // --- Update 1-Element Combos (s1) ---
            // Branch A: 0 elements from previous indices + 1 from current
            next_s1[num] = true;

            // Roll forward state updates
            s3 = next_s3;
            s2 = next_s2;
            s1 = next_s1;
        }

        // Count all unique valid 3-element XOR values recorded
        int uniqueCount = 0;
        for (int i = 0; i < 2048; i++) {
            if (s3[i]) {
                uniqueCount++;
            }
        }
        return uniqueCount;
    }

    // Main method to run and test within VS Code
    public static void main(String[] args) {
        NumberOfUniqueXORUsingBooleanBuffer solver = new NumberOfUniqueXORUsingBooleanBuffer();

        // Sample Test Case
        int[] nums = {1, 3, 5, 8};
        
        System.out.println("Input Array: [1, 3, 5, 8]");
        int result = solver.uniqueXorTriplets(nums);
        System.out.println("Number of unique XOR triplet values: " + result);
    }
}
