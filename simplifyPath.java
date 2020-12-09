class simplifyPath {
    public String simplifyPath(String path) {
        if (path.length() == 0) {
            return path;
        }
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");
        for (String dir : components) {
            if (dir.equals(".") || dir.isEmpty()) {
                continue;
            } else if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(dir);
            }
        }
        StringBuilder res = new StringBuilder();
        for (String dir : stack) {
            res.append("/");
            res.append(dir);
        }
        return res.length() > 0 ? res.toString() : "/";
    }
}