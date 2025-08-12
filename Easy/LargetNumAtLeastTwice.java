package Easy;

public class LargetNumAtLeastTwice {
    public static int dominantIndex(int[] nums) {
        int max = -1;
        int sMax = -1;
        int maxIdx = 0;
        for(int i =0 ;i<nums.length;i++){
            if(max < nums[i]){
                sMax = max;
                max = nums[i];
                maxIdx = i;
            }else if(sMax < nums[i]){
                sMax = nums[i];
            }
        }
        if(sMax * 2 <= max){
            return maxIdx;
        }else{
            return -1;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,6,3};
        System.out.println(dominantIndex(arr));
    }

}
