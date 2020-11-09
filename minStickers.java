public int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        int[][] map = new int[n][26];
        Map<String, Integer> dp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (char c : stickers[i].toCharArray()) {
                map[i][c - 'a']++;
            }
        }
        // init
        dp.put("", 0);
        return dfs(dp, map, target);
}
private int dfs(Map<String, Integer> dp, int[][] map, String target) {
        if (dp.containsKey(target)) {
            return dp.get(target);
        }
        int ans = Integer.MAX_VALUE, n = map.length; // n stickers
        int[] t = new int[26];
        for (char c : target.toCharArray()) {
            t[c - 'a']++;
        }
        // try every sticker
        for (int i = 0; i < n; i++) {
            // skip sticker that does not contains target first char
            if (map[i][target.charAt(0) - 'a'] == 0) continue;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (t[j] > 0) {
                    for (int k = 0; k < Math.max(0, t[j] - map[i][j]); k++) {
                        sb.append((char) ('a' + j));
                    }
                }
            }
            String s = sb.toString();
            int temp = dfs(dp, map, s);
            if (temp != -1) ans = Math.min(ans, 1 + temp);
        }
        dp.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
        return dp.get(target);
}