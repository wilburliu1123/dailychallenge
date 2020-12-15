class braceExp2 {
    public List<String> braceExpansionII(String expression) {
        ArrayDeque<Set<String>> stack = new ArrayDeque<>();
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c - 'a' >= 0 && c - 'a' <= 25) {
                if (set2.isEmpty()) {
                    set2.add("" + c);
                } else {
                    set2 = set2.stream().map(s -> s + c).collect(Collectors.toSet());
                }
            } else if (c == '{') {
                // save current hashset to stack
                stack.push(new HashSet<String>(set1));
                stack.push(new HashSet<String>(set2));
                set1.clear();
                set2.clear();
            } else if (c == '}') {
                Set<String> prevSet2 = stack.pop();
                Set<String> prevSet1 = stack.pop();
                set1.addAll(set2);
                set2 = xProduct(prevSet2, set1);
                set1 = prevSet1;
            } else if (c == ','){
                set1.addAll(set2);
                set2.clear();
            }
        }
        set1.addAll(set2);

        List<String> result = new ArrayList<>(set1);
        Collections.sort(result);

        return result;
    }

    private Set<String> xProduct(Set<String> set1, Set<String> set2) {
        if (set1.isEmpty() || set2.isEmpty()) {
            return set1.isEmpty() ? set2 : set1;
        }
        Set<String> crossProduct = new HashSet<String>();
        for (String s1 : set1) {
            for (String s2 : set2) {
                crossProduct.add(s1+s2);
            }
        }
        return crossProduct;
    }
}