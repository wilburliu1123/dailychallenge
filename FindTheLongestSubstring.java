class FindTheLongestSubstring {
  public int findTheLongestSubstring(String s) {
    Map<Integer, Integer> map = new HashMap<>();
    // init all zero to be at -1 index
    map.put(0, -1);
    int res = 0, mask = 0, n = s.length();
    String vowel = "aeiou";
    for (int i = 0; i < n; i++) {
      // toggle current char (if it is vowel) bit in mask.
      // if it is not vowel, indexof method will return -1
      mask ^= 1 << (vowel.indexOf(s.charAt(i)) + 1) >> 1;
      map.putIfAbsent(mask, i);
      res = Math.max(res, i - map.get(mask));
    }
    return res;
  }
}