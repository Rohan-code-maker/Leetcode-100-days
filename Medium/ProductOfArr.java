package Medium;

public class ProductOfArr {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];
        int prod = 1;
        for (int i = n - 1; i >= 0; i--) {
            prod = prod * nums[i];
            right[i] = prod;
        }

        int[] ans = new int[n];
        int left = 1;
        for (int i = 0; i < n - 1; i++) {
            int val = left * right[i + 1];
            ans[i] = val;
            left *= nums[i];
        }
        ans[n - 1] = left;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int[] ans = productExceptSelf(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
