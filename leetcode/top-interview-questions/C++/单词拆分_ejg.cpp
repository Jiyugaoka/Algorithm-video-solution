class Solution {
private: 
    bool backtrack(vector<int>& memo, 
                int ind, 
                const string& s, 
                const unordered_set<string>& wordDictSet) {
        int N = s.size();
        if (ind >= N) return true;
        /** 0代表false, 非0代表true*/
        if (memo[ind] != -1) return memo[ind];
        for (auto word: wordDictSet) {
            int n = word.size();
            if (ind + n <= N) {
                string subStr = s.substr(ind, n);
                if (wordDictSet.find(subStr) != wordDictSet.end() && 
                backtrack(memo, ind + n, s, wordDictSet)) {
                    memo[ind] = 1;
                    return true;
                }
            }
        }  
        memo[ind] = 0;
        return false;
    }

public:
    /**
     记忆化递归，memo有两种状态，-1代表初始状态，未作过计算，非-1代表计算过的状态，直接返回其结果即可。
    */
    bool wordBreak1(string s, vector<string>& wordDict) {
        vector<int> memo(s.size(), -1);
        auto wordDictSet = unordered_set<string> ();
        for (auto word: wordDict) {
            wordDictSet.insert(word);
        }
        return backtrack(memo, 0, s, wordDictSet);
    }

    bool wordBreak2(string s, vector<string>& wordDict) {
        int N = s.size();
        auto wordDictSet = unordered_set<string> ();
        for (auto word: wordDict) {
            wordDictSet.insert(word);
        }
        auto dp = vector<bool> (N + 1, false);
        dp[0] = true;
        for (int i = 0; i < N; i++) {
            for (auto word: wordDictSet) {
                int n = word.size();
                string subStr = s.substr(i, n);
                if (dp[i] && wordDictSet.find(subStr) != wordDictSet.end()) dp[i + n] = true;
            }
        }
        return dp[N];
    }
};