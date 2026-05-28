class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mlen = m - 1, nlen = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (nlen < 0 || (mlen >= 0 && nums1[mlen] > nums2[nlen])) {
                nums1[i] = nums1[mlen--];
            } else {
                nums1[i] = nums2[nlen--];
            }
        }
    }
}
