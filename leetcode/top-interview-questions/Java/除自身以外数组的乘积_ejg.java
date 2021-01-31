class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        // res[i]表示i右边的所有元素的乘积
        // 可以看作动态规划，实则为后缀和
        res[N - 1] = 1;
        int temp = 1;
        for (int i = N - 2; i >= 0; i--) {
            res[i] = nums[i + 1] * res[i + 1];      
        }
        for (int i = 0; i < N; i++) {
            res[i] = temp * res[i];
            temp *= nums[i];
        }
        return res;
    }
}