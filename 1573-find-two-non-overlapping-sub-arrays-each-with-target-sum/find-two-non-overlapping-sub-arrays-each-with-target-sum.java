class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = 1_000_000_000;

        // best[i] = minimum length of a valid subarray
        // ending at or before index i
        int[] best = new int[n];
        Arrays.fill(best, INF);

        int left = 0;
        int sum = 0;
        int ans = INF;
        int minLength = INF;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left++];
            }

            if (sum == target) {
                int len = right - left + 1;

                // Check for a previous non-overlapping subarray
                if (left > 0 && best[left - 1] != INF) {
                    ans = Math.min(ans, len + best[left - 1]);
                }

                minLength = Math.min(minLength, len);
            }

            best[right] = minLength;
        }

        return ans == INF ? -1 : ans;
    }
}