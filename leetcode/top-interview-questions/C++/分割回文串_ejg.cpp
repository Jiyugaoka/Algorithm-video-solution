class Solution {
private:
    vector<vector<bool>> dp;
    vector<vector<string>> res;
    int N;

    void dfs(vector<string> cur, int ind, const string& s) {
        if (ind == N) {
            res.push_back(cur);
            return ;
        }
        for (int i = ind; i < N; i++) {
            if (dp[ind][i]) {
                cur.push_back(s.substr(ind, i - ind + 1));
                dfs(cur, i + 1, s);
                cur.pop_back();
            }
        }
    }

public:
    vector<vector<string>> partition(string s) {
        N = s.size();
        dp.assign(N, vector<bool>(N, true));
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                dp[i][j] = (s[i] == s[j]) && (dp[i + 1][j - 1]);
            }
        }
        dfs({}, 0, s);
        return res;
    }
};