class GrumpyBookStoreOwner {
  public int maxSatisfied(int[] customers, int[] grumpy, int X) {
    int satisfies = 0, currentWindow = 0, max = 0;
    for (int i = 0; i < customers.length; i++) {
      if (grumpy[i] == 0) satisfies += customers[i];
      else {currentWindow += customers[i];}
      if (i >= X) {
        currentWindow -= grumpy[i - X] * customers[i - X];
      }
      max = Math.max(max, currentWindow);
    }
    return satisfies + max;
  }
}