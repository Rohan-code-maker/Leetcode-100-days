class Solution {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;

        long[] dp = new long[26];
        long total = 0;

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';

            // New subsequences ending with ch
            long add = (total - dp[idx] + 1 + MOD) % MOD;

            total = (total + add) % MOD;
            dp[idx] = (dp[idx] + add) % MOD;
        }

        return (int) total;
    }
}