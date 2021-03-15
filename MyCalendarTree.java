class MyCalendarThree {
  TreeMap<Integer, Integer> map;
  public MyCalendarThree() {
    map = new TreeMap<>();
  }

  public int book(int start, int end) {
    map.put(start, map.getOrDefault(start, 0) + 1);
    map.put(end, map.getOrDefault(end, 0) - 1);
    int res = 0, count = 0;
    for (int i : map.values()) {
      count += i;
      if (count > res) res = count;
    }
    return res;
  }
}