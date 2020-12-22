class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int N = s.length();
        boolean[] dp = new boolean[N + 1];
        dp[0] = true;
        for (int i = 0; i < N; i++) {
            for (String word: wordDict) {
                int n = word.length();
                if (i + n <= N) {
                    String str = s.substring(i, i + n);
                    if (dp[i] && str.equals(word)) {
                        dp[i + n] = true;
                    }
                }  
            }
        }
        List<String> res = new ArrayList<>();
        // backTrack(res, new StringBuilder(), 0, s, wordDict);
        // return res;
        if (!dp[N]) return res;
        else {
            backTrack(res, new StringBuilder(), 0, s, wordDict);
            return res;
        }
    }

    private void backTrack(List<String> res, StringBuilder sb, int curStep, String s, List<String> wordDict) {
        if (curStep == s.length()) {
            res.add(sb.substring(0, sb.length() - 1));
            return ;
        }

        for (String word: wordDict) {
            int n = word.length();
            if (curStep + n <= s.length() && s.substring(curStep, curStep + n).equals(word)) {
                sb.append(word).append(" ");
                backTrack(res, sb, curStep + n, s, wordDict);
                sb.setLength(sb.length() - n - 1);
            }
        }
    }
}