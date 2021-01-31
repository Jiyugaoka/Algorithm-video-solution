class MinStack {

    Deque<Integer> stack;
    // 辅助数组，用于存放最小值
    List<Integer> helper;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        helper = new LinkedList<>();
    }
    
    public void push1(int x) {
        stack.offerLast(x);
        int size = helper.size();
        // 解法一：辅助数组只存储小于等于当前数组末尾值的入栈元素
        if (size == 0 || (size > 0 && x <= helper.get(size - 1))) {
            helper.add(x);
        }
    }
    
    public void push(int x) {
        stack.offerLast(x);
        int size = helper.size();
        if (size == 0) {
            helper.add(x);
            return ;
        } 
        // 解法二：入栈元素若是大于当前数组末尾值则重复存储当前数组末尾值的元素
        // if (x <= helper.get(size - 1)) {
        //     helper.add(x);
        // } else {
        //     helper.add(helper.get(size - 1));
        // } 上述代码可优化为如下一行代码：
        helper.add(Math.min(x, helper.get(size - 1)));
    }
    public void pop1() {
        int cur = stack.pollLast();
        int size = helper.size();
        // 对应解法Push1的弹出方法：只在相等时才弹出
        if (size > 0 && cur == helper.get(size - 1)) {
            helper.remove(size - 1);
        }
    }

    public void pop() {
        int cur = stack.pollLast();
        int size = helper.size();
        // 辅助数组和栈同时弹出
        if (size > 0) {
            helper.remove(size - 1);
        }
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int getMin() {
        int size = helper.size();
        if (size > 0) {
            return helper.get(size - 1);
        }
        return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */