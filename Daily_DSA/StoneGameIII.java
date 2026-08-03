package Daily_DSA;

public class StoneGameIII {
    public static void main(String[] args) {
        StoneGameIII game = new StoneGameIII();

        // Test Case 1: [1, 2, 3, 7] -> Expected output: "Bob"
        int[] stones1 = {1, 2, 3, 7};
        System.out.println("Test Case 1 Winner: " + game.stoneGameIII(stones1));

        // Test Case 2: [1, 2, 3, -9] -> Expected output: "Alice"
        int[] stones2 = {1, 2, 3, -9};
        System.out.println("Test Case 2 Winner: " + game.stoneGameIII(stones2));

        // Test Case 3: [1, 2, 3, 6] -> Expected output: "Tie"
        int[] stones3 = {1, 2, 3, 6};
        System.out.println("Test Case 3 Winner: " + game.stoneGameIII(stones3));
    }

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        
        // 1. DP TABLE FOR RELATIVE SCORING
        // dp[i] stores the maximum relative score advantage a player can get starting from index i.
        // Relative score means: (Current Player's Total) - (Opponent's Total).
        // Size is n + 1 to handle the boundary case when all stones are taken.
        int[] dp = new int[n + 1];
        
        // BASE CASE: If no stones are left, the relative score advantage is 0.
        dp[n] = 0;
        
        // 2. BOTTOM-UP DYNAMIC PROGRAMMING (WORKING BACKWARDS)
        // Since players take stones from the front, we calculate optimal choices 
        // from the end of the array back to the start.
        for (int i = n - 1; i >= 0; i--) {
            int taken = 0;
            int maxScore = Integer.MIN_VALUE; // Track the best outcome among the 3 choices
            
            // 3. EXPLORE ALL 3 VALID CHOICES (Take 1, 2, or 3 stones)
            // k represents the offset (0 = 1 stone, 1 = 2 stones, 2 = 3 stones)
            // 'i + k < n' ensures we don't pick beyond the available stones.
            for (int k = 0; k < 3 && i + k < n; k++) {
                // Accumulate the total value of stones picked in this turn
                taken += stoneValue[i + k]; 
                
                // GAME THEORY STRATEGY:
                // Current net score = (Stones I take now) - (Opponent's best future advantage).
                // We subtract dp[i + k + 1] because the opponent plays optimally next turn.
                int currentScore = taken - dp[i + k + 1];
                
                // Maximize our advantage by choosing the best possible turn outcome
                maxScore = Math.max(maxScore, currentScore);
            }
            
            // Store the best relative score possible from index i onward
            dp[i] = maxScore;
        }
        
        // 4. FINAL RESULTS EVALUATION
        // dp[0] represents Alice's maximum net score advantage at the start of the game.
        if (dp[0] > 0) return "Alice"; // Alice scores more than Bob
        if (dp[0] < 0) return "Bob";   // Bob scores more than Alice
        return "Tie";                  // Both players end up with the exact same score
    }
}
