class OddEvenJump {
  public int oddEvenJumps(int[] arr) {
    int n = arr.length, res = 1;
    boolean[] higher = new boolean[n], lower = new boolean[n];
    higher[n-1] = lower[n-1] = true;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    map.put(arr[n-1], n - 1);
    for (int i = n - 2; i >= 0; i--) {
      Map.Entry<Integer, Integer> high = map.ceilingEntry(arr[i]), low = map.floorEntry(arr[i]);
      if (high != null) higher[i] = lower[(int) high.getValue()];
      if (low != null) lower[i] = higher[(int) low.getValue()];
      if(higher[i]) res++;
      map.put(arr[i], i);
    }
    return res;
  }
}