package Medium;

public class TwoSum2 {
    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                ans[0] = start + 1;
                ans[1] = end + 1;
                return ans;
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 4, 6, 8 };
        int target = 14;
        int[] val = twoSum(nums, target);
        for (int i = 0; i < val.length; i++) {
            System.out.println(val[i]);
        }
    }
}
