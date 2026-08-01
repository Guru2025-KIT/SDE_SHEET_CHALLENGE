package Daily_DSA;
public class PredictTheWinner {
    public static void main(String[] args) {
        PredictTheWinner game = new PredictTheWinner();

        // Test Case 1: [1, 5, 2] -> Expected output: false
        int[] nums1 = {1, 5, 2};
        System.out.println("Test Case 1 [1, 5, 2] - Can Player 1 win? " + game.predictTheWinner(nums1));

        // Test Case 2: [1, 5, 233, 7] -> Expected output: true (Even length)
        int[] nums2 = {1, 5, 233, 7};
        System.out.println("Test Case 2 [1, 5, 233, 7] - Can Player 1 win? " + game.predictTheWinner(nums2));
    }

    public boolean predictTheWinner(int[] nums) { 
        int n = nums.length; 
        
        // Shortcut: For even length array, Player 1 can always win
        if (n % 2 == 0) { 
            return true; 
        } 
        
        // Create DP array to track relative score advantages
        int[] dp = new int[n]; 
        for (int i = 0; i < n; i++) { 
            dp[i] = nums[i]; 
        } 
        
        // Sliding window of increasing sizes
        for (int diff = 1; diff < n; diff++) { 
            for (int i = 0; i < n - diff; i++) { 
                int j = i + diff; 
                dp[i] = Math.max(nums[i] - dp[i + 1], nums[j] - dp[i]); 
            } 
        } 
        
        // If Player 1's final maximum net score is 0 or positive, they win/tie
        return dp[0] >= 0; 
    } 
}
