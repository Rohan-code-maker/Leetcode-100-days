package Easy;
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1; j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int target = 7;
        int[] result = twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
