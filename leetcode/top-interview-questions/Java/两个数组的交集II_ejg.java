class Solution {
    public int[] intersect1(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        // 有序哈希表
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num: nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 备份
        Map<Integer, Integer> map1 = new LinkedHashMap<>(map);
        for (int num: nums2) {
            if (map1.containsKey(num) && map1.get(num) > 0) {
                map1.put(num, map1.get(num) - 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int val1 = entry.getValue();
            int val2 = map1.get(key);
            for (int i = 0; i < val1 - val2; i++) {
                res.add(key);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ind1 = 0, ind2 = 0, N1 = nums1.length, N2 = nums2.length;
        while (ind1 < N1 && ind2 < N2) {
            if (nums1[ind1] == nums2[ind2]) {
                res.add(nums1[ind1]);
                ind1++;
                ind2++;
            } else {
                if (nums2[ind2] < nums1[ind1]) {
                    ind2++;
                } else {
                    ind1++;
                }
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}