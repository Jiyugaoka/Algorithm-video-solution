class Solution {
    public int maxProduct(int[] nums) {
        int N = nums.length;
        if (N == 1) return nums[0];
		// daA[i]:以nums[i]结尾的子数组的最大正乘积
		// daB[i]:以nums[i]结尾的子数组的最小负乘积
        int[] dpA = new int[N + 1];
        int[] dpB = new int[N + 1];
        // 初始化工作
        if (nums[0] > 0) {
            dpA[1] = nums[0];
        } 
        if (nums[0] < 0) {
            dpB[1] = nums[0];
        }
		// 结果初始化为dpA[1]
        int res = dpA[1];
        for (int i = 2; i <= N; i++) {
			// 这里不建议把nums[i - 1] == 0分支，优化到下边的两个分支里，这样可以保持代码的逻辑清晰
            if (nums[i - 1] == 0) continue;
            else if (nums[i - 1] > 0) {
				// 正数赋值情况，两者择最大者赋值给dpA[i]
                dpA[i] = Math.max(nums[i - 1], nums[i - 1] * dpA[i - 1]);
				// 负数 = 整数 * 负数
                dpB[i] = nums[i - 1] * dpB[i - 1];
            } else {
				// 整数 = 负数 * 负数
                dpA[i] = nums[i - 1] * dpB[i - 1];
				// 负数赋值情况，两者择最小者赋值给dpB[i]
                dpB[i] = Math.min(nums[i - 1], nums[i - 1] * dpA[i - 1]);
            }
			// 结果可能出现在任意位置，所以要取他们的最大值
            res = Math.max(res, dpA[i]);
        }
        return res;
    }
}