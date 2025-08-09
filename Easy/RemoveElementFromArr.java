package Easy;

public class RemoveElementFromArr {
    public static int removeElement(int[] nums, int val) {
        int count= 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,3,4,5};
        System.out.println(removeElement(arr, 3));
    }
}
