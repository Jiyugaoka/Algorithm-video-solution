class Solution {
    public String largestNumber(int[] nums) {
        String res = Arrays.stream(nums)
            .mapToObj(String::valueOf)
            .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
            .reduce("", (a , b) -> (a + b));
        return res.charAt(0) == '0' ? "0" : res;
    }
}