class Solution {
    public boolean isAnagram(String s, String t) {
        int[] numS = new int[26];
        int[] numT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            numS[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            numT[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (numS[i] != numT[i]) return false;
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        if (charS.length != charT.length) return false;
        Arrays.sort(charS);
        Arrays.sort(charT);
        for (int i = 0; i < charS.length; i++) {
            if (charS[i] != charT[i]) return false;
        }
        return true;
    }
}