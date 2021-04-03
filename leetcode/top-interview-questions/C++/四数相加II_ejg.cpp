class Solution {
public:
    int fourSumCount(vector<int>& A, vector<int>& B, vector<int>& C, vector<int>& D) {
        unordered_map<int, int> countAB;
        for (int u: A) {
            for (int v: B) {
                ++countAB[u + v];
            }
        }
        int res = 0;
        for (int u: C) {
            for (int v: D) {
                if (countAB.count(-u - v)) {
                    res += countAB[-u - v];
                }
            }
        }
        return res;
    }
};