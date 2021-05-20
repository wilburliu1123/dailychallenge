class MinInsertions {
  public int minInsertions(String ss) {
    char[] s = ss.toCharArray();
    int need_left = 0, need_right = 0;
    for (int i = 0; i < s.length; i++) {
      if (s[i] == '(') {
        need_right += 2;
        if(need_right % 2 != 0){
          need_left++;
          need_right--;
        }
      }
      if (s[i] == ')') {
        need_right -= 1;
      }
      if (need_right < 0) {
        need_right += 2;
        need_left += 1;
      }
    }
    return need_right + need_left;
  }
}