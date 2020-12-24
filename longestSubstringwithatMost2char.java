class atMost2char {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while (map.keySet().size() > 2) {
                char c = s.charAt(left++);
                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}