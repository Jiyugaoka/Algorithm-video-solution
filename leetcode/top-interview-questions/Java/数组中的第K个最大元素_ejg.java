class Solution {
    public int findKthLargest(int[] nums, int k) {
        int N = nums.length;
        // 大顶堆
        PriorityQueue<Integer> pr = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // 使用Lambda表达式的写法，简洁但是不太容易懂。
        // PriorityQueue<Integer> pr = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < N; i++) {
            if (pr.size() <= N - k) {
                pr.offer(nums[i]);
            } else {
                if (nums[i] < pr.peek()) {
                    pr.poll();
                    pr.offer(nums[i]);
                }
            }
        }
        return pr.peek();        
    }

    public int findKthLargest1(int[] nums, int k) {
        int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }
}