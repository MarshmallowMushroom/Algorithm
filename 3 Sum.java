/*
Use hashSet to remove duplicate, running time nlogn
*/
public class Solution {
    //use hashset to remove duplicates
    HashSet<Triplet> visited = new HashSet<Triplet>();
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < num.length - 2; i++) {
            int i1 = num[i];
            for (List<Integer> l : twoSum(num, i+1, 0 - i1)) {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(i1);
                tmp.addAll(l);
                Triplet t = new Triplet(tmp.get(0), tmp.get(1), tmp.get(2));
                if (!visited.contains(t)) {
                    result.add(0, tmp);
                    visited.add(t);
                }
            }
        }
        return result;
    }

    
    private List<List<Integer>> twoSum(int[] num, int start, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int s = start;
        int e = num.length - 1;
        while(s < e) {
            if (num[s] + num[e] == target) {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(num[s]);
                tmp.add(num[e]);
                result.add(tmp);
                s++;
                e--;
            }
            else if (num[s] + num[e] < target) {
                s++;
            }
            else {
                e--;
            }
        }
        return result;
    }
    
    class Triplet {
        public int i, j, k;
        public Triplet(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Triplet) {
                Triplet t = (Triplet)obj;
                return (this.i == t.i && this.j == t.j && this.k == t.k);
            }
            return false;
        }
        @Override
        public int hashCode() {
            int result = i;
            result += result * 31 + j;
            result += result * 31 + k;
            return result;
        }
    }
}
