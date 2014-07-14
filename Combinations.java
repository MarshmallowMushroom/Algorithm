public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        //convert the arraylist to list interface
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (ArrayList<Integer> l : helper(list, k)) {
            List<Integer> tmp = l;
            result.add(tmp);
        }
        return result;
    }
    
    private ArrayList<ArrayList<Integer>> helper(ArrayList<Integer> num, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (k == 1) {
            for (int i : num) {
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(i);
                result.add(tmp);
            }
            return result;
        }   
        else if (k == num.size()) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(num);
            result.add(tmp);
            return result;            
        }
        else {
            int element = num.get(0);
            num.remove(0);
            ArrayList<Integer> n1 = new ArrayList<Integer>(num);
            ArrayList<Integer> n2 = new ArrayList<Integer>(num);
            ArrayList<ArrayList<Integer>> next1 = helper(n1, k-1);
            ArrayList<ArrayList<Integer>> next2 = helper(n2, k);
            for (ArrayList<Integer> list : next1) {
                list.add(0, element);
                result.add(list);
            }
            result.addAll(next2);
            return result;
        }
    }
}
