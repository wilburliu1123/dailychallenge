class Solution {
  int max = 0;
  public int maxUniqueSplit(String s) {
    split(s, new HashSet<>(), 0);
    return max;
  }

  void split(String s, Set<String> set, int end) {
    if (end == s.length()) {
      // set.add(s.substring(start, end+1));
      max = Math.max(max, set.size());
      return;
    }
    // else if (end == s.length()) {
    //     set.add(s.substring(start, end));
    //     max = Math.max(max, set.size()-1);
    //     return;
    // }
    // if (set.add(s.substring(start, end))) {
    //     max = Math.max(set.size(), max);
    //     split(s, set, end, end+1);
    // }
    for (int i = end; i < s.length(); i++) {
      String sub = s.substring(end, i+1);
      if (!set.contains(sub)) {
        set.add(sub);
        split(s, set, i + 1);
        set.remove(sub);
      }
      // split(s, set, start, i + 1);
    }
    return;
  }
}