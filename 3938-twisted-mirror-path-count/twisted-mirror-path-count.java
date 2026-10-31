class Solution {
    public int uniquePaths(int[][] grid) {
        int MOD = 1_000_000_007;
        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j][0] = ways entering cell from left (moving right)
        // dp[i][j][1] = ways entering cell from above (moving down)
        long[][][] dp = new long[m][n][2];

        dp[0][0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {

                    // Mirror: incoming from left -> move down
                    if (dp[i][j][0] > 0 && i + 1 < m) {
                        dp[i + 1][j][1] =
                            (dp[i + 1][j][1] + dp[i][j][0]) % MOD;
                    }

                    // Mirror: incoming from above -> move right
                    if (dp[i][j][1] > 0 && j + 1 < n) {
                        dp[i][j + 1][0] =
                            (dp[i][j + 1][0] + dp[i][j][1]) % MOD;
                    }

                } else {

                    long ways = (dp[i][j][0] + dp[i][j][1]) % MOD;

                    // Move right
                    if (j + 1 < n) {
                        dp[i][j + 1][0] =
                            (dp[i][j + 1][0] + ways) % MOD;
                    }

                    // Move down
                    if (i + 1 < m) {
                        dp[i + 1][j][1] =
                            (dp[i + 1][j][1] + ways) % MOD;
                    }
                }
            }
        }

        return (int) (
            (dp[m - 1][n - 1][0] +
             dp[m - 1][n - 1][1]) % MOD
        );
    }
}