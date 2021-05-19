class MaxNumOfSubstrings {
  public List<String> maxNumOfSubstrings(String s) {
    int n = s.length();
    char[] ch = s.toCharArray();
    int[][] sublen = new int[26][4];
    for (int i = 0; i < 26; i++) {
      Arrays.fill(sublen[i], -1);
      sublen[i][2] = 0;
      sublen[i][3] = i;
    }
    for (int i = 0; i < n; i++) {
      int c = ch[i] - 'a';
      if (sublen[c][0] == -1) sublen[c][0] = i;
      sublen[c][1] = i;
      sublen[c][2]++;
    }
    Arrays.sort(sublen, (a,b) -> a[0] - b[0]);
    int[] start = new int[26];
    int[] lens = new int[26];
    Arrays.fill(start, -1);
    for (int i = 0; i < 26; i++) {
      if (sublen[i][0] == -1) continue;
      int max = sublen[i][1];
      int len = sublen[i][2];
      if (max - sublen[i][0] + 1 == len) {
        start[i] = i;
        lens[i] = len;
        continue;
      }
      for (int j = i + 1; j < 26; j++) {
        max = Math.max(max, sublen[j][1]);
        len += sublen[j][2];
        if (max - sublen[i][0] + 1 == len) {
          start[i] = j;
          lens[i] = len;
          break;
        }
      }
    }
    int[] dp = new int[27];
    int[] lsum = new int[27];
    int[] prev = new int[27];
    dp[0] = 0;
    for (int i = 1; i <= 26; i++) {
      dp[i] = dp[i-1];
      lsum[i] = lsum[i-1];
      prev[i] = -1;
      for (int j = 0; j < i; j++) {
        if (start[j] == i - 1) {
          int ndp = dp[j] + 1;
          int nsum = lsum[j] + lens[j];
          if (ndp > dp[i] || ndp == dp[i] && nsum < lsum[i]) {
            dp[i] = ndp;
            lsum[i] = nsum;
            prev[i] = j;
          }
        }
      }
    }
    int arg = 0;
    for (int i = 0; i <= 26; i++) {
      if (dp[i] > dp[arg] || dp[i] == dp[arg] && lsum[i] < lsum[arg]) {
        arg = i;
      }
    }
    List<String> list = new ArrayList<>();
    int cur = arg;
    while (cur > 0) {
      int p = prev[cur];
      if (p == -1) {
        cur--;
        continue;
      }
      list.add(s.substring(sublen[p][0], sublen[p][0] + lens[p]));
      cur = p;
    }
    return list;
  }
}