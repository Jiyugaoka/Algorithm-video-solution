class Solution {
    public boolean increasingTriplet1(int[] nums) {
        // 时间：O(N^2)，空间：O(1)
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            if (checkLeft(i, nums) && checkRight(i, nums)) return true;
        }
        return false;
    }

    private boolean checkLeft(int ind, int[] nums) {
        int i = ind - 1;
        while (i >= 0 && nums[i] >= nums[ind]) i--;
        if (i >= 0) return true;
        else return false;
    }
    private boolean checkRight(int ind, int[] nums) {
        int i = ind + 1, N = nums.length;
        while (i < N && nums[i] <= nums[ind]) i++;
        if (i < N) return true;
        else return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        // 时间：O(3N) = O(N)，空间：O(2N) = O(N)
        int N = nums.length;
        // left[i] 存储从[0, i]区间的最小值
        // right[i] 存储从[i, N - 1]区间的最大值
        int[] left = new int[N];
        int[] right = new int[N]; 
        left[0] = nums[0];
        right[N - 1] = nums[N - 1];
        for (int i = 1; i < N; i++) left[i] = Math.min(nums[i], left[i - 1]);
        for (int i = N - 2; i >= 0; i--) right[i] = Math.max(nums[i], right[i + 1]);
        for (int i = 1; i < N - 1; i++) {
            if (nums[i] > left[i - 1] && nums[i] < right[i + 1]) return true;
        }
        return false;
    }

    public boolean increasingTriplet(int[] nums) {
        // 时间：O(N)，空间：O(1)
        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num: nums) {
            if (small >= num) small = num;
            // 进入到mid的语句块意味着 small < num <= mid;
            else if (mid >= num) mid = num;
            // 进入到return语句块意味着 num > mid, num > samll
            // 要注意small和mid初始值都是int的最大值，能进入到return语句块，意味着，此刻small和mid
            // 都已经发生过赋值了，一旦赋值过，肯定满足 mid > small，因此直接返回true即可。
            else return true;
        } 
        return false;
    }
}