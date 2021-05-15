class Solution {
/**
* 应用一个性质：如果count(nums, mid) <= mid则该数未重复, 进而使用二分法。
*/
public:
    int findDuplicate(vector<int>& nums) {
        // 此刻左右指针指的是可以取到的数
        int left = 1, right = nums.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 此刻判断条件指的是数组中比mid小的数的个数
            if (count(nums, mid) <= mid) {// 表明当前数未重复
                left = mid + 1;
            } else {
                right = mid; // 当前mid可能是缺失的，也可能不是，继续向左侧压缩搜索区间。
            }
        }
        return left;
    }

    // 查找数组中比mid小的数的个数
    int count(vector<int>& nums, int mid) {
        int count = 0, N = nums.size();
        for (int i = 0; i < N; i++) {
            if(nums[i] <= mid) count++;
        }
        return count;
    }
};