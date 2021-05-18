class LargestNumber {
  public String largestNumber(int[] nums) {
    List<String> str = new ArrayList<>();
    for (int i : nums) {
      String cur = "" + i;
      str.add(cur);
    }
    Collections.sort(str, (a,b) -> (b+a).compareTo(a+b));
    System.out.println(str);
    if (str.get(0).equals("0")) {
      return "0";
    }
    String res = "";
    for (String s : str) {
      res += s;
    }
    return res;
  }
}