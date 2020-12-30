class findLatestGroupSizeM {
    public int findLatestStep(int[] arr, int m) {
        UF uf = new UF(arr.length);
        int[] A = new int[arr.length];
        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            A[arr[i]-1] = 1;
            uf.countSize.put(1, uf.countSize.getOrDefault(1, 0) + 1);
            if (arr[i] - 2 >= 0 && A[arr[i] - 2] == 1) {
                uf.union(arr[i] - 1, arr[i] - 2, m);
            }
            if (arr[i] < arr.length && A[arr[i]] == 1) {
                uf.union(arr[i] - 1, arr[i], m);
            }
            // System.out.println("current arr[i]: " + arr[i] + " current map: " + uf.countSize);
            if (uf.countSize.containsKey(m) && uf.countSize.get(m) > 0) {
                res = i + 1;
            }
        }
        return res;
    }

}
class UF {
    int[] id;
    int[] sz;
    Map<Integer, Integer> countSize = new HashMap<>();
    public UF(int n) {
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
    public void union(int p, int q, int m) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }
        if (sz[i] < sz[j]) {
            id[i] = j;
            this.countSize.put(sz[j], this.countSize.getOrDefault(sz[j], 0) - 1);
            sz[j] += sz[i];
            this.countSize.put(sz[j], this.countSize.getOrDefault(sz[j], 0) + 1);
            this.countSize.put(sz[i], this.countSize.getOrDefault(sz[i], 0) - 1);
        } else {
            id[j] = i;
            this.countSize.put(sz[i], this.countSize.getOrDefault(sz[i], 0) - 1);
            sz[i] += sz[j];
            this.countSize.put(sz[i], this.countSize.getOrDefault(sz[i], 0) + 1);
            this.countSize.put(sz[j], this.countSize.getOrDefault(sz[j], 0) - 1);
        }
    }
}