class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();

        int[] prefix = new int[n + 1];

        // Calculate prefix sums.
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        int ans = Integer.MAX_VALUE;

        // Check all allowed subarray lengths.
        for (int len = l; len <= r; len++) {

            for (int i = 0; i + len <= n; i++) {

                int sum = prefix[i + len] - prefix[i];

                // We need only positive sums.
                if (sum > 0) {
                    ans = Math.min(ans, sum);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}