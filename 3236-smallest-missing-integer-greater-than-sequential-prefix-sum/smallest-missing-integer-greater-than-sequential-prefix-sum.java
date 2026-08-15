import java.util.*;

class Solution {
    public int missingInteger(int[] nums) {

        // Find the sum of the longest sequential prefix
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Store all numbers in the array
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // Find the smallest integer >= sum
        // that is not present in the array
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}