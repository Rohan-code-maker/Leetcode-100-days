class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointers for the last elements of nums1 and nums2
        int i = m - 1;
        int j = n - 1;
        // Pointer for the last position in nums1
        int k = m + n - 1;

        // Merge from the end to the beginning
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If there are remaining elements in nums2, copy them
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}