class MedianFinder {
    private int count;
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        count = 0;
        // 大顶堆
        maxHeap = new PriorityQueue<>((x, y) -> y - x);
        // 小顶堆
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        count++;
        // 目的是让大顶堆中元素的数目>=小顶堆中元素的数目，这样直接取大顶堆堆顶元素就是中位数了。
        // 先入大顶堆，再弹出存入小顶堆，大顶堆的元素都<=小顶堆的元素
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if ((count % 2) == 1) {
           maxHeap.offer(minHeap.poll()); 
        }
    }
    
    public double findMedian() {
        if ((count % 2) == 1) {
            return (double) maxHeap.peek();
        } else {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */