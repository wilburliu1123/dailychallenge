class SpecialArray {
  public int specialArray(int[] nums) {
    int n = nums.length;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    int total = 0;
    for (int i : map.values()) {
      total += i;
    }
    if (map.firstKey() >= total) return total;
    for (int i = 0; i < 1000; i++) {
      if (map.containsKey(i)) {
        int key = map.firstKey();
        if (total == key) {
          return key;
        }
        total -= map.get(key);
        map.remove(key);
      } else {
        if (map.keySet().isEmpty() || i > map.firstKey()) break;
        if (i < map.firstKey() && total == i) return i;

      }

    }

    return -1;
  }
}