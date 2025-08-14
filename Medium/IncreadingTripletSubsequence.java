package Medium;

public class IncreadingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int third = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int ele = nums[i];
            if(first >= ele){
                first = ele;
            }else if(second >= ele){
                second = ele;
            }else{
                third = ele;
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {5,4,3,6,7};
        System.out.println(increasingTriplet(arr));
    }
}
