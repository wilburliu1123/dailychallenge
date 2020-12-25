class atLeastKchar {
    public int longestSubstring(String s, int k) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        int unique = set.size();
        for (int i = 1; i <= unique; i++) {
            int right = 0, count = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int left = 0; left < s.length(); left++) {
                while (right < s.length() && map.keySet().size() <= i) {
                    map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                    if (map.get(s.charAt(right)) == k) {
                        count++;
                    }
                    right++;
                    if (map.keySet().size() == i && count == i) {
                        res = Math.max(res, right - left);
                    }
                }
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == k - 1)
                    count--;
                if (map.get(s.charAt(left)) == 0)
                    map.remove(s.charAt(left));
            }
        }
        return res;
    }
}