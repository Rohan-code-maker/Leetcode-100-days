package Hard;

public class MedianOfSortedArr {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        double ans;
        //merging two arrays
        while (p1 < nums1.length || p2 < nums2.length) {
            int val1 = p1 < nums1.length ? nums1[p1] : Integer.MAX_VALUE;
            int val2 = p2 < nums2.length ? nums2[p2] : Integer.MAX_VALUE;

            if (val1 < val2) {
                arr[p3] = val1;
                p1++;
            } else {
                arr[p3] = val2;
                p2++;
            }
            p3++;
        }
        //checking odd or even length of array
        if (arr.length % 2 == 0) {
            ans = (double) (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
        } else {
            ans = (double) (arr[arr.length / 2]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num1 = { 1, 3, 5, 7 };
        int[] num2 = { 2, 4, 6, 7 };
        System.out.println(findMedianSortedArrays(num1, num2));
    }
}
