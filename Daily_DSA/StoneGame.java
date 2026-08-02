package Daily_DSA;
import java.util.Arrays;

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        // Game theory logic: the first player always has a winning strategy when n is even
        if (n % 2 == 0) {
            return true;
        }
        
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = piles[i];
        }
        
        for (int diff = 1; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                dp[i] = Math.max(piles[i] - dp[i + 1], piles[j] - dp[i]);
            }
        }
        return dp[0] >= 0;
    }

    // Main method to run the program inside VS Code
    public static void main(String[] args) {
        StoneGame game = new StoneGame();
        
        // Test case 1
        int[] piles1 = {5, 3, 4, 5};
        System.out.println("Test Case 1 - Input: " + Arrays.toString(piles1));
        System.out.println("Output: " + game.stoneGame(piles1)); // Expected: true
        
        // Test case 2
        int[] piles2 = {9,2, 3};
        System.out.println("\nTest Case 2 - Input: " + Arrays.toString(piles2));
        System.out.println("Output: " + game.stoneGame(piles2)); // Expected: true
    }
}
