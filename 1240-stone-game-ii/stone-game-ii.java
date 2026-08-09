class Solution {
    int[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        // Suffix sum
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return solve(0, 1);
    }

    private int solve(int i, int M) {
        if (i >= n) {
            return 0;
        }

        if (dp[i][M] != 0) {
            return dp[i][M];
        }

        // Can take all remaining piles
        if (2 * M >= n - i) {
            return dp[i][M] = suffix[i];
        }

        int best = 0;

        for (int X = 1; X <= 2 * M; X++) {
            int opponent = solve(i + X, Math.max(M, X));

            // Current player gets all remaining stones
            // minus what opponent can get.
            int current = suffix[i] - opponent;

            best = Math.max(best, current);
        }

        return dp[i][M] = best;
    }
}