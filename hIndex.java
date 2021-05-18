class hIndex {
  public static int hIndex(int[] citations) {
    int papers = citations.length;
    int start = 0, end = papers - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      int n = 0, remain = 0;
      if (citations[mid] == papers - mid) {
        return papers - mid;
      } else if (citations[mid] < papers - mid) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return papers - start;
  }
}