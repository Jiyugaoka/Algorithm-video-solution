class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        int N = s.length();
        if (N == 0) return res;
        List<String> init = new ArrayList<>();
        init.add(s.substring(0, 1));
        res.add(init);
        for (int i = 1; i < N; i++) {
            String cur = s.substring(i, i+ 1);
            List<List<String>> tempRes = new ArrayList<>();
            for (List<String> item: res) {
                int n = item.size();
                /*第一种情况，直接加入当前字符*/
                List<String> newItem1 = new ArrayList<>(item);
                newItem1.add(cur);
                tempRes.add(newItem1);

                /*第二种情况，当字符与最后一个字符串拼接可以构成回文*/
                List<String> newItem2 = new ArrayList<>(item);
                if (item.get(n - 1).equals(cur)) {
                    newItem2.set(n - 1, cur + cur);
                    tempRes.add(newItem2);
                }

                /*第三种情况，当前字符利用最后一个字符串，与倒数第二个字符串结合，构成回文串*/
                List<String> newItem3 = new ArrayList<>(item);
                if (n >= 2 && item.get(n - 2).equals(cur)) {
                    String last = item.get(n - 1);
                    newItem3.remove(n - 1);
                    newItem3.set(n - 2, cur + last + cur);
                    tempRes.add(newItem3);
                }
            }
            res = tempRes;
        }
        return res;
    }

    public List<List<String>> partition1(String s) {
        backTrack(new ArrayList<>(), 0, s);
        return res;
    }

    private void backTrack(List<String> preChoice, int curStep, String s){
        if (curStep == s.length()) {
            res.add(new ArrayList<>(preChoice));
            return ;
        }

        for (int i = curStep; i < s.length(); i++) {
            String str = s.substring(curStep, i + 1);
            if (isHuiWen(s, curStep, i)) {
                preChoice.add(str);
                backTrack(preChoice, i + 1, s);
                preChoice.remove(preChoice.size() - 1);
            }
        }
    }

    private boolean isHuiWen(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}