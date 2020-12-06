class removeDuplicates {
    public String removeDuplicates(String s, int k) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        char[] c = s.toCharArray();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            c[j] = c[i];
            if (j == 0 || c[j] != c[j-1]) {
                stack.push(1);
            } else {
                int increased = stack.pop() + 1;
                if (increased == k) {
                    j = j - k;
                } else {
                    stack.push(increased);
                }
            }
            j++;
        }
        return new String(c, 0, j);
    }
}