class Solution {
    Map<Integer, Integer> delayed = new HashMap<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int left = 0, right = 0;
        int[] res = new int[N - k + 1];
        PriorityQueue<Integer> pr = new PriorityQueue<>((o1, o2) -> o2 - o1);
        while (right < N) {
            if (pr.size() < k) {
                pr.offer(nums[right]);
                right++;
            } else {
                // 细节要注意：必须先取到当前窗口最大值，然后才能加入nums[right]。
                // 否则nums[right]可能会影响当前窗口的最大值的计算。
                res[right - k] = pr.peek();
                // 先删除nums[left]
                delayed.put(nums[left], delayed.getOrDefault(nums[left], 0) + 1);
                if (nums[left] == pr.peek()) {
                    this.prune(pr);
                }
                // 再加入nums[right]
                pr.offer(nums[right]);
                left++;
                right++;
            }
        }
        // 由于最后加入的那个nums[right]对应的窗口内的最大值并没有计算，所以要在此处补上。
        res[N -k] = pr.peek();
        return res;
    }

    // 不断地弹出 heap 的堆顶元素，并且更新哈希表。
    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            // 循环执行的次数等于delayed.get(num)，也就是说delayed中该num数字出现了几次。
            // 那么就表明该数字要被弹出几次，while循环也就会执行几次。
            if (delayed.containsKey(num)) {
                delayed.put(num, delayed.get(num) - 1);
                if (delayed.get(num) == 0) {
                    delayed.remove(num);
                }
                heap.poll();
            } else {
                break;
            }
        }
    }
}