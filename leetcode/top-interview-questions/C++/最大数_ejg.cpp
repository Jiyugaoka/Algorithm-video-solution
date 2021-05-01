// #include <algorithm> transform 和 sort
// #include <vector> 
// using namespace std; to_string
class Solution {
    // [10, 2]
    // 210
    // 102
public:
    string largestNumber(vector<int>& nums) {
        vector<string> ss(nums.size());
        transform(nums.begin(), nums.end(), ss.begin(), [](int n){return to_string(n);});
        sort(ss.begin(), ss.end(), [](string s1, string s2) {return s2 + s1 < s1 + s2;});
        string res = accumulate(ss.begin(), ss.end(), string(""));
        return res[0] == '0' ? "0" : res;
    }
};