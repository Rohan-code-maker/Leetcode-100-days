class Solution {
    public int longestSubsequence(int[] nums) {

        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        // If XOR of the entire array is non-zero,
        // the entire array is the answer.
        if (xor != 0) {
            return nums.length;
        }

        // XOR of entire array is 0.
        // Remove one non-zero element.
        for (int num : nums) {
            if (num != 0) {
                return nums.length - 1;
            }
        }

        // All elements are zero.
        return 0;
    }
}