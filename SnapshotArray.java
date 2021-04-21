class SnapshotArray {
  List<int[]>[] list;
  int count;
  public SnapshotArray(int length) {
    list = new List[length];
    count = 0;
    for (int i = 0; i < length; i++) {
      list[i] = new ArrayList<>();
      list[i].add(new int[] {0, 0});
    }
  }

  public void set(int index, int val) {
    if (list[index].get(list[index].size() - 1)[0] == count)
      list[index].get(list[index].size() - 1)[1] = val;
    else
      list[index].add(new int[] {count, val});
  }

  public int snap() {
    // System.out.println(count + 1);
    return count++;
  }

  public int get(int index, int snap_id) {
    int idx = Collections.binarySearch(list[index], new int[]{snap_id, 0}, (a, b) -> Integer.compare(a[0], b[0]));
    if (idx < 0) idx = -idx - 2;
    return list[index].get(idx)[1];
  }
}