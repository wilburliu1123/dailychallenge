class basicCalculatorII {
    public int calculate(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        s = s.replaceAll("\\s", "");
        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (i == s.length() - 1 || c == '+' || c == '-' || c == '*' || c == '/') {
                if (operator == '+') {
                    stack.push(num);
                } else if (operator == '-') {
                    stack.push(-num);
                } else if (operator == '*') {
                    num *= stack.pop();
                    stack.push(num);
                } else if (operator == '/') {
                    num = stack.pop() / num;
                    stack.push(num);
                }
                operator = c;
                num = 0;
            }
        }
        return stack.stream().mapToInt(x -> x).sum();
    }
}