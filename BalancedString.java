class BalancedString {
  public int balancedString(String s) {
    int[] count = new int[26];
    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'A']++;
    }
    int left = 0, k = s.length() / 4, res = s.length();
    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'A']--;
      while (left < s.length() && count['Q' - 'A'] <= k && count['W' - 'A'] <= k && count['E' - 'A'] <= k && count['R' - 'A'] <= k) {
        res = Math.min(res, i - left + 1);
        count[s.charAt(left++) - 'A']++;
      }
    }
    return res;
  }
}