class findLongestSubString {
    public int findTheLongestSubstring(String s) {
        int res = 0;
        int[] vCount = new int[5];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (c == 'a') {
                vCount[0]++;
            } else if (c == 'e') {
                vCount[1]++;
            } else if (c == 'i') {
                vCount[2]++;
            } else if (c == 'o') {
                vCount[3]++;
            } else if (c == 'u') {
                vCount[4]++;
            }
            // key is binary representation of current count[]
            int key = countToKey(vCount);
            // map stores the smallest right index when key appears the first time then calculate max res
            if (map.containsKey(key)) {
                res = Math.max(res, right - map.get(key));
            } else {
                map.put(key, right);
            }
        }
        return res;
    }
    private int countToKey(int[] count) {
        int key = 0;
        for (int i = 0; i < 5; i++) {
            if (count[i] % 2 == 1) {
                key += 1 << i;
            }
        }
        return key;
    }
}