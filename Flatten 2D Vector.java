Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]

public class Vector2D {

    private int arrCounter;
    private int eleCounter;
    privaet List<List<Integer>> vec;
    
    private int nextArrCounter;

    public Vector2D(List<List<Integer>> vec2d) {
      arrCounter = 0;
      eleCounter = -1;
      this.vec = vec2d;
    }

    public int next() {
      if (this.hasNext()) {
        if (eleCounter + 1 < this.vec.get(arrCounter).size())
          eleCounter++;
        } else {
          arrCounter = nextArrCounter; //assume you call hasNext() at least once before calling next();
          eleCounter = 0;
        }
        return this.vec.get(arrCounter).get(eleCounter);
      }
      //throw exception
    }

    public boolean hasNext() {
      List<Integer> curr = this.vec.get(arrCounter);
      if (eleCounter + 1 < curr.size()) {
        return true;
      }
      this.nextArrCounter = arrCounter+1;
      while(nextCounter < this.vec.size()) {
        if (this.vec.get(nextArrCounter).size() > 0)
          return true;
        nextArrCounter++;
      }
      return false;
    }
}
