class atMostK {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0;
        int res = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while (map.keySet().size() > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}