class Solution {

    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;

        // dp[i] = maximum score difference
        // the current player can achieve
        // from index i to the current end.
        int[] dp = new int[n];

        // Initially, with one element,
        // the player takes that element.
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }

        // Consider subarrays of increasing length
        for (int len = 2; len <= n; len++) {

            for (int i = 0; i + len <= n; i++) {

                int j = i + len - 1;

                // Take left element:
                // nums[i] - opponent's best difference
                //
                // Take right element:
                // nums[j] - opponent's best difference
                dp[i] = Math.max(
                    nums[i] - dp[i + 1],
                    nums[j] - dp[i]
                );
            }
        }

        // If score difference >= 0,
        // Player 1 can win or tie.
        return dp[0] >= 0;
    }
}