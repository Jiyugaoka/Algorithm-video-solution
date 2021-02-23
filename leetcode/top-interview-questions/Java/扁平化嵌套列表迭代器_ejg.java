/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
// class NestedInteger {
//     private Integer val;
//     private List<NestedInteger> list;

//     public NestedInteger(Integer val) {
//         this.val = val;
//         this.list = null;
//     }
//     public NestedInteger(List<NestedInteger> list) {
//         this.list = list;
//         this.val = null;
//     }

//     // 如果其中存的是一个整数，则返回 true，否则返回 false
//     public boolean isInteger() {
//         return val != null;
//     }

//     // 如果其中存的是一个整数，则返回这个整数，否则返回 null
//     public Integer getInteger() {
//         return this.val;
//     }

//     // 如果其中存的是一个列表，则返回这个列表，否则返回 null
//     public List<NestedInteger> getList() {
//         return this.list;
//     }
// }

public class NestedIterator implements Iterator<Integer> {

    private Iterator it;
    private List<Integer> collector = new ArrayList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        this.traverse(nestedList, collector);
        this.it = collector.iterator();
    }

    @Override
    public Integer next() {
        if (this.hasNext()) {
            return (Integer)it.next();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    public void traverse(List<NestedInteger> nestedList, List<Integer> collector) {
        for (NestedInteger cur: nestedList) {
            if (cur.isInteger()) {
                collector.add(cur.getInteger());
            } else {
                List<NestedInteger> curList = cur.getList();
                traverse(curList, collector);
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */