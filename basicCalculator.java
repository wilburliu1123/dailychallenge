class basicCalculator {
    int i = 0;
    public int calculate(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char operator = '+';
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                num = calculate(s);
            }
            if (i >= s.length() || c == '+' || c == '-' || c == ')') {
                if (operator == '+') {
                    stack.push(num);
                } else if (operator == '-') {
                    stack.push(-num);
                }
                operator = c;
                num = 0;
            }
            if (operator == ')') break;
        }
        return stack.stream().mapToInt(x -> x).sum();
    }
}
