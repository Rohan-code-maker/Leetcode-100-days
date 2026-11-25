
import java.util.*;

class Solution {

    static final long MOD1 = 1_000_000_007L;
    static final long MOD2 = 1_000_000_009L;
    static final long BASE = 233;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        long[] h1 = new long[n + 1];
        long[] h2 = new long[n + 1];
        long[] p1 = new long[n + 1];
        long[] p2 = new long[n + 1];

        p1[0] = 1;
        p2[0] = 1;

        // Precompute prefix hashes and powers
        for (int i = 0; i < n; i++) {
            h1[i + 1] = (h1[i] * BASE + nums[i]) % MOD1;
            h2[i + 1] = (h2[i] * BASE + nums[i]) % MOD2;

            p1[i + 1] = (p1[i] * BASE) % MOD1;
            p2[i + 1] = (p2[i] * BASE) % MOD2;
        }

        int left = 1;
        int right = n;
        int ans = n;

        // Binary search for minimum length
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (hasUnique(nums, mid, h1, h2, p1, p2)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean hasUnique(
        int[] nums, int len,
        long[] h1, long[] h2,
        long[] p1, long[] p2
    ) {
        Map<Long, Integer> map = new HashMap<>();

        int n = nums.length;

        // Calculate hash for every subarray of length len
        for (int i = 0; i + len <= n; i++) {

            long hash1 = (h1[i + len]
                    - h1[i] * p1[len] % MOD1 + MOD1) % MOD1;

            long hash2 = (h2[i + len]
                    - h2[i] * p2[len] % MOD2 + MOD2) % MOD2;

            // Combine both hashes
            long key = (hash1 << 32) | hash2;

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // Check whether any subarray occurs exactly once
        for (int count : map.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}
