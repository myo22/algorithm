class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int left = m - 1;
        int right = n - 1;
        while (right >= 0 && left >= 0) {
            if (nums1[left] > nums2[right]) {
                nums1[k--] = nums1[left--];
            } else {
                nums1[k--] = nums2[right--];
            }
        }
        
        while (right >= 0) {
            nums1[k--] = nums2[right--];
        }
    }
}
