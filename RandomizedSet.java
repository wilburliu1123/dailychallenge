class RandomizedSet {
  Map<Integer, Integer> map;
  List<Integer> list;
  Random rand;
  /** Initialize your data structure here. */
  public RandomizedSet() {
    map = new HashMap<>();
    list = new ArrayList<>();
    rand = new Random();
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if (map.containsKey(val)) return false;
    map.put(val, list.size());
    list.add(list.size(), val);
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (!map.containsKey(val)) return false;
    int last = list.get(list.size() - 1);
    int idx = map.get(val); //retrieve index from map
    list.set(idx, last);
    map.put(last, idx);
    list.remove(list.size() - 1);
    map.remove(val);
    // System.out.println(list);
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    return list.get(rand.nextInt(list.size()));
  }
}