package Daily_DSA;
public class MinimumNumberOfPushesToTypeWordI {

    public int minimumPushes(String word) {
        /**
         * 1. Count total characters: Determine the length of the string 'n'.
         * 
         * 2. Map tier 1 (First 8 keys): Assign 1 push per character for the 
         *    first 8 characters.
         * 
         * 3. Map tier 2 and 3 (Next 16 keys): Assign 2 pushes per character 
         *    for characters 9-16, and 3 pushes for characters 17-24.
         * 
         * 4. Map tier 4 (Remaining keys): Assign 4 pushes per character for 
         *    any remaining letters beyond the first 24.
         */
        int n = word.length();

        if (n <= 8) {
            // here 8 because only 8 keys are available to map(2-9)
            return n * 1;
        } else if (n <= 16) {
            return 8 + (n - 8) * 2;
        } else if (n <= 24) {
            return 8 + 16 + (n - 16) * 3;
        } else {
            return 8 + 16 + 24 + (n - 24) * 4;
        }
    }

    // Main method to run and test the solution in VS Code
    public static void main(String[] args) {
        MinimumNumberOfPushesToTypeWordI solver = new MinimumNumberOfPushesToTypeWordI();

        // Test Case 1
        String testWord1 = "abcde";
        System.out.println("Minimum pushes for '" + testWord1 + "': " + solver.minimumPushes(testWord1));

        // Test Case 2
        String testWord2 = "xycdefghij";
        System.out.println("Minimum pushes for '" + testWord2 + "': " + solver.minimumPushes(testWord2));
    }
}
