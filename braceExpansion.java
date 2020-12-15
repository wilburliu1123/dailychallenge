class braceExpansion {
    public String[] expand(String S) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            StringBuilder sb = new StringBuilder();
            if (c == '{') {
                int j = i + 1;
                while (j < S.length() && S.charAt(j) != '}') {
                    if (S.charAt(j++) != ',') {
                        sb.append(S.charAt(j-1));
                    }
                }
                list.add(sb.toString());
                i = j;
            } else {
                list.add(c + "");
            }
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(list, 0, sb, res);
        Collections.sort(res);
        String[] result = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
    private void backtrack(List<String> list, int index, StringBuilder sb, List<String> res) {
        if (sb.length() == list.size()) {
            res.add(sb.toString());
            return;
        }
        String cur = list.get(index);
        for (int i = 0; i < cur.length(); i++) {
            sb.append(cur.charAt(i));
            backtrack(list, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}