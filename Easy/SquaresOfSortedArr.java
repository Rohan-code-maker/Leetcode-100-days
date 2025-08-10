package Easy;

public class SquaresOfSortedArr {

    public static int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int ptr = ans.length - 1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int ss = nums[start] * nums[start]; //start square
            int es = nums[end] * nums[end]; //end square
            if (ss >= es) {
                ans[ptr] = ss;
                start++;
            } else {
                ans[ptr] = es;
                end--;
            }
            ptr--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { -7, -4, 0, 1, 2 };
        int[] result = sortedSquares(nums);
        for (int val : result) {
            System.out.println(val);
        }
    }
}