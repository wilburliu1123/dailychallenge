class parseBooExpr {
    public boolean parseBoolExpr(String expression) {
        Stack<Boolean> booStack = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == 'f') {
                booStack.push(false);
            } else if (c == 't') {
                booStack.push(true);
            } else if (c == '(') {
                booStack.push(null);
            } else if (c == ')') {
                char op = operator.pop();
                boolean res = op == '&';
                while (!booStack.isEmpty() && booStack.peek() != null) {
                    if (op == '&') {
                        res = res & booStack.pop();
                    } else if (op == '|') {
                        res = res | booStack.pop();
                    } else if (op == '!') {
                        res = !(booStack.pop());
                    }
                }
                booStack.pop();
                booStack.push(res);
            } else if (c == ',') {
                continue;
            } else {
                operator.push(c);
            }
        }
        return booStack.peek();
    }
}