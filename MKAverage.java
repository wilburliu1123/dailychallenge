
class MKAverage {
  TreeMap<Integer, Integer> large, mid, small;
  Queue<Integer> stream;
  int m, k, countL, countS;
  long sum = 0;
  public MKAverage(int m, int k) {
    stream = new LinkedList<>();
    large = new TreeMap<>();
    mid = new TreeMap<>();
    small = new TreeMap<>();
    this.m = m;
    this.k = k;
  }

  public void addElement(int num) {
    if (stream.size() == m) {
      int cur = stream.poll();
      if (large.containsKey(cur)) {
        large.put(cur, large.get(cur) - 1);
        if (large.get(cur) == 0) large.remove(cur);
        countL--;
      } else if(mid.containsKey(cur)) {
        mid.put(cur, mid.get(cur) - 1);
        if (mid.get(cur) == 0) mid.remove(cur);
        sum -= cur;
      } else {
        small.put(cur, small.get(cur) - 1);
        if (small.get(cur) == 0) small.remove(cur);
        countS--;
      }
    }

    add(mid, num);
    stream.add(num);
    sum += num;
    // move from mid to large to satisfy k size requirement
    if (countL < k && !mid.isEmpty()) {
      countL++;
      sum -= mid.lastKey();
      add(large, remove(mid, mid.lastKey()));
    }
    if (!mid.isEmpty() && !large.isEmpty() && large.firstKey() < mid.lastKey()) {
      sum += large.firstKey();
      add(mid, remove(large, large.firstKey()));
      sum -= mid.lastKey();
      add(large, remove(mid, mid.lastKey()));
    }
    // same for small (make sure small has size k)
    if (countS < k && !mid.isEmpty()) {
      countS++;
      sum -= mid.firstKey();
      add(small, remove(mid, mid.firstKey()));
    }

    if (!mid.isEmpty() && !small.isEmpty() && small.lastKey() > mid.firstKey()) {
      sum += small.lastKey();
      add(mid, remove(small, small.lastKey()));
      sum -= mid.firstKey();
      add(small, remove(mid, mid.firstKey()));
    }
  }
  private int remove(TreeMap<Integer, Integer> map, int num) {
    map.put(num, map.get(num) - 1);
    if (map.get(num) == 0) map.remove(num);
    return num;
  }

  private void add(TreeMap<Integer, Integer> map, int num) {
    map.put(num, map.getOrDefault(num, 0) + 1);
  }
  public int calculateMKAverage() {
    // System.out.println(sum);
    return stream.size() == m ? (int) sum / (m - 2 * k) : -1;
  }
}