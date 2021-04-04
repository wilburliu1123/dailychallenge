class kokoEatbanana {
  public int minEatingSpeed(int[] piles, int h) {
    int l = 1, r = 1_000_000_000;
    while (l < r) {
      int mid = l + (r - l) / 2;
      int sum = 0;
      for (int i = 0; i < piles.length; i++) {
        if (piles[i] % mid != 0) {
          sum += piles[i] / mid + 1;
        } else {
          sum += piles[i] / mid;
        }
      }
      if (sum <= h) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }
}