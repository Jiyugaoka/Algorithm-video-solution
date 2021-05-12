class Solution {
public:
    int findPeakElement1(vector<int>& nums) {
        int N = nums.size();
        if (N == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[N - 1] > nums[N - 2]) return N - 1;
        for (int i = 1; i <= N - 2; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;           
        }
        return -1;
    }

    int findPeakElement2(vector<int>& nums) {
        int N = nums.size();
        for (int i = 0; i < N - 1; i++) {
            // 如果检索到i,则说明nums[i] < nums[i],所以此刻只需比较nums[i]和nums[i + 1即可。
            if (nums[i] > nums[i + 1]) return i;
        }
        return N - 1;
    }

    int findPeakElement(vector<int>& nums) {
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                // 可能是正好是一个峰值，所以不能right = mid - 1
                right = mid;
            }
        }
        return left;
    }
};