class calculator {
    int i = 0;
    public int calculate(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        char operator = '+';
        int num = 0;
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                num = calculate(s);
            }
            if (i >= s.length() || c == '+' || c == '-' || c == '*' || c == '/' || c == ')') {
                if (operator == '+') {
                    stack.push(num);
                } else if (operator == '-') {
                    stack.push(-num);
                } else if (operator == '*') {
                    num = stack.pop() * num;
                    stack.push(num);
                } else if (operator == '/') {
                    num = stack.pop() / num;
                    stack.push(num);
                }
                operator = c;
                num = 0;
            }
            if (c == ')') break;
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}