class CountTriplets {
  public int countTriplets(int[] arr) {
    int n = arr.length;
    int[] preX = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      preX[i] = preX[i - 1] ^ arr[i - 1];
    }
    int res = 0;
    for (int i = 0; i <= n; i++) {
      for (int j = i + 1; j <= n; j++) {
        if (preX[i] == preX[j]) {
          res += j - i - 1;
        }
      }
    }
    return res;
  }
  // O(n)
  public int countTriplets(int[] arr) {
    int n = arr.length;
    int xor = 0;
    Map<Integer, Integer> count = new HashMap<>();
    Map<Integer, Integer> total = new HashMap<>();
    int c, t;
    int res = 0;
    count.put(0, 1);
    for (int i = 0; i < n; i++) {
      xor ^= arr[i];
      c = count.getOrDefault(xor, 0);
      t = total.getOrDefault(xor, 0);
      res += c * i - t;
      count.put(xor, c + 1);
      total.put(xor, t + i + 1);
    }
    return res;
  }
}