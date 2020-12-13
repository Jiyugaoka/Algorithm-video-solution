class Solution {
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val > nums.length / 2) {
                res = key;
                break;
            }
        }
        return res;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement3(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int l, int r) {
        // 在区间[l, r]内寻找众数，并返回结果。
        if (l == r) return nums[l];
        int mid = l + (r - l) / 2;
        // int mid = (l + r) / 2;
        int left = helper(nums, l, mid);
        int right = helper(nums, mid + 1, r);
        if (left == right) return left;
        int leftCount = count(nums, left, l, r);
        int rightCount = count(nums, right, l, r);
        return leftCount > rightCount? left: right;
    }

    private int count(int[] nums, int temp, int l, int r) {
        int res = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] == temp) res++;
        }
        return res;
    }

    public int majorityElement(int[] nums) {
        int pre = nums[0], count = 0;
        for (int num: nums) {
            if (num == pre) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    pre = num;
                    count = 1;
                }
            }
        }
        return pre;
    }
}