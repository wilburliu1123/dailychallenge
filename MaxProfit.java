class MaxProfit {
  int mod = 1_000_000_007;
  public int maxProfit(int[] inventory, int orders) {

    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
    int n = inventory.length;
    for (int i = 0; i < n; i++) {
      pq.add(inventory[i]);
    }
    long res = 0;
    int count = 1;
    while (orders > 0) {
      long cur = pq.poll();
      long next = pq.isEmpty() ? 0 : pq.peek();
      if ((cur - next) * count <= orders) {

        // orders = orders - (cur - next);
        res = (res % mod + arithSequence(cur, next, count) % mod) % mod;
        // cur = pq.peek() - 1;
        orders = orders - (int) (cur - next) * count % mod;
      } else {
        next = cur - orders / count;
        res = (res % mod  + arithSequence(cur, next, count)) % mod;
        res = (res % mod  + 1l * next % mod * (orders % count)) % mod;
        orders = 0;
      }
      count++;
    }
    return (int) res;
  }
  long arithSequence(long a, long b, int count) {
    return 1L* (a + b + 1) * (a - b) * count / 2 % mod;
  }
}