class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> points = new ArrayList<>();
        //求出左上角和右上角坐标, 左上角坐标的 y 存负数
        for (int[] b : buildings) {
            points.add(Arrays.asList(b[0], -b[2]));
            points.add(Arrays.asList(b[1], b[2]));
        }
        //将所有坐标排序
        points.sort(
            (O1, O2) -> {
                int x1 = O1.get(0), y1 = O1.get(1);
                int x2 = O2.get(0), y2 = O2.get(1);
                if (x1 != x2) return x1 - x2;
                else return y1 - y2;
            });
        //默认的优先队列是小顶堆，我们需要大顶堆，每次需要得到队列中最大的元素
        Queue<Integer> queue = new PriorityQueue<>((O1, O2) -> O2 - O1);
        queue.offer(0);
        int preMax = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> p : points) {
            int x = p.get(0), y = p.get(1);
            //左上角坐标
            if (y < 0) queue.offer(-y);
            //右上角坐标
            else queue.remove(y);
            int curMax = queue.peek();
            //最大值更新了, 将当前结果加入
            if (curMax != preMax) {
                res.add(Arrays.asList(x, curMax));
                preMax = curMax;
            }
        }
        return res;
    }
}