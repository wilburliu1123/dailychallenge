class FindBestValue {
  public int findBestValue(int[] arr, int target) {
    int sum = 0, n = arr.length, l = 0, r = 0, prev = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
    for (int i : arr) {
      sum += i;
      r = Math.max(r, i);
    }
    if (sum == target) return r;

    while(l <= r) {
      int mid = l + (r - l) / 2;
      sum = getSum(arr, target, mid);
      int diff = Math.abs(sum - target);
      if (diff < prev) {
        res = mid;
        prev = diff;
      } else if(diff == prev) {
        res = Math.min(res, mid);
      }
      if (sum > target) r = mid - 1;
      else l = mid + 1;

    }
    return res;
  }

  int getSum(int[] arr, int target, int mid) {
    int n = arr.length, sum = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] > mid) {
        sum += mid;
      } else {
        sum += arr[i];
      }
    }
    return sum;
  }
}