class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == nums.length) return ;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
        left = 0;
        right = k - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
        left = k;
        right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int ind1, int ind2) {
        int temp = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2] = temp;
    }

    public void rotate1(int[] nums, int k) {
        int N = nums.length;
        while (k > 0) {
            int temp = nums[N - 1];
            for (int i = N - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            k--;
        }
    }
}