class Solution {
    public boolean wordBreak1(String s, List<String> wordDict) {
        return backTrack(0, s, wordDict);
    }

    private boolean backTrack(int curStep, String s, List<String> wordDict) {
        if (curStep == s.length()) {
            return true;
        }
        
        for (String word: wordDict) {
            int len = word.length();
            if (curStep + len <= s.length()) {
                String str = s.substring(curStep, curStep + len);
                if (str.equals(word) && backTrack(curStep + len, s, wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int N = s.length();
        boolean[] dp = new boolean[N + 1];
        /*dp[i] 字符串s的前i个字符是否可以由字典中单词构成*/
        dp[0] = true;
        for (int i = 0; i < N; i++) {
            for (String word: wordDict) {
                int n = word.length();
                if (i + n <= N) {
                    String str = s.substring(i, i + n);
                    /* 
                    * dp[i + n] = dp[i] + str.equals(word);
                    */
                    if (dp[i] && str.equals(word)) {
                        dp[i + n] = true;
                    }
                }  
            }
        }
        return dp[N];
    }
}