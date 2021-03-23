class RectangleArea {
  public int rectangleArea(int[][] rectangles) {
    int mod = 1_000_000_007;
    List<Node> nodes = new ArrayList<>();
    for (int[] rec : rectangles) {
      nodes.add(new Node(rec[0], rec[1], 1)); // entry
      nodes.add(new Node(rec[0], rec[3], -1)); // leave
      nodes.add(new Node(rec[2], rec[1], -1));
      nodes.add(new Node(rec[2], rec[3], 1));
    }
    // for (int i = 0; i < nodes.size(); i++) {
    //     System.out.println(nodes.get(i));
    // }
    Collections.sort(nodes, (a,b) -> a.x == b.x ? b.y - a.y : a.x - b.x);
    TreeMap<Integer, Integer> tm = new TreeMap<>();
    int px = -1;
    int py = -1;
    int res = 0;
    for (int i = 0; i < nodes.size(); i++) {
      Node node = nodes.get(i);
      tm.put(node.y, tm.getOrDefault(node.y, 0) + node.k);
      if(i == nodes.size() - 1 || nodes.get(i + 1).x > node.x) {
        if (px > -1) {
          res += ((long) py * (node.x - px)) % mod;
          res %= mod;
        }
        py = getY(tm);
        px = node.x;
      }
    }
    return res;
  }
  private int getY(TreeMap<Integer, Integer> map) {
    int res = 0, prev = -1, count = 0;
    for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
      if (prev >= 0 && count > 0) {
        res += pair.getKey() - prev;
      }
      count += pair.getValue();
      prev = pair.getKey();
    }
    return res;
  }
  class Node {
    int x, y, k;
    public Node(int x, int y, int k) {
      this.x = x;
      this.y = y;
      this.k = k;
    }
    @Override
    public String toString() {
      return "Node{" + x + ", " + y + ", " + k +"}";
    }
  }
}
// segment tree solution
class Solution {
  int mod = 1_000_000_007;
  public int rectangleArea(int[][] rectangles) {
    int n = rectangles.length;
    Segment[] seg = new Segment[n * 2];
    TreeSet<Integer> ts = new TreeSet<>();
    for (int i = 0, j = 0; i < n; i++) {
      int x1 = rectangles[i][0], x2 = rectangles[i][2], y1 = rectangles[i][1], y2 = rectangles[i][3];
      seg[j++] = new Segment(x1, y1, y2, 1);
      seg[j++] = new Segment(x2, y1, y2, -1);
      ts.add(y1);
      ts.add(y2);
    }
    long[] nums = new long[ts.size()];
    int idx = 0;
    for (Integer x : ts) {
      nums[idx++] = x;
    }
    Arrays.sort(seg, (a,b) -> a.x > b.x ? 1 : -1);
    SegmentTree st = new SegmentTree(nums);
    long res = 0;
    for (int i = 0; i < n * 2; i++) {
      if (i > 0) {
        res += st.tree[1].sum * (seg[i].x - seg[i - 1].x);
        res %= mod;
      }
      st.update(1, st.find(seg[i].y1), st.find(seg[i].y2) - 1, seg[i].k);
    }
    return (int) res;
  }
  class SegmentTree {
    long[] nums;
    Node[] tree;
    public SegmentTree(long[] nums) {
      this.nums = nums;
      this.tree = new Node[nums.length * 8];
      buildTree(1, 0, nums.length - 1);
    }
    private void buildTree(int idx, int l, int r) {
      tree[idx] = new Node(l, r, 0, 0);
      if (l != r) {
        int mid = l + (r-l) / 2;
        buildTree(idx * 2, l, mid);
        buildTree(idx * 2 + 1, mid + 1, r);
      }
    }
    public void update(int idx, int l, int r, int k) {
      if (tree[idx].l >= l && tree[idx].r <= r) {
        tree[idx].count += k;
        pushUp(idx);
      } else {
        int mid = tree[idx].l + (tree[idx].r - tree[idx].l) / 2;
        if (l <= mid) update(idx * 2, l, r, k);
        if (r > mid) update(idx * 2 + 1, l, r, k);
        pushUp(idx);
      }
    }
    public void pushUp(int idx) {
      if (tree[idx].count > 0) {
        tree[idx].sum = nums[tree[idx].r + 1] - nums[tree[idx].l];
      } else {
        if (tree[idx].l != tree[idx].r) {
          tree[idx].sum = tree[idx * 2].sum + tree[idx * 2 + 1].sum;
        } else {
          tree[idx].sum = 0;
        }
      }
    }
    public int find(long target) {
      int l = 0, r = nums.length - 1;
      // binary search
      while (l < r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] >= target) r = mid;
        else l = mid + 1;
      }
      return l;
    }
  }
}


class Segment {
  long x, y1, y2;
  int k;
  Segment(long x, long y1, long y2, int k) {
    this.x = x;
    this.y1 = y1;
    this.y2 = y2;
    this.k = k;
  }
}
class Node {
  int l, r, count;
  long sum;
  Node (int l, int r, int count, long sum) {
    this.l = l;
    this.r = r;
    this.count = count;
    this.sum = sum;
  }
}