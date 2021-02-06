class Solution {
    public int kthSmallest1(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> pr = new PriorityQueue<>();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (pr.size() <= n * n - k) {
                    pr.offer(matrix[i][j]);
                } else {
                    if (matrix[i][j] > pr.peek()) {
                        pr.poll();
                        pr.offer(matrix[i][j]);
                    } else {
                        break;
                    }
                }
            }
        }
        return pr.peek();
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        // 小顶堆内存储的内容：（值， 横坐标， 纵坐标）
        PriorityQueue<int[]> pr = new PriorityQueue<>((nums1, nums2) -> nums1[0] - nums2[0]);
        for (int i = 0; i < n; i++) {
            pr.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] nums = pr.poll();
            int val = nums[0], x = nums[1], y = nums[2];
            if (y + 1 < n) {
                pr.offer(new int[]{matrix[x][y + 1], x, y + 1});
            }
        }
        return pr.poll()[0];
    }
}