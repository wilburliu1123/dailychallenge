class sumSubarrayMin {
    public int sumSubarrayMins(int[] arr) {
        int res = 0, n = arr.length, mod = (int)1e9 + 7;
        int[] left = new int[n], right = new int[n];
        ArrayDeque<int[]> s1 = new ArrayDeque<>(), s2 = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            int count = 1;
            while (!s1.isEmpty() && s1.peek()[0] > arr[i])
                count += s1.pop()[1];
            s1.push(new int[] {arr[i], count});
            left[i] = count;
        }
        for (int i = n - 1; i >= 0; --i) {
            int count = 1;
            while (!s2.isEmpty() && s2.peek()[0] >= arr[i])
                count += s2.pop()[1];
            s2.push(new int[] {arr[i], count});
            right[i] = count;
        }
        for (int i = 0; i < n; ++i)
            res = (res + arr[i] * left[i] * right[i]) % mod;
        return res;
    }
}