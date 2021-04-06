class Solution {
public:
    int fourSumCount0(vector<int>& A, vector<int>& B, vector<int>& C, vector<int>& D) {
        int res = 0;
        for (int x: A) {
            for (int y: B) {
                for (int p: C) {
                    for (int q: D) {
                        if (x + y + p + q == 0) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

    int fourSumCount1(vector<int>& A, vector<int>& B, vector<int>& C, vector<int>& D) {
        int res = 0;
        for (int x: A) {
            for (int y: B) {
                for (int p: C) {
                    int temp = x + y + p;
                    for (int q: D) {
                        if (temp + q == 0) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

    int fourSumCount2(vector<int>& A, vector<int>& B, vector<int>& C, vector<int>& D) {
        int res = 0;
        for (int x: A) {
            for (int y: B) {
                int temp1 = x + y;
                for (int p: C) {
                    for (int q: D) {
                        int temp2 = p + q;
                        if (temp1 + temp2 == 0) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

    int fourSumCount(vector<int>& A, vector<int>& B, vector<int>& C, vector<int>& D) {
        unordered_map<int, int> countAB;
        for (int x: A) {
            for (int y: B) {
                countAB[x + y]++;
            }
        }
        int res = 0;
        for (int p: C) {
            for (int q: D) {
                int temp = p + q;
                if (countAB.count(-temp)) {
                    res += countAB[-temp];
                }
            }
        }
        return res;
    }
};