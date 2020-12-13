class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        dic = {}
        for e in nums:
            if e in dic:
                dic[e] += 1
            else:
                dic[e] = 1
        for key in dic.keys():
            if dic[key] == 1:
                return  key