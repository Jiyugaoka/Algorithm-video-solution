class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isUpperCase(ch[i])) {
                ch[i] += 32;
            }
        }
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(ch[left])) left++;
            while (left < right && !Character.isLetterOrDigit(ch[right])) right--;
            if (left < right) {
                if (ch[left] != ch[right]) {
                    return false;
                }
                else {
                    left++;
                    right--;
                }
            }
        }
        return true;
    }
}