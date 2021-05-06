class Solution {
public:
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        // 方法一：
        multiset<pair<int, int>> vec;
        for(auto& b: buildings) {
            vec.insert({b[0], -b[2]});
            vec.insert({b[1], b[2]});
        }
        // 方法二：
        // vector<pair<int, int>> vec;
        // for(auto& b: buildings) {
        //     vec.push_back({b[0], -b[2]});
        //     vec.push_back({b[1], b[2]});
        // }
        // sort(vec.begin(), vec.end());

        multiset<int> pq;
        pq.insert(0);
        int preMax = 0;

        vector<vector<int>> res;
        for(auto& p: vec) {
            if (p.second < 0) {
                pq.insert(-p.second);
            } else {
                pq.erase(pq.find(p.second));
            }
            int curMax = *pq.rbegin();
            if (curMax != preMax) {
                res.push_back({p.first, curMax});
                preMax = curMax;
            }  
        }
        return res;
    }
};