class RandomizedCollection {
  Map<Integer, Set<Integer>> map;
  List<Integer> list;
  Random rand;
  /** Initialize your data structure here. */
  public RandomizedCollection() {
    map = new HashMap<>();
    list = new ArrayList<>();
    rand = new Random();
  }

  /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
  public boolean insert(int val) {
    boolean res = false;
    if (!map.containsKey(val) || map.get(val).isEmpty()) {
      res = true;
    }
    map.computeIfAbsent(val, x -> new HashSet<>()).add(list.size());
    list.add(list.size(), val);
    return res;
  }

  /** Removes a value from the collection. Returns true if the collection contained the specified element. */
  public boolean remove(int val) {
    if (!map.containsKey(val) || map.get(val).isEmpty()) return false;
    int idx = map.get(val).iterator().next();
    map.get(val).remove(idx);
    int last = list.get(list.size() - 1);
    list.set(idx, last);
    map.get(last).add(idx);
    map.get(last).remove(list.size() - 1);
    list.remove(list.size()-1);
    return true;
  }

  /** Get a random element from the collection. */
  public int getRandom() {
    return list.get(rand.nextInt(list.size()));
  }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */