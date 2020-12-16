class countAtom {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = new TreeMap<>();
        ArrayDeque<Map<String, Integer>> stack = new ArrayDeque<>();
        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == '(') {
                stack.push(new HashMap<String,Integer>(map));
                map.clear();
            } else if (formula.charAt(i) == ')') {
                // for example "Mg(OH)2", when you encounter ')', you need to count how many count is there. In this case is 2
                int j = i + 1;
                // check if it is a number
                while (j < formula.length() && Character.isDigit(formula.charAt(j))) {
                    j++;
                }
                int num = 1;
                // if j didn't move, set num to 1
                if (j == i + 1) {
                    num = 1;
                } else {
                    num = Integer.valueOf(formula.substring(i+1, j));
                }
                // set each element to their count
                for (Map.Entry<String, Integer> pair : map.entrySet()) {
                    map.put(pair.getKey(), pair.getValue() * num);
                }
                // copy current stack.peek() map into our map for result. Add the value if our result map already have a chemical element
                Map<String, Integer> cur = new HashMap<>(stack.peek());
                for (Map.Entry<String, Integer> pair : cur.entrySet()) {
                    if (map.containsKey(pair.getKey())) {
                        int newVal = map.get(pair.getKey()) + pair.getValue();
                        map.put(pair.getKey(), newVal);
                    } else {
                        map.put(pair.getKey(), pair.getValue());
                    }
                }
                stack.pop();
                i = j - 1;
            } else if (formula.charAt(i) >= 'A' && formula.charAt(i) <= 'Z') {
                int j = i + 1;
                while (j < formula.length() && formula.charAt(j) >= 'a' && formula.charAt(j) <= 'z') {
                    j++;
                }
                String element = formula.substring(i, j);
                i = j - 1;
                // if there is number on the right of the element, count and add it to the map. for example, Mg2(OH)4, 2 need to be added to Mg in the map
                while (j < formula.length() && Character.isDigit(formula.charAt(j))) {
                    j++;
                }
                int num = 1;
                if (j == i + 1) {
                    num = 1;
                } else {
                    num = Integer.valueOf(formula.substring(i+1, j));
                }
                map.put(element, map.getOrDefault(element, 0) + num);
                i = j-1;
            }
        }
        String res = "";
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            res += pair.getKey();
            if (pair.getValue() > 1) {
                res += pair.getValue().toString();

            }
        }
        return res;
    }
}