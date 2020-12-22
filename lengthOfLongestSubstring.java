class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.get(c) > 1) {
                char leftChar = s.charAt(left++);
                map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}