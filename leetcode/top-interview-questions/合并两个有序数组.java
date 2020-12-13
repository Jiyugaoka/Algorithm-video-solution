class Solution {
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m, j = 0; i < m + n; i++, j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        // while (i >= 0) {
        //     nums1[k] = nums1[i];
        //     i--;
        //     k--;
        // } 此处可以忽略，因为是要求把nums2合并到nums1中，因此只需处理nums2即可。
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}