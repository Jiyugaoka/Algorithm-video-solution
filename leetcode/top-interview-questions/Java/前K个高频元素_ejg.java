class Solution {
    /**
    * 如果不使用堆这种自带排序功能的数据结构，那么我们就需要自定义个数据结构，用于存储两个元素（num, count）
    * 然后根据结构体中每个元素的count数据进行排序
    * 比如, C中的结构体
    * struct Node{
    *    int num;  // 哪个数字
    *    int count;  // 该数字出现的次数
    *    } node[n];
    * C++中的pair
    *    pair<int, int> node;
    * 然后自定义一个排序函数
    * int cmp(pair<int, int> a, pair<int, int> b){
    *    return b.second - a.second;
    * } 
    * Java中则使用内部类, 然后使用List<>的内部方法sort同样是自定义排序规则.
    */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 时间复杂度：O(n)
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // int数组存储两个元素（num, count）
        // 分别代表数组的哪个值, 以及该值出现的次数.
        PriorityQueue<int[]> queue = new PriorityQueue<>((m, n) -> m[1] - n[1]);
        // 统计结果最多有n个元素, 每个元素入堆后堆排序时间为O(log k), 因此时间复杂度为O(n log k).
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                // 小顶堆的容量为k, 里边只存放出现次数较大的那些数.
                // 最终遍历完统计结果, 小顶堆中就是我们想要的结果.
                if (queue.peek()[1] < count) {
                    // 弹出出现次数小的，压入出现次数大的.
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        // 时间复杂度：O(k log k)，常数时间复杂度.
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        // 总的时间复杂度O(n log k), 空间复杂度O(n).
        // 建立哈希表时间复杂度为 O(n), 而遍历哈希表入堆时间复杂度为 O(k).
        // 哈希表的空间复杂度为 O(n), 而堆的空间复杂度为 O(k).
        return ret;
    }
}