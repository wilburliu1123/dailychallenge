class LetterCasePermutation {
  List<String> res = new ArrayList<>();
  public List<String> letterCasePermutation(String S) {
    helper(S.toCharArray(), 0);
    return res;
  }
  void helper(char[] ch, int idx) {
    if (idx >= ch.length) {
      res.add(new String(ch));
      return;
    }

    if (Character.isDigit(ch[idx])) {
      helper(ch, idx + 1);
      return;
    }
    ch[idx] = Character.toUpperCase(ch[idx]);
    helper(ch, idx + 1);
    ch[idx] = Character.toLowerCase(ch[idx]);
    helper(ch, idx + 1);
  }
}