class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];

        // dp[i] = true means the current player
        // can force a win when there are i stones.

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j * j <= i; j++) {

                // If we can make a move that leaves
                // the opponent in a losing state,
                // current player wins.
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}