package Easy;

public class FindMissingNumber {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int totalSum = (n * (n + 1)) / 2;
        for (int i = 0; i < n; i++) {
             sum = sum + nums[i];
        }
        int ans = totalSum - sum;
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {3,1,0,2,5};
        System.out.println(missingNumber(arr));
    }
}
