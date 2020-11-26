class StockSpanner {
    ArrayDeque<int[]> stack;
    public StockSpanner() {
        this.stack = new ArrayDeque<int[]>();
    }

    public int next(int price) {
        int res = 1;
        while (!this.stack.isEmpty() && this.stack.peek()[0] <= price) {
            int[] cur = this.stack.pop();
            res += cur[1];
        }
        this.stack.push(new int[] {price, res});
        return res;
    }
}