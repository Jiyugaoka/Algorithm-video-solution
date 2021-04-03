class Solution {
public:
    int titleToNumber(string columnTitle) {
        int N = columnTitle.size();
        int res = 0;
        for (int i = 0; i < N; i++) {
            int num = columnTitle[i] - 'A' + 1;
            res = res * 26 + num;
        }
        return res;
    }

    int titleToNumber2(string columnTitle) {
        int N = columnTitle.size();
        int res = 0, base = 1;
        for (int i = N - 1; i >= 0; i--) {
            int num = columnTitle[i] - 'A' + 1;
            res = res + num * base;
            if (i == 0) break;
            base *= 26;
        }
        return res;
    }
};