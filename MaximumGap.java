class MaximumGap {
  class Range{
    int min, max;
    boolean used;
    Range(){
      this.min = Integer.MAX_VALUE;
      this.max = Integer.MIN_VALUE;
      this.used = false;
    }
  }
  public int maximumGap(int[] nums) {
    int n  = nums.length;
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for(int num : nums){
      min = Math.min(min, num);
      max = Math.max(max, num);
    }
    if(n < 2 || min == max) return 0;

    Range[] r= new Range[n - 1];
    for(int i = 0; i < n - 1; i ++){
      r[i] = new Range();
    }
    int len = (max - min + n - 2) / (n - 1);
    for(int num : nums){
      if(num == min) continue;
      int k = (num - min - 1) / len;
      r[k].used = true;
      r[k].min = Math.min(r[k].min, num);
      r[k].max = Math.max(r[k].max, num);
    }
    int res = 0;
    for(int i = 0, last = min; i < n- 1; i ++){
      if(r[i].used){
        res = Math.max(res, r[i].min - last);
        last = r[i].max;
      }
    }
    return res;
  }
}