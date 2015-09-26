/*
Problem Description:

Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6] 
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
*/

Class ZigZagIterator {
  List<Integer> iters
  int idx;
  public ZigZagIterator(int[] a1, int[] a2) {
    iters.add(a1.iterator());
    iters.add(a2.iterator());
    idx = 0;
  }
  
  public boolean hasNext() {
    if (iters.get(idx).hasNext()) {
      return true;
    }
    int i = this.idx == 0? 1:0;
    return iters.get(i).hasNext();
  }
  
  public int next() {
    iters.get(idx).next();
    moveIdx();
  }
  
  private void moveIdx() {
    int i = this.idx == 0? 1:0;
    if (iters.get(i).hasNext()) {
      this.idx = i;
    }
  }
}
