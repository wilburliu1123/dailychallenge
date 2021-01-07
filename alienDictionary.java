class alienDictionary {
    public String alienOrder(String[] words) {
        // topological sort
        Map<Character, List<Character>> map = new HashMap<>();
        Map<Character, Integer> indegree = new LinkedHashMap<>();
        for (String s : words) {
            for (char c : s.toCharArray()) {
                map.put(c, new ArrayList<>());
                indegree.put(c, 0);
            }
        }
        for (int i = 0; i < words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    map.get(word1.charAt(j)).add(word2.charAt(j));
                    indegree.put(word2.charAt(j), indegree.getOrDefault(word2.charAt(j), 0) + 1);
                    break;
                }
            }
        }
        // System.out.println(indegree);
        Queue<Character> q = new LinkedList<>();
        for (Map.Entry<Character, Integer> pair : indegree.entrySet()) {
            if (pair.getValue() == 0) q.add(pair.getKey());
        }
        // System.out.println(q);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char cur = q.poll();
            sb.append(cur);
            for (char nei : map.getOrDefault(cur, new ArrayList<>())) {
                indegree.put(nei, indegree.get(nei) - 1);
                if (indegree.get(nei) == 0) {
                    q.add(nei);
                }
            }
        }
        if (sb.length() < indegree.size()) return "";
        return sb.toString();
    }
}