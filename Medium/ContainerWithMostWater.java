package Medium;
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length -1;
        int maxCap = 0;
        while(start < end){
            int minHeight = Math.min(height[start], height[end]);
            int width = end - start;
            int currCap = minHeight * width;
            maxCap = Math.max(maxCap, currCap);
            if(height[start] < height[end]){
                start++;
            }else{
                end--;
            }
        }
        return maxCap;
    }
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
