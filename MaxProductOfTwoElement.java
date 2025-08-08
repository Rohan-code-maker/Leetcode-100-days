public class MaxProductOfTwoElement {
    public static int maxProduct(int[] nums) {
        // Take example of race
        int max = -1; //1 <= nums[i]
        int s_max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                s_max = max;
                max = nums[i];
            } else if (s_max < nums[i]) {
                s_max = nums[i];
            }
        }
        int ans = (max - 1) * (s_max - 1);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 6, 1 };
        System.out.println(maxProduct(nums));
    }
}
