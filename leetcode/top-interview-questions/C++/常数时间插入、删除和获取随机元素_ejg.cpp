class RandomizedSet {
private:
    unordered_map<int, int> map;
    vector<int> vec;
public:
    // 本题不包含重复元素
    /** Initialize your data structure here. */
    RandomizedSet() {
        // 数组可以O(1)在末尾插入、删除一个元素
        // 当元素不在末尾时，删除元素是要移位的，并不能O(1)。
        // 哈希表可以O(1)获取一个元素，但是不能O(1)插入一个元素，这与Hash冲突有关。
        // 所以，本题可以将这两种优势结合起来，在数组的末尾插入。
        // 如果删除元素在数组中间，则在对应下边用末尾元素覆盖掉要删除的元素。
        // 同时用O(1)的时间删除数组的最后一个元素
        // 那么就需要用O(1)的时间获取到被删除元素的下边，因此哈希表中存放的key就是元素，
        // value就是元素对应的下标。
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    bool insert(int val) {
        if (map.count(val)) return false;
        vec.push_back(val);
        map[val] = vec.size() - 1;
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    bool remove(int val) {
        if (!map.count(val)) return false;
        int ind = map[val];
        int lastInd = vec.size() - 1;
        int lastVal = vec[lastInd];
        // 开始替换
        vec[ind] = lastVal;
        map[lastVal] = ind;
        // 执行删除
        // 如果ind==lastInd, 则val==lastVal。
        // 那么后执行map[lastVal] = ind的话, 就会出现元素删除了，但是下标索引还保留着。
        map.erase(val);  
        vec.pop_back();  
        return true;
    }
    
    /** Get a random element from the set. */
    int getRandom() {
        return vec[rand() % vec.size()];
    }
};